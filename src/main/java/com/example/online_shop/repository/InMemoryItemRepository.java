package com.example.online_shop.repository;

import com.example.online_shop.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class InMemoryItemRepository implements ItemRepository {

    private final List<Item> inMemoryItemDatabase;

    @Autowired
    public InMemoryItemRepository(List<Item> inMemoryItemDatabase) {
        this.inMemoryItemDatabase = inMemoryItemDatabase;
    }

    @Override
    public List<Item> getAll() {
        return new ArrayList<>(inMemoryItemDatabase);
    }

    @Override
    public Optional<Item> findById(int id) {
        return inMemoryItemDatabase
                .stream()
                .filter(item -> item.getId() == id)
                .findAny();
    }

    @Override
    public Item save(Item item) {
        item.setId(inMemoryItemDatabase.size() + 1);
        inMemoryItemDatabase.add(item);
        return item;
    }

    @Override
    public void delete(int id) {
        boolean deleted = inMemoryItemDatabase.removeIf(item -> item.getId() == id);
        if(!deleted) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Item update(int id, Item item) {
        Item itemToUpdate = inMemoryItemDatabase
                .stream()
                .filter(i -> i.getId() == id)
                .findAny()
                .orElseThrow();

        itemToUpdate.setName(item.getName());
        itemToUpdate.setPrice(item.getPrice());
        return itemToUpdate;
    }
}
