package com.example.mybatisxmldemo.service;

import com.example.mybatisxmldemo.model.Messages;

import java.util.List;

public interface MessageService3 {
    void save(Messages message);
    void batchSave(List<Messages> messages);

    void delete(Integer id);
    void batchDelete(List<Messages> messages);
    void deleteAll();

    void update(Messages message);
    void batchUpdate(List<Messages> messages);

    long count();

    Messages getMessage(Integer id);
    List<Messages> getAll();
}
