package com.example.area.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * 典型的 多层级 分类
 * <p>
 * :@NamedEntityGraph :注解在实体上 , 解决典型的N+1问题
 * name表示实体图名, 与 repository中的注解 @EntityGraph的value属性相对应,
 * attributeNodes 表示被标注要懒加载的属性节点 比如此例中 : 要懒加载的子分类集合children
 */

@Entity
@Table
@Data
@NamedEntityGraph(name = "Category.Graph", attributeNodes = {@NamedAttributeNode("children")})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 分类名
    private String name;

    // 一个商品分类下面可能有多个商品子分类(多级) 比如 分类 : 家用电器  (子)分类 : 电脑  (孙)子分类 : 笔记本电脑
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Category parent;                //父分类

//    @JsonInclude(JsonInclude.Include.NON_EMPTY)   // 不要使用值為null或內容為空的屬性。
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private List<Category> children;       //子分类集合
}
