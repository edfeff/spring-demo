package com.wpp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangpp
 */
@Slf4j
@Controller
@RequestMapping( "/test" )
public class TestController {
    @RequestMapping( "/hello" )
    @ResponseBody
    public String hello() {
        log.info("hello，世界");
        return "hello，世界";
    }

    /**
     * 控制器返回结果乱码- 解决方法1
     *
     * @return
     */
    @RequestMapping( value = "/order", produces = "text/plain;charset=utf-8" )
    @ResponseBody
    public String addOrder() {
        return "成功";
    }
}
