package com.example.mybatisxmldemo.model.cascade;

import lombok.Data;


import java.util.List;

/**
 * @author Lenovo
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 20,unique = true)
    private String username;//用户账号

    @Column(length = 100)
    private String password;//登录时密码

    @ManyToMany
    @JoinTable(name = "user_authority",joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private List<Authority> authorityList;

}
