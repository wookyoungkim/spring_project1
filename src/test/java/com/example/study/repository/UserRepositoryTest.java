package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.Assert;
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
        String account = "test03";
        String password = "pass123";
        String status = "REGISTERED";
        String email = "test03@gmail.com";
        String phoneNumber = "010-0000-0000";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "admin";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);
        Assert.assertNotNull(newUser);
    }

    @Test
    @Transactional
    public void read(){
        Optional<User> user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-0000-0000");  //제일 최근에 register된 유저 반환

        user.ifPresent(user1 ->{
               System.out.println(user);
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
