package com.example.online_shop.controller;

import com.example.online_shop.model.Item;
import com.example.online_shop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
GET /items  - получить все продукты
GET /items/{id}  - получить конкретный продукт по его id
POST /items - создать продукт (в теле запроса передаём продукт)
PUT /items/{id}  - изменить продукт (в теле запроса передаём новые данные)
DELETE /items/{id} - удалить продукт
 */

@RestController
@RequestMapping(value = "/items")
public class ItemController {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public List<Item> getAllProducts() {
        return itemRepository.getAll();
    }

    @GetMapping("/{itemId}")
    public Item getById(@PathVariable(value = "itemId") int id) {
        return itemRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable int id, @RequestBody Item item) {
        return itemRepository.update(id, item);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id) {
        itemRepository.delete(id);
        return String.format("Item with id %d has been successfully deleted!", id);
    }
}
