package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Message;

import java.util.List;

public interface MessageService {
    List<Message> findAll();

    PageInfo<Message> queryPage(Integer pageNum, Integer pageSize);

    Message addNewMessage(String content);
}
