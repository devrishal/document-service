package com.example.demo.service;

import java.io.StringReader;
import java.util.Locale;
import java.util.Map;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BarcodeDocumentGeneratorService {
    private final TemplateEngine templateEngine;

    private final TransformerFactory tFactory = TransformerFactory.newInstance();

    public void generateDocument(HttpServletRequest request, HttpServletResponse response) {
        String data = "01234567890";
        Context context = new Context(Locale.getDefault(), Map.of("model", Map.of(
                "title", "BarCode Generation Using Apache FOP, Thymeleaf",
                "titleLine1", "and Barcode4J",
                "code39Message", data)));
        String xmlTemplate = templateEngine.process("code39", context);
        try {
            response.setContentType("application/pdf");
            FopFactory fopFactory = FopFactory.newInstance();
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, response.getOutputStream());
            Transformer transformer = tFactory.newTransformer();
            Source src = new StreamSource(new StringReader(xmlTemplate));
            Result res = new SAXResult(fop.getDefaultHandler());
            transformer.transform(src, res);
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
