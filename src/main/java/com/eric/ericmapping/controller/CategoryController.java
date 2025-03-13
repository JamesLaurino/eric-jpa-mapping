package com.eric.ericmapping.controller;

import com.eric.ericmapping.dto.CategoryDto;
import com.eric.ericmapping.entity.CategoryEntity;
import com.eric.ericmapping.repository.CategoryRepository;
import com.eric.ericmapping.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

   @Autowired
   private CategoryRepository categoryRepository;

   @Autowired
   private CategoryService categoryService;

   // error infinite loop
    @GetMapping("erreur")
    public List<CategoryEntity> getCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("ok")
    public List<CategoryDto> getCategoryDto() {
        return categoryService.getCategories();
    }



}
