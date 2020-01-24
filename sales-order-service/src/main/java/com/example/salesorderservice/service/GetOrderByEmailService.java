package com.example.salesorderservice.service;

import com.example.salesorderservice.controller.SalesOrderController;
import com.example.salesorderservice.model.SalesOrder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class GetOrderByEmailService {

    private SalesOrderService salesOrderService;
    private OrderLineItemService orderLineItemService;
    private CustomerService customerService;
    private ItemService itemService;
    private static final Logger LOG = Logger.getLogger(SalesOrderController.class.getName());


    public GetOrderByEmailService(SalesOrderService salesOrderService, OrderLineItemService orderLineItemService, CustomerService customerService, ItemService itemService) {
        this.customerService = customerService;
        this.salesOrderService = salesOrderService;
        this.orderLineItemService = orderLineItemService;
        this.itemService = itemService;
    }

    public List<HashMap<String,Integer>> getOrderDetailsByEmail(String email){

        LOG.log(Level.INFO, "You reached order by email method");
        HashMap<String, Integer> hmap = new HashMap<>();
        List<HashMap<String,Integer>> finalList = new ArrayList<>();
        List<SalesOrder> orderIdIs = this.salesOrderService.getOrderIdByEmail(email);
        System.out.println("------orderIdIs---------" + orderIdIs);

        System.out.println("---Calling salesorder Service with orderId" );

        for (SalesOrder salesOrder: orderIdIs) {
            hmap = this.orderLineItemService.getOrdersById(salesOrder.getId());
            finalList.add(hmap);
        }
        return finalList;

    }


}
