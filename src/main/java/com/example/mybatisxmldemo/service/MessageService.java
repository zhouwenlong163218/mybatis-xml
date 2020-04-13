package com.example.mybatisxmldemo.service;

import com.example.mybatisxmldemo.model.Message;

import java.util.List;

public interface MessageService {
    List<Message> findAll();

    Message findById(Integer id);

    int insert(Message message);

    int delete(Integer id);

    int update(Message message);

    int updateText(Message message);
}
