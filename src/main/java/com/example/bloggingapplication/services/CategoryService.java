package com.example.bloggingapplication.services;

import com.example.bloggingapplication.payload.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO categoryInfo);
    CategoryDTO getCategory(long id);
    List<CategoryDTO> getCategories();
    CategoryDTO updateCategory(CategoryDTO categoryInfo,long id);
    CategoryDTO deleteCategory(long id);
}
