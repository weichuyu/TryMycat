package com.example.trymycat.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.trymycat.entity.Test1;
import com.example.trymycat.mapper.Test1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@RestController
public class A01_TestController {
    @Autowired
    Test1Mapper test1Mapper;

    @GetMapping("/insert")
    public String insert() {
        ZonedDateTime zd = ZonedDateTime.now();
        Test1 ob = new Test1();
        ob.setId(UUID.randomUUID().toString().replace("-", ""));
        ob.setDate(Date.from(zd.toInstant()));
        ob.setNumber(new BigDecimal(Math.random() * 1000.0));
        ob.setText("A01_测试:" + "UUID.randomUUID().toString()");
        return "result:" + test1Mapper.insert(ob);
    }

    @GetMapping("/update")
    public String update(@RequestParam(name = "id") String id) {
        Test1 ob = new Test1();
        ob.setId(id);
        ZonedDateTime zd = ZonedDateTime.now();
        ob.setDate(Date.from(zd.toInstant()));
        return "result:" + test1Mapper.updateByPrimaryKeySelective(ob);
    }

    @GetMapping("/query")
    public String query(@RequestParam(name = "begin") int begin, @RequestParam(name = "end") int end) {
        List<Test1> list = test1Mapper.selectAll(begin, end);
        return JSONObject.toJSONString(list);
    }

}
