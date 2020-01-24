package com.example.salesorderservice.service;

import com.example.salesorderservice.model.Customer;
import com.example.salesorderservice.model.Item;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="item-service")
@RibbonClient(name = "item-service")
public interface ItemServiceProxy {

    @GetMapping(value = "itemController/items/{item}", produces = "application/json")
    Item get(@PathVariable("item") String item);

}