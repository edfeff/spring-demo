package com.wpp.controller;

import lombok.extern.slf4j.Slf4j;
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
        log.info("hello");
        return "hello";
    }
}
