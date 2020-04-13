package com.example.mybatisxmldemo.service.impl;

import com.example.mybatisxmldemo.dao.MessageRepository;
import com.example.mybatisxmldemo.model.Messages;
import com.example.mybatisxmldemo.service.MessageService3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl3 implements MessageService3 {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void save(Messages message) {
        messageRepository.save(message);
    }

    @Override
    public void batchSave(List<Messages> messages) {
        messageRepository.saveAll(messages);
    }

    @Override
    public void delete(Integer id) {
        messageRepository.deleteById(id);
    }

    @Override
    public void batchDelete(List<Messages> messages) {
        //使用一条 SQL
        messageRepository.deleteInBatch(messages);
        //使用多条 SQL
        messageRepository.deleteAll(messages);
    }

    @Override
    public void deleteAll() {
        messageRepository.deleteAllInBatch();
//        messageRepository.deleteAll();
    }

    @Override
    public void update(Messages message) {
        messageRepository.saveAndFlush(message);
    }

    //获取持久化管理器：
    @PersistenceContext
    private EntityManager em;

    //批量更新方法
    @Transactional
    @Override
    public void batchUpdate(List<Messages> messages) {
        messages.forEach(message -> {
            em.merge(message);
        });
        em.flush();
        em.clear();
    }

    @Override
    public long count() {
        return messageRepository.count();
    }

    @Override
    public Messages getMessage(Integer id) {
        Optional<Messages> msg = messageRepository.findById(id);
        return msg.orElse(null);
    }

    @Override
    public List<Messages> getAll() {
        return messageRepository.findAll();
    }
}
