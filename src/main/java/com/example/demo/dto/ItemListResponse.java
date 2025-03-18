package com.example.demo.dto;

import com.example.demo.model.Item;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class ItemListResponse extends BaseResponse {
    private List<Item> ItemList;

    public ItemListResponse(List<Item> ItemList) {
        this.ItemList = ItemList;
    }
}
