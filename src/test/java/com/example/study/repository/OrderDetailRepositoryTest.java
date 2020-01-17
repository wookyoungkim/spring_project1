package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends StudyApplicationTests {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create() {

        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setStatus("WAITING");
        orderDetail.setArrivalDate(LocalDateTime.now().plusDays(2));
        orderDetail.setQuantity(1);
        orderDetail.setTotalPrice(BigDecimal.valueOf(9999999));
        orderDetail.setCreatedAt(LocalDateTime.now());
        orderDetail.setCreatedBy("admin");
        orderDetail.setItemId(1L);      //어떤 상품?
        orderDetail.setOrderGroupId(1L);    //어떤 장바구니에?


        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);  //db에 저장된 새 객 user 반환-> auto increment된 id값까지

        System.out.println("newOrder: " + newOrderDetail);



    }
}
