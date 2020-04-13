package com.example.mybatisxmldemo.model.cascade;

import lombok.Data;



/**
 * @author Lenovo
 */
@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;//id
    @Column(name = "phone",nullable = true,length = 11)
    private String phone;//手机
    @Column(name = "zipcode",nullable = true,length = 6)
    private String zipcode;//邮政编码
    @Column(name = "address",nullable = true,length = 100)
    private String address;//地址
    @OneToOne(mappedBy = "address",cascade ={CascadeType.MERGE,
    CascadeType.REFRESH},optional = false)
    private People people;


}
