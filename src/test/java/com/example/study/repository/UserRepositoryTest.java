package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserRepositoryTest extends StudyApplicationTests{

    @Autowired      //Dependency Injection: 의존성 주입 -> 직접 객체를 만들지 않고 스프링이 직접 관리, 의존성 주
    private UserRepository userRepository;


    @Test           //test실행시 해당 annotation 필요
    public void create(){
        //쿼리문이 아닌 오브젝트를 이용해 데이터 관리 가능

        User user = new User();
        //user.setId();     -> auto increment 설정되어있음으로 값 설정해줄 필요 x
        user.setAccount("TestUser02");
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1111-1221");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser02");

        User newUser = userRepository.save(user);  //db에 저장된 새 객 user 반환-> auto increment된 id값까지

        System.out.println("newUser: " + newUser);

    }

    @Test
    @Transactional
    public void read(){
        Optional<User> user = userRepository.findByAccount("TestUser02");    //db의 user table을 리스트로 전부 가져오

        user.ifPresent(user1 ->{
           user1.getOrderDetailList().stream().forEach(orderDetail -> {
               Item item = orderDetail.getItem();
               System.out.println(item);
           });
        });
    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(user1 -> {
            user1.setAccount("updated_user");
            user1.setUpdatedAt(LocalDateTime.now());
            user1.setUpdatedBy("update method");

            userRepository.save(user1);
        });

    }

    @Test
    public void delete(){      //특정 아이디로 삭제하기기
        Optional<User> user = userRepository.findById(1L);

        assertTrue(user.isPresent());    // true

        user.ifPresent(user1 -> {
            userRepository.delete(user1);   //delete()는 반환형이 x
        });

        Optional<User> deletedUser = userRepository.findById(1L);

        assertFalse(deletedUser.isPresent());
   }
}
