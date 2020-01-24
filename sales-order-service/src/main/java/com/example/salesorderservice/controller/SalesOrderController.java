package com.example.salesorderservice.controller;


import com.example.salesorderservice.model.*;
import com.example.salesorderservice.service.*;

import org.springframework.web.bind.annotation.*;

import java.util.*;



@RestController
@RequestMapping("salesOrderController")
public class SalesOrderController {

    private CreateOrderService createOrderService;
    private GetOrderByEmailService getOrderByEmailService;

    public SalesOrderController(CreateOrderService createOrderService, GetOrderByEmailService getOrderByEmailService){
        this.createOrderService = createOrderService;
        this.getOrderByEmailService = getOrderByEmailService;
    }

    @PostMapping(value = "orders", produces = "application/json")
    public String createOrder(@RequestBody customDetails orderDetails) {
        return createOrderService.createOrder(orderDetails);
    }

    @GetMapping(value = "orderDetailsByEmail/{email}", produces = "application/json")
    public List<HashMap<String,Integer>> getOrderDetailsByEmail(@PathVariable String email){
        return getOrderByEmailService.getOrderDetailsByEmail(email);
    }
}



