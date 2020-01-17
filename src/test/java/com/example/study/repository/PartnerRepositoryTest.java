package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Partner;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class PartnerRepositoryTest extends StudyApplicationTests {

    @Autowired
    private PartnerRepository partnerRepository;

    @Test
    public void create(){
        String name = "Partner01";
        String status = "REGISTERED";
        String address = "서울시 마포구 상수동";
        String callPartner = "070-0000-0000";
        String partnerNum = "010-1111-1111";
        String ceoName = "kim";
        LocalDateTime regTime = LocalDateTime.now();
        LocalDateTime creTime = LocalDateTime.now();
        String creBy = "admin";
        Long categoryId = 1L;

        Partner partner = new Partner();
        partner.setName(name);
        partner.setStatus(status);
        partner.setAddress(address);
        partner.setCallPartner(callPartner);
        partner.setPartnerNumber(partnerNum);
        partner.setCeoName(ceoName);
        partner.setRegisteredAt(regTime);
        partner.setCreatedAt(creTime);
        partner.setCreatedBy(creBy);
        partner.setCategoryId(categoryId);

        Partner newPartner = partnerRepository.save(partner);
        Assert.assertNotNull(newPartner);
    }
}