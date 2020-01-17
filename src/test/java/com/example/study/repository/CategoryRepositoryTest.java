package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Category;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CategoryRepositoryTest extends StudyApplicationTests {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void create(){
        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime now = LocalDateTime.now();
        String createdBy = "admin";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(now);
        category.setCreatedBy(createdBy);

        Category newCategory = categoryRepository.save(category);

        Assert.assertNotNull(newCategory);
        Assert.assertEquals(newCategory.getType(), type);
        Assert.assertEquals(newCategory.getTitle(), title);

    }

    @Test
    public void read(){

        String type = "PHONE";
        Optional<Category> optionalCategory = categoryRepository.findByType(type);

        optionalCategory.ifPresent(category -> {
            Assert.assertEquals(category.getType(), type);

            System.out.println(category.getId());
            System.out.println(category.getTitle());
            System.out.println(category.getType());
        });
    }
}
