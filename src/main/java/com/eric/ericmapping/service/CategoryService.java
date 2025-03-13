package com.eric.ericmapping.service;

import com.eric.ericmapping.dto.CategoryDto;
import com.eric.ericmapping.dto.ProductDto;
import com.eric.ericmapping.entity.CategoryEntity;
import com.eric.ericmapping.entity.ProductEntity;
import com.eric.ericmapping.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDto> getCategories() {

        List<CategoryDto> categoryDtoList = new ArrayList<>();
        List<CategoryEntity> categoryEntities = categoryRepository.findAll();

        List<ProductDto> productDtoList = new ArrayList<>();

        for (CategoryEntity categoryEntity : categoryEntities) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(categoryEntity.getId());
            categoryDto.setName(categoryEntity.getName());

            for(ProductEntity productEntity: categoryEntity.getProducts()) {
                ProductDto productDto = new ProductDto();
                productDto.setId(productEntity.getId());

                productDtoList.add(productDto);

                categoryDto.setProducts(productDtoList);

            }

            categoryDtoList.add(categoryDto);

        }

        return categoryDtoList;
    }

}
