package com.rds.barcodegen;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ApplicationTest {
    @Test
    public void generatePDFwithBarcode() {
        Map<String, String> modelMap = Map.of(
                "title", "BarCode Generation Using Apache FOP",
                "titleLine1", "and Barcode4J");
    }
}
