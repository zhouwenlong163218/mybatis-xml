package com.example.mybatisxmldemo.model.cascade;

import lombok.Data;
import org.apache.ibatis.mapping.FetchType;


import java.util.List;

/**
 * @author Lenovo
 */
@Data
@Entity
public class Author {
    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//id

    @Column(nullable = false,length = 20)
    private String name;//姓名

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Article> articleList;  //文章列表
}
