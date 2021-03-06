package com.example.study.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderDetail {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String status;
    private LocalDateTime arrivalDate;
    private Integer quantity;
    private BigDecimal totalPrice;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
    private Long itemId;
    private Long orderGroupId;


}
