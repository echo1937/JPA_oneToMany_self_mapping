package com.example.area.controller;

import com.example.area.entity.Category;
import com.example.area.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Output {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("category")
    public Category getCategory() {
        List<Category> categories = categoryRepository.findAll();
        // return categories.get(0); // 一条SQL
        // return categories.stream().filter(category -> category.getName().equals("家用电器")).findFirst().orElse(null); // 一条SQL
        return categoryRepository.findByName("家用电器"); // 无论findByName(String name)方法加不加@EntityGraph，都只会触发两条SQL，如果和下文对比会更神奇
    }

    @GetMapping("category/name/{name}")
    public Category getCategoryByName(@PathVariable String name) {
        // 虽然findByName(String name)添加了@EntityGraph，但是没有起作用, 依然存在N+1问题
        return categoryRepository.findByName(name);
    }

    @GetMapping("category/id/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        // 虽然findById(Long id)添加了@EntityGraph，但是没有起作用, 依然存在N+1问题
        return categoryRepository.findById(id).orElse(null);
    }

    @GetMapping("categories")
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
