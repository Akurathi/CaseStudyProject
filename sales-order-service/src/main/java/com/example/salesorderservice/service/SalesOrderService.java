package com.example.salesorderservice.service;


import com.example.salesorderservice.model.SalesOrder;
import com.example.salesorderservice.model.customDetails;
import com.example.salesorderservice.repository.SalesOrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Service
public class SalesOrderService {

    private SalesOrderRepository salesOrderRepository;

    public SalesOrderService(SalesOrderRepository salesOrderRepository) {

        this.salesOrderRepository = salesOrderRepository;
    }

    public SalesOrder add(LocalDateTime Date, String Email, String Description, Double Price) {

        System.out.println("----Inside the sales order service -----");
        System.out.println();
        SalesOrder salesOrder = new SalesOrder();

        salesOrder.setPrice(Price);
        salesOrder.setEmail(Email);
        salesOrder.setDescription(Description);
        salesOrder.setDate(Date);

        System.out.println("---salesOrder -----" + salesOrder);
        return this.salesOrderRepository.save(salesOrder);


    }

    public List<SalesOrder> getOrderIdByEmail(String email)
    {
        List<SalesOrder> salesOrder = null;
        salesOrder = this.salesOrderRepository.findAllByEmail(email);


        return salesOrder;
    }



}
