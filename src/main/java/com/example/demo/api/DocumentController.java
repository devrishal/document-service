package com.example.demo.api;

import com.example.demo.service.BarcodeDocumentGeneratorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DocumentController {
    private final BarcodeDocumentGeneratorService barcodeDocumentGeneratorService;

    @GetMapping("/document/barcode")
    public void getDocument(HttpServletRequest request, HttpServletResponse response) {
        barcodeDocumentGeneratorService.generateDocument(request, response);
    }
}
