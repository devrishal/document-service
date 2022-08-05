package com.rds.barcodegen.service;

import com.rds.barcodegen.config.ApplicationConfig;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.thymeleaf.context.Context;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Locale;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DocumentServiceApacheFOP {
    private final ApplicationConfig applicationConfig;

    public void generatePDF(HttpServletRequest request, HttpServletResponse response) {
        String data = RandomStringUtils.random(20, 0, 0, true, true, null).toUpperCase();
        Context context = new Context(Locale.getDefault(), Map.of("model", Map.of(
                "title", "BarCode Generation Using Apache FOP",
                "titleLine1", "and Barcode4J",
                "code39Message", data)));
        String xmlTemplate = applicationConfig.templateProcessorEngine().process("code39", context);

        try {
            File confFile = ResourceUtils.getFile("classpath:configuration.xconf");
            FopFactory fopFactory = FopFactory.newInstance();
            fopFactory.setUserConfig(confFile);
            DefaultHandler defaultHandler = fopFactory.newFop(MimeConstants.MIME_PDF, response.getOutputStream()).getDefaultHandler();
            Source src = new StreamSource(new StringReader(xmlTemplate));
            Result res = new SAXResult(defaultHandler);
            TransformerFactory.newInstance().newTransformer().transform(src, res);
        } catch (IOException | TransformerException | SAXException e) {
            e.printStackTrace();
        }
    }
}
