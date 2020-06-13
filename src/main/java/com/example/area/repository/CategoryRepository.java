package com.example.area.repository;

import com.example.area.entity.Category;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    /**
     * 解决 懒加载 JPA 典型的 N + 1 问题
     */
    @EntityGraph(value = "Category.Graph", type = EntityGraph.EntityGraphType.FETCH)
    List<Category> findAll();

//    @EntityGraph(value = "Category.Graph", type = EntityGraph.EntityGraphType.FETCH)  // 无效, 始终存在N+1问题
    Category findByName(String name);

    @EntityGraph(value = "Category.Graph", type = EntityGraph.EntityGraphType.FETCH)  // 无效, 始终存在N+1问题
    Optional<Category> findById(Long id);
}
