package com.example.mybatisxmldemo.model.cascade;

import lombok.Data;
import org.apache.ibatis.mapping.FetchType;


@Data
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增长策略
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(nullable = false,length = 50)
    private String title;

    @Lob
    @Basic(fetch = FetchType.LAZY)//懒加载
    @Column(nullable = false)
    private String content;//文章全文内容

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
    @JoinColumn(name = "author_id")
    private Author author;//所属作者


}
