package com.example.salesorderservice.service;

import com.example.salesorderservice.model.OrderLineItem;
import com.example.salesorderservice.model.SalesOrder;
import com.example.salesorderservice.repository.OrderLineItemsRepository;
import com.example.salesorderservice.repository.SalesOrderRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderLineItemService {

    private OrderLineItemsRepository orderLineItemsRepository;

    public OrderLineItemService(OrderLineItemsRepository orderLineItemsRepository) {

        this.orderLineItemsRepository = orderLineItemsRepository;
    }

    // id, item_name, quantity, order_id
    public OrderLineItem add(String itemName, Long orderId, int quantity) {

        System.out.println("---Came inside the OrderLineItem --------");

        OrderLineItem orderLineItem = new OrderLineItem();

        orderLineItem.setItemName(itemName);
//        orderLineItem.setQuantity(quantity);
        orderLineItem.setQuantity(quantity);
        orderLineItem.setOrderId(orderId);


        return this.orderLineItemsRepository.save(orderLineItem);



    }

    public HashMap<String, Integer> getOrdersById(Long id)
    {
        HashMap<String, Integer> hmap = new HashMap<>();

        System.out.println("********** Entered orderLimeItemService *******************");

        List<OrderLineItem> orderListFromTable = this.orderLineItemsRepository.getOrderLineItemsByOrderId(id);
        System.out.println(orderListFromTable);

        for (OrderLineItem order: orderListFromTable) {
            hmap.put(order.getItemName(),order.getQuantity());
        }

        return hmap;
    }
}
