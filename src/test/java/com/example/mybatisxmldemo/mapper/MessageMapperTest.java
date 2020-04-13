package com.example.mybatisxmldemo.mapper;

import com.example.mybatisxmldemo.model.Message;
import jdk.internal.jline.internal.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MessageMapperTest {
    @Resource
    private MessageMapper1 messageMapper;
    @Test
    @Order(1)
    public void testInsert() {
        Message message = Message.builder().msgText("niit").msgSummary("学校").build();
        int num = messageMapper.insert(message);
        Log.info("插入的数据条数： {}", num);
    }

    @Test
    @Order(2)
    public void testBatchInsert() {
        List<Message> messages = new ArrayList<>(Arrays.asList(
                Message.builder().msgText("apple").msgSummary("水果").build(),
                Message.builder().msgText("orange").msgSummary("水果").build()));
        int num = messageMapper.batchInsert(messages);
        Log.info("插入的数据条数： {}", num);
    }

    @Test
    @Order(3)
    public void testFindAll() {
        messageMapper.selectAll().forEach(
                message -> Log.info("查询的数据： {}", message.toString()));
    }

    @Test
    @Order(4)
    public void testUpdate() {
        Message message = Message.builder().msgId(1).msgText("computer").msgSummary("学校").build();
        int num = messageMapper.update(message);
        Log.info("更新的数据条数： {}", num);
    }

    @Test
    @Order(5)
    public void testUpdateText() {
        Message message = Message.builder().msgId(2).msgText("computer").msgSummary("学校").build();
        int num = messageMapper.updateText(message);
        Log.info("更新Text的数据条数： {}", num);
    }

    @Test
    @Order(6)
    public void testFindById() {
        Message message = messageMapper.selectById(1);
        Log.info("id为1的数据： {}", message);
    }

    @Test
    @Order(7)
    public void testDelete() {
        int num = messageMapper.delete(1);
        Log.info("删除的数据条数： {}", num);
    }

    @Test
    @Order(8)
    public void testfindWithRowBounds() {
        messageMapper.findAllWithRowBounds(new RowBounds(1, 3))
                .forEach(message -> Log.info("Page(1) Message {}", message));
        messageMapper.findAllWithRowBounds(new RowBounds(2, 3))
                .forEach(message -> Log.info("Page(2) Message {}", message));
        Log.info("====================");

        messageMapper.findAllWithRowBounds(new RowBounds(1, 0))
                .forEach(coffee -> Log.info("Page(1) Message {}", coffee));
        Log.info("====================");
    }

    @Test
    @Order(9)
    public void testFindALlWithParam() {
        messageMapper.findALlWithParam(1, 3)
                .forEach(coffee -> Log.info("Page(1) Message {}", coffee));
        List<Message> messages = messageMapper.findALlWithParam(2, 3);
       // PageInfo<Message> page = new PageInfo<>(messages);


      //  Log.info("PageInfo: {}", page);
    }
}
