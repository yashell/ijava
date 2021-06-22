package com.sunfish.site.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    private String aa = "df";
    @Value("${ijava.name}")
    public static String name;

    @ResponseBody
    @RequestMapping("/helloworld")
    public Object helloworld () {
        return "你好啊世界"+ aa+ name;
    }
}
