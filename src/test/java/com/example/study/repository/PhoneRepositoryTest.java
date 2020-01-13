package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Phone;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PhoneRepositoryTest extends StudyApplicationTests {

    @Autowired
    private PhoneRepository phoneRepository;

    @Test
    public void create(){
        Phone phone = new Phone(3, "010-1111-1331", "kim3");
        Phone newPhone = phoneRepository.save(phone);

        System.out.println("newPhone: " + newPhone);
    }

    @Test
    public void read(){
        Optional<Phone> phone = phoneRepository.findById(1);    //db의 user table을 리스트로 전부 가져오

        phone.ifPresent(newPhone ->{
            System.out.println("newPhone: "+newPhone);
        });

    }
}
