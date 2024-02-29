package com.rds.barcodegen.api.rest.impl;

import java.io.IOException;

import com.rds.barcodegen.api.rest.DocumentResource;
import com.rds.barcodegen.service.DocumentServiceApacheFOP;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DocumentResourceImpl implements DocumentResource {
    private final DocumentServiceApacheFOP documentServiceApacheFOP;

    @Override
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setStatus(HttpStatus.OK.value());
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Test.pdf");
        documentServiceApacheFOP.generatePDF(request, response);
    }
}
