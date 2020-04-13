package com.example.mybatisxmldemo.model.cascade;

import lombok.Data;


import java.sql.Timestamp;

@Data
@Entity
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;//id
    @Column(name = "name",nullable = true,length = 20)
    private String name;//姓名
    @Column(name = "sex",nullable = true,length = 1)
    private String sex;//性别
    @Column(name = "birthday",nullable = true)
    private Timestamp birthday;//出生日期
    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "address_id",referencedColumnName = "id")
    private Address address;//地址


}
