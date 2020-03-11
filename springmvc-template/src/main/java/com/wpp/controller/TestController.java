package com.wpp.controller;

import com.wpp.common.JsonData;
import com.wpp.exception.PermissionException;
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
    @RequestMapping( "/hello.json" )
    @ResponseBody
    public JsonData hello() {
        log.info("hello，世界");
        return JsonData.success("hello，世界");
    }

    @RequestMapping( "/error.json" )
    @ResponseBody
    public JsonData error() {
        log.info("hello，世界");
        throw new PermissionException("hello");
//        return JsonData.success("hello，世界");
    }

    @RequestMapping( "/error.page" )
    public JsonData errorpage() {
        log.info("hello，世界");
        throw new PermissionException("hello");
//        return JsonData.success("hello，世界");
    }

    @RequestMapping( "/uerror.json" )
    @ResponseBody
    public JsonData uerror() {
        log.info("hello，世界");
        throw new RuntimeException("uerror");
//        return JsonData.success("hello，世界");
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
