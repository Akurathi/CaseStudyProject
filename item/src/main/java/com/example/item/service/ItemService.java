package com.example.item.service;



import com.example.item.model.Item;
import com.example.item.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {

        this.itemRepository = itemRepository;
    }

    public String add(Item item) {
        List<Item> existingItems = this.getAll();
        boolean isAvailable = false;
        for (Item itm: existingItems
             ) {
            if(itm.getName().equals(item.getName()))
                isAvailable= true;
        }

        if(!isAvailable) {
            itemRepository.save(item);
            return "item added successfully...!";
        }

        return "item name is already available";
    }

    public Item get(String item) {

        System.out.println("----Coming inside the service----");
        System.out.println("item is ----> " + item);
        Item optional = itemRepository.findItemByName(item);

        System.out.println(optional);
        System.out.println("itemRepository.findItemByName(item) -> " + itemRepository.findItemByName(item));

        Item result = null;
        if (optional != null) {
            result = (Item) optional;
        }
        return result;

    }



    public List<Item> getAll() {

        return (List<Item>) itemRepository.findAll();
    }

}
