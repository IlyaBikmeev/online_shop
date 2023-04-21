package com.example.online_shop.repository;

import com.example.online_shop.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemRepository {
    List<Item> getAll();
    Optional<Item> findById(int id);

    Item save(Item item);

    void delete(int id);

    Item update(int id, Item item);
}
