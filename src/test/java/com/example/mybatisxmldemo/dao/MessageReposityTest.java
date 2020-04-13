package com.example.mybatisxmldemo.dao;


import com.example.mybatisxmldemo.model.Messages;
import com.example.mybatisxmldemo.model.Page;
import com.example.mybatisxmldemo.service.MessageService3;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import jdk.internal.jline.internal.Log;
@Slf4j
@SpringBootTest
public class MessageReposityTest {
    private Log log;
    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void testSave(){
        Messages message = Messages.builder().msgText("computer").msgSummary("学习").build();
        //保存单个对象
        messageRepository.save(message);

        List<Messages> messages = new ArrayList<>(Arrays.asList(
                Messages.builder().msgText("apple").msgSummary("水果").build(),
                Messages.builder().msgText("orange").msgSummary("水果").build(),
                Messages.builder().msgText("banana").msgSummary("水果").build()));
        //保存多个
        messageRepository.saveAll(messages);
    }
    @Test
    public void testDelete(){
        Messages message = Messages.builder().msgId(1)
                .msgText("computer").msgSummary("学习").build();

        //删除单条记录
//        根据主键删除
        messageRepository.deleteById(1);
        //提供对象，根据主键删除
        messageRepository.delete(message);

        //删除集合
        message = Messages.builder().msgId(2)
                .msgText("computer").msgSummary("学习").build();
        List<Messages> messages = new ArrayList<>();
        messages.add(message);
        message = Messages.builder().msgId(3)
                .msgText("computer").msgSummary("学习").build();
        messages.add(message);
        //删除集合：一条一条删除
        messageRepository.deleteAll(messages);
        //删除集合：一条sql,拼接 or语句
        messageRepository.deleteInBatch(messages);

        //删除全部
        //删除所有：先findAll，然后一条一条删除，最后提交事务
        messageRepository.deleteAll();
        //删除所有：使用一条sql
        messageRepository.deleteAllInBatch();
    }

    @Autowired
    private MessageService3 messageService;

    @Test
    public void testUpdate(){
        //根据主键更新
        Messages message = Messages.builder().msgId(7)
                .msgText("笔记本").msgSummary("学习").build();
        messageRepository.saveAndFlush(message);

        //批量更新
        List<Messages> messages = new ArrayList<>();
        messages.add(Messages.builder().msgId(8).msgText("笔记本").msgSummary("学习").build());
        messages.add(Messages.builder().msgId(9).msgText("开学").msgSummary("学习").build());
        messageService.batchUpdate(messages);
    }

    //简单查询
    @Test
    public void testSelect() {
        //查询所有
        messageRepository.findAll().forEach(msg -> log.info(msg.toString()));

        //分页查询全部
        Page<Messages> pageInfo = messageRepository.findAll(
                PageRequest.of(1,3, Sort.Direction.ASC,"msgId"));
        log.info("分页查询结果：");
        pageInfo.get().forEach(System.out::print);

        //条件查询
        Messages message = Messages.builder().msgSummary("水果").build();
        List<Messages> messages = messageRepository.findAll(Example.of(message));
        log.info("满足summary是水果的message有：");
        messages.forEach(msg -> log.info(msg.toString()));

        //单个查询
        Messages msg = Messages.builder().msgId(2).build();
        Optional<Messages> optionalMessage = messageRepository.findOne(Example.of(msg));
        log.info("单个查询结果：{}",optionalMessage.orElse(null));
    }
}
