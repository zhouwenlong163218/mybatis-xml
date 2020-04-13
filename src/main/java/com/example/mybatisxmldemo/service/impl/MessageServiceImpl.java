package com.example.mybatisxmldemo.service.impl;

import com.example.mybatisxmldemo.mapper.MessageMapper;
import com.example.mybatisxmldemo.model.Message;
import com.example.mybatisxmldemo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Override
    public List<Message> findAll() {
        return messageMapper.selectAll();
    }
    @Override
    public Message findById(Integer id) {
        return messageMapper.selectById(id);
    }
    @Override
    public int insert(Message message) {
        return messageMapper.insert(message);
    }
    @Override
    public int delete(Integer id) {
        return messageMapper.delete(id);
    }
    @Override
    public int update(Message message) {
        return messageMapper.update(message);
    }
    @Override
    public int updateText(Message message) {
        return messageMapper.updateText(message);
    }
}

