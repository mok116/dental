package com.example.demo.serviceImpl;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getList() {

           List<Item> getList = itemRepository.findAll();
        if (getList.isEmpty()) {
            throw new RuntimeException("item not found!");
        }
        return getList;
    }
}