package com.rds.barcodegen.api.rest;

import com.rds.barcodegen.api.swagger.DocumentResponse;
import com.rds.barcodegen.model.OrderDetail;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;

public interface DocumentResource {
    @Operation(summary = "Download PDF with Code39 Barcode")
    @DocumentResponse
    @GetMapping(path = "/barcode", produces = { APPLICATION_OCTET_STREAM_VALUE, APPLICATION_JSON_VALUE })
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

    @Operation(summary = "Download PDF for Bills")
    @DocumentResponse
    @PostMapping(path = "/bill", produces = { APPLICATION_OCTET_STREAM_VALUE, APPLICATION_JSON_VALUE })
    public void downloadBill(@RequestBody OrderDetail orderDetail, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;


}
