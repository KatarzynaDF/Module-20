package com.kodillapatterns2a.facade.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    private final List<ItemDto> items = new ArrayList<>();

    public void addItem(final ItemDto item){
        items.add(item);
    }

    public List<ItemDto> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "items=" + items +
                '}';
    }
}