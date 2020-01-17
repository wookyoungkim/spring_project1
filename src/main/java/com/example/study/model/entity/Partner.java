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
public class Partner {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private String status;
    private String address;
    private String callPartner;
    private String partnerNumber;
    private String businessNumber;
    private String ceoName;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private Long categoryId;

//    @ManyToOne
//    private Category category;
}
