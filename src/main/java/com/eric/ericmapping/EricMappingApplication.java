package com.eric.ericmapping;

import com.eric.ericmapping.entity.CategoryEntity;
import com.eric.ericmapping.entity.ProductEntity;
import com.eric.ericmapping.repository.CategoryRepository;
import com.eric.ericmapping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EricMappingApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(EricMappingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName("Eric Mapping");
        categoryRepository.save(categoryEntity);

        ProductEntity productEntity = new ProductEntity();
        productEntity.setCategory(categoryEntity);
        productRepository.save(productEntity);
    }
}
