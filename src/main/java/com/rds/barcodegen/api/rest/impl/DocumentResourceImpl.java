package com.rds.barcodegen.api.rest.impl;

import java.io.IOException;

import com.rds.barcodegen.api.rest.DocumentResource;
import com.rds.barcodegen.model.OrderDetail;
import com.rds.barcodegen.service.impl.BarcodeDocumentServiceImpl;
import com.rds.barcodegen.service.impl.BillDocumentServiceImpl;
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
    private final BarcodeDocumentServiceImpl barcodeDocumentServiceImpl;

    private final BillDocumentServiceImpl billDocumentService;

    @Override
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        response.setStatus(HttpStatus.OK.value());
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Test.pdf");
        barcodeDocumentServiceImpl.generatePDF(request, response);
    }

    @Override
    public void downloadBill(OrderDetail orderDetail, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        billDocumentService.downloadBill(orderDetail, response);
    }
}
