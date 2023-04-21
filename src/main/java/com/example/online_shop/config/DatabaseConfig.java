package com.example.online_shop.config;

import com.example.online_shop.model.Item;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DatabaseConfig {

    @Bean
    public List<Item> simpleInMemoryDatabase() {
        return new ArrayList<>(List.of(
           new Item(1, "Чай", 345.64),
           new Item(2, "Кофе", 657.53),
           new Item(3, "Куриное филе, 1кг", 456.46),
           new Item(4, "Говядина вырезка, 1кг", 567.54),
           new Item(5, "Хлопья овсяные", 253.53)
        ));
    }
}
