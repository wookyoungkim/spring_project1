package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")       //user table에 매핑시킬것임을 명시 -> 클래스의 이름과 테이블의 이름이 같으면 굳이 명시하지 않아도
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
        //변수명과 콜럼이름 같으면 굳이 명시하지 않아도 됨
    private String account;
    private String password;
    private String status;
    private String email;
    private String phoneNumber;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")      //어떤 컬럼에 매핑?
//    private List<OrderDetail> orderDetailList;
}
