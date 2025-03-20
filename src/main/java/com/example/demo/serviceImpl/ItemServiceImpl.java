package com.example.demo.serviceImpl;

import com.example.demo.dto.ItemListResponse;
import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public ItemListResponse getList() {

           List<Item> items = itemRepository.findAll();
        if (items.isEmpty()) {
            throw new RuntimeException("item not found!");
        }
        return new ItemListResponse(items.stream().map(item -> modelMapper.map(item, ItemListResponse.Item.class))
                .collect(Collectors.toList()));
    }
}