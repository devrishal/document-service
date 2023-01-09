package com.rds.barcodegen.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import com.rds.barcodegen.exception.DocumentServiceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import static java.lang.Boolean.FALSE;
import static net.sf.saxon.lib.FeatureKeys.ALLOWED_PROTOCOLS;
import static net.sf.saxon.lib.FeatureKeys.ALLOW_EXTERNAL_FUNCTIONS;
import static net.sf.saxon.lib.FeatureKeys.DTD_VALIDATION;

@Slf4j
@Service
@RequiredArgsConstructor
public class DocumentServiceApacheFOP {
    private final TemplateEngine templateEngine;

    public void generatePDF(HttpServletRequest request, HttpServletResponse response) {
        String data = RandomStringUtils.random(20, 0, 0, true, true, null).toUpperCase();
        Context context = new Context(Locale.getDefault(), Map.of("model", Map.of(
                "title", "BarCode Generation Using Apache FOP",
                "titleLine1", "and Barcode4J",
                "code39Message", data)));
        String xmlTemplate = templateEngine.process("code39", context);

        try {
            InputStream inputStream = new ClassPathResource("configuration.xconf").getInputStream();
            FopFactory fopFactory = FopFactory.newInstance(new URI("./"), inputStream);
            DefaultHandler defaultHandler = fopFactory.newFop(MimeConstants.MIME_PDF, response.getOutputStream()).getDefaultHandler();
            Source src = new StreamSource(new StringReader(xmlTemplate));
            Result result = new SAXResult(defaultHandler);
            TransformerFactory transformerFactory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl", null);
            transformerFactory.setFeature(DTD_VALIDATION, FALSE);
            transformerFactory.setFeature(ALLOW_EXTERNAL_FUNCTIONS, FALSE);
            transformerFactory.setAttribute(ALLOWED_PROTOCOLS, "");
            transformerFactory.newTransformer().transform(src, result);
        }
        catch (IOException | TransformerException | SAXException | URISyntaxException e) {
            throw new DocumentServiceException("Exception occured:", e);
        }
    }
}
