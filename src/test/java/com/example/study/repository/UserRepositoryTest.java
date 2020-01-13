package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

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
    public void read(){
        Optional<User> user = userRepository.findById(2L);    //db의 user table을 리스트로 전부 가져오

        user.ifPresent(user1 ->{
            System.out.println("user: "+user1);
        });

    }

    public void update(){

    }

    public void delete(){

    }
}
