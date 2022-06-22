package com.example.bloggingapplication.services.impl;

import com.example.bloggingapplication.entities.Categories;
import com.example.bloggingapplication.exceptions.ResourceNotFoundException;
import com.example.bloggingapplication.payload.CategoryDTO;
import com.example.bloggingapplication.repositories.CategoryRepository;
import com.example.bloggingapplication.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryInfo) {
        Categories categories = modelMapper.map(categoryInfo, Categories.class);
        categoryRepository.save(categories);
        return modelMapper.map(categories,CategoryDTO.class);
    }

    @Override
    public CategoryDTO getCategory(long id) {
        Categories fetchedCategory = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("category","category id",id));
        return modelMapper.map(fetchedCategory,CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> getCategories(){
        List<Categories> categories = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOList = categories.stream().map((category) -> {
           return modelMapper.map(category,CategoryDTO.class);
        }).collect(Collectors.toList());
        return categoryDTOList;
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO updatedInfo,long id) {
        Categories category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("category","category id",id));
        updatedInfo.setCategoryId(id);
        Categories updatedCategory = modelMapper.map(updatedInfo,Categories.class);
        categoryRepository.save(updatedCategory);
        return modelMapper.map(updatedCategory,CategoryDTO.class);
    }

    @Override
    public CategoryDTO deleteCategory(long id) {
        Categories category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("category","category id",id));
        categoryRepository.deleteById(id);
        return modelMapper.map(category,CategoryDTO.class);
    }
}
