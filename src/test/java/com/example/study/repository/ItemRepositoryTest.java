package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class ItemRepositoryTest extends StudyApplicationTests {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){

        Item item = new Item();
        item.setStatus("UNREGISTERED");
        item.setName("Iphone 8");
        item.setTitle("IPHONE 8 MAX");
        item.setContent("아이폰 8 입니당");
        item.setPrice(90000);
        item.setBrandName("Apple");
        item.setRegisteredAt(LocalDateTime.now());
        item.setCreatedAt(LocalDateTime.now());
        item.setCreatedBy("admin");
        item.setPartnerId(1L);

        Item newItem = itemRepository.save(item);  //db에 저장된 새 객 user 반환-> auto increment된 id값까지
        Assert.assertNotNull(newItem);
    }
}
