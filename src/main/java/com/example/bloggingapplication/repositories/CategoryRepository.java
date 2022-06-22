package com.example.bloggingapplication.repositories;

import com.example.bloggingapplication.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categories,Long> {
}
