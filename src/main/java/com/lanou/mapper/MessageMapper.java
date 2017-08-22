package com.lanou.mapper;

import com.lanou.bean.Message;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MessageMapper {

    List<Message> findAll();

    void insertMessage(Message message);
}
