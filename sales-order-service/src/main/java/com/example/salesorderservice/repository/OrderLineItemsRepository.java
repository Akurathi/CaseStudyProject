package com.example.salesorderservice.repository;

import com.example.salesorderservice.model.OrderLineItem;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderLineItemsRepository extends CrudRepository<OrderLineItem, Long> {

    List<OrderLineItem> getOrderLineItemsByOrderId(Long id);
}
