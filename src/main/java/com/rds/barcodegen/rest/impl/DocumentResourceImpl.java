package com.rds.barcodegen.rest.impl;

import com.rds.barcodegen.rest.DocumentResource;
import com.rds.barcodegen.service.DocumentService;
import com.rds.barcodegen.service.DocumentServiceApacheFOP;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class DocumentResourceImpl implements DocumentResource {
    private final DocumentService documentService;
    private final DocumentServiceApacheFOP documentServiceApacheFOP;
    private final MessageSource messageSource;
    @Override
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Test.pdf");
        documentServiceApacheFOP.generatePDF(request,response);
        //documentService.downloadDocument(request, response);

    }
}
