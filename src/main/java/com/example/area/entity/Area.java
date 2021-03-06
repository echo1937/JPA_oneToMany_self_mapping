package com.example.area.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data
@EqualsAndHashCode(exclude = "children")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 区域名
    private String name;

    // 父区域
    @ManyToOne(fetch = FetchType.LAZY)  // 相当于把2个Area写到一起;
    @JsonIgnore                         // 忽略父类属性JSON序列化;
    private Area parent;

    // 子区域，一个区域信息可以有多级子区域，比如 : 广东省 - 广州市 - 天河区
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private Set<Area> children;         // 加上@EqualsAndHashCode(exclude = "children")，就可以用Set代替List
}
