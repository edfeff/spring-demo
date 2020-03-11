package com.wpp.controller;

import com.wpp.common.JsonData;
import com.wpp.exception.PermissionException;
import com.wpp.param.TestVo;
import com.wpp.util.BeanValidator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

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


    @RequestMapping( "/validate.json" )
    @ResponseBody
    public JsonData validate(TestVo vo) {
        log.info("validate");
        Map<String, String> result = BeanValidator.validateObject(vo);
        try {
            if (MapUtils.isNotEmpty(result)) {
                for (Map.Entry<String, String> entry : result.entrySet()) {
                    log.info("{}-{}", entry.getKey(), entry.getValue());
                }
            }
        } catch (Exception e) {

        }
        return JsonData.success("validate");
    }

    @RequestMapping( "/validate2.json" )
    @ResponseBody
    public JsonData validate2(TestVo vo) {
        BeanValidator.check(vo);
        return JsonData.success();
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
