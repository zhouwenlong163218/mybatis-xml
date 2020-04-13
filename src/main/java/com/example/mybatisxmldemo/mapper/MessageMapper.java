package com.example.mybatisxmldemo.mapper;

import com.example.mybatisxmldemo.model.Message;

import java.util.List;

public interface MessageMapper {
     List<Message> selectAll();

     Message selectById(Integer id);

     int insert(Message message);

     int delete(Integer id);

     int update(Message message);

     int updateText(Message message);

     int batchInsert(List<Message> messages);

     List<Message> selectByCondition(Message message);
}
