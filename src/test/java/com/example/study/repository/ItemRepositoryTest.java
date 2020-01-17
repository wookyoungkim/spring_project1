package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ItemRepositoryTest extends StudyApplicationTests {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){

        Item item = new Item();

        item.setName("iphone");
        item.setPrice(20000);
        item.setContent("iphone 8max");

        Item newItem = itemRepository.save(item);  //db에 저장된 새 객 user 반환-> auto increment된 id값까지

        System.out.println("newItem: " + newItem);
    }
}
