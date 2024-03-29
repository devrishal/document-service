package com.rds.barcodegen.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {
    private CustomerInfo customerInfo;

    private List<Item> items;

    private double reductionPercentage;

    private double totalAmount;
    private double totalDiscount;
}
