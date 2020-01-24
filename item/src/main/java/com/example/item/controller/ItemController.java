package com.example.item.controller;


import com.example.item.model.Item;
import com.example.item.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("itemController")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService) {

        this.itemService = itemService;
    }

    @PostMapping(value = "addItem" , produces = "application/json")
    public String add(@RequestBody Item item) {
        System.out.println("----Coming inside the controller---add-");
        return this.itemService.add(item);
    }


    @GetMapping(value = "items/{item}", produces = "application/json")
    public Item get(@PathVariable("item") String item) {
        System.out.println("----Coming inside the controller---get-");
        System.out.println("item is ----> " + item);
        return this.itemService.get(item);
    }




    @GetMapping(value = "getAllItems" , produces = "application/json")
    public List<Item> getAll() {
        System.out.println("----Coming inside the controller---getAll-");
        return this.itemService.getAll();
    }



}
