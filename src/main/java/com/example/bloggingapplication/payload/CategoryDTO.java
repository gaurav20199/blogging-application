package com.example.bloggingapplication.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDTO {

    private long categoryId;
    @NotBlank
    @Size(min = 2,max = 20, message = "category name should be minimum of 2 characters and max of 20 characters")
    private String categoryName;
    @NotBlank
    @Size(min = 2,max = 100, message = "category description should be minimum of 2 characters and max of 100 characters")
    private String categoryDesc;
}
