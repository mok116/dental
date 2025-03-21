package com.SEHS4701.group.serviceImpl;

import com.SEHS4701.group.dto.ItemListResponse;
import com.SEHS4701.group.model.Item;
import com.SEHS4701.group.repository.ItemRepository;
import com.SEHS4701.group.service.ItemService;
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