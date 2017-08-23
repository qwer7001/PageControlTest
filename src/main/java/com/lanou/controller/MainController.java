package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Message;
import com.lanou.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Resource
    private MessageService service;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/getAll")
    @ResponseBody
    public Map<String, Object> getAll() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Message> list = service.findAll();
        map.put("obj",list);
        return map;
    }

    @RequestMapping(value = "/addNew")
    public Map<String, Object> add(@RequestParam("content") String content) {
        Map<String, Object> map = new HashMap<String, Object>();
        service.addNewMessage(content);
        map.put("msg","添加成功");
        return map;
    }

    @RequestMapping(value = "/pageTest")
    @ResponseBody
    public PageInfo<Message> pagetest(@RequestParam("pagenum") Integer pn, @RequestParam("pagesize") Integer ps){
        PageInfo<Message> pageInfo = service.queryPage(pn,ps);
        return pageInfo;
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public String gittest() {
        return "bbb";
    }

    public void test() {
        System.out.println(1111);
    }

    // 编辑代码
    @RequestMapping(value = "/branch")
    @ResponseBody
    public String branchTest() {
        return "branch";
    }
}
