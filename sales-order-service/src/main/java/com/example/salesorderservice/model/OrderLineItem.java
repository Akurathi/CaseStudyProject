package com.example.salesorderservice.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;


@Data
@Entity(name = "OrderLineItem")
@Table(name = "orderlineitem")
public class OrderLineItem {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String itemName;

   private int quantity;

    private Long orderId;

}
