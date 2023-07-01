package com.tanim.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController is a combination of both @Controller and @ResponseBody
@RestController
public class DemoController {

    @GetMapping("/hello")
    public String sayingHello()
    {
        return "Hello From Spring boot";
    }
}
