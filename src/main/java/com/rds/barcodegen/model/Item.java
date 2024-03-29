package com.rds.barcodegen.model;

import lombok.Data;

@Data
public class Item {
    private String itemId;

    private double quantity;

    private String itemName;

    private double perUnitPrice;

    private double itemPrice;
}
