package com.example.mybatisxmldemo.dao;

import com.example.mybatisxmldemo.model.Messages;
import com.example.mybatisxmldemo.model.Page;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface MessageRepository extends /*JpaRepository*/ JpaRepository<Messages,Integer>{
    //解析方法名创建查询
    List<Messages> findByMsgSummary(String msgSummary);
    List<Messages> findByMsgTextOrMsgSummary(String msgText,String msgSummary);
    List<Messages> findByMsgTextLike(String text);
    List<Messages> findDistinctByMsgIdLessThan(int maxId);

    //JPQL查询，类似Hibernate的HQL语法，在接口上使用@Query
    @Query("select msgId,msgText,msgSummary from Message where msgId = ?1")
    Messages findById(int msgId);
    //修改
    @Modifying
    @Query(value = "update message set msg_text = ?1 where msg_id < ?2",nativeQuery = true)
    int updateName(String msgText,int msgId);
    //分页查询
    @Query("select m from Message m where m.msgSummary=?1")
    public Page<Messages> findByName(String msgSummary, Pageable pageable);

}
