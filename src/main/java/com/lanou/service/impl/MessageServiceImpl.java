package com.lanou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.Message;
import com.lanou.mapper.MessageMapper;
import com.lanou.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageMapper mapper;

    public List<Message> findAll() {
        List<Message> messageList = mapper.findAll();
        return messageList;
    }

    public PageInfo<Message> queryPage(Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        pageSize = pageSize == null ? 5 : pageSize;
        PageHelper.startPage(pageNum, pageSize);
        List<Message> messageList = mapper.findAll();
        // 使用pageInfo对查询结果进行包装
        PageInfo<Message> pageInfo = new PageInfo<Message>(messageList);
        return pageInfo;
    }

    public Message addNewMessage(String content) {
        Message message = new Message();
        message.setContent(content);
        message.setUp(0);
        message.setDown(0);
        mapper.insertMessage(message);
        return message;
    }
}
