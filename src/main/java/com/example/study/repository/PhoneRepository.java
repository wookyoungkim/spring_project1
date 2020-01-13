package com.example.study.repository;

import com.example.study.model.entity.Phone;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends ElasticsearchRepository<Phone, Integer> {
}
