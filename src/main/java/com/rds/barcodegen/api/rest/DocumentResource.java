package com.rds.barcodegen.api.rest;

import com.rds.barcodegen.api.swagger.DocumentResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface DocumentResource {
    @Operation(summary = "Download PDF with Code39 Barcode")
    @DocumentResponse
    @GetMapping(path = "/download", produces = {MediaType.APPLICATION_OCTET_STREAM_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}
