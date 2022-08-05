package com.rds.barcodegen.api.rest.impl;

import com.rds.barcodegen.api.rest.DocumentResource;
import com.rds.barcodegen.service.DocumentService;
import com.rds.barcodegen.service.DocumentServiceApacheFOP;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class DocumentResourceImpl implements DocumentResource {
    private final DocumentService documentService;
    private final DocumentServiceApacheFOP documentServiceApacheFOP;
    private final MessageSource messageSource;
    @Override
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setStatus(HttpStatus.OK.value());
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Test.pdf");
        documentServiceApacheFOP.generatePDF(request,response);
        //documentService.downloadDocument(request, response);

    }
}
