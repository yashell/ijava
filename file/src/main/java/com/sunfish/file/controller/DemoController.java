package com.sunfish.file.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller

public class DemoController {
    private String aa = "df";
    @Value("${server.port}")
    private String name;
    @ResponseBody
    @RequestMapping("/helloworld")
    public Object helloworld () {

        String a = helloworld2();
        return "你好啊世界"+ aa + name;
    }

    private String helloworld2 () {
        return "你好啊世界"+ aa + name;
    }
}
