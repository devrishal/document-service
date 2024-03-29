package com.rds.barcodegen.service.impl;

import java.util.Locale;
import java.util.Map;

import com.rds.barcodegen.service.AbstractDocumentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BarcodeDocumentServiceImpl extends AbstractDocumentService {
    private final TemplateEngine templateEngine;

    public void generatePDF(HttpServletRequest request, HttpServletResponse response) {
        String data = RandomStringUtils.random(20, 0, 0, true, true, null).toUpperCase();
        Context context = new Context(Locale.getDefault(), Map.of("model", Map.of(
                "title", "BarCode Generation Using Apache FOP",
                "titleLine1", "and Barcode4J",
                "code39Message", data)));
        generateDocument(response, templateEngine.process("code39", context));
    }
}
