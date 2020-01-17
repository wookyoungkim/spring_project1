package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.OrderGroup;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderGroupRepositoryTest extends StudyApplicationTests {

    @Autowired
    private OrderGroupRepository orderGroupRepository;

    public void create(){
        OrderGroup orderGroup = new OrderGroup();

        orderGroup.setStatus("COMPLETED");
        orderGroup.setOrderType("ALL");
        orderGroup.setRevAddress("서울시 마포구 상수동");
        orderGroup.setRevName("kim");
        orderGroup.setPaymentType("CARD");
        orderGroup.setTotalPrice(BigDecimal.valueOf(999999));
        orderGroup.setTotalQuantity(10);
        orderGroup.setOrderAt(LocalDateTime.now().minusDays(2));
        orderGroup.setArrivalDate(LocalDateTime.now());
        orderGroup.setCreatedAt(LocalDateTime.now());
        orderGroup.setCreatedBy("admin");
        orderGroup.setUserId(1L);
    }
}
