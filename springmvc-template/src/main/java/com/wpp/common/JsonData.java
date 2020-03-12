package com.wpp.common;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据类型
 *
 * @author wangpp
 */
@Getter
@Setter
@ApiModel(value = "统一返回数据格式", description = "统一格式")
public class JsonData {
    @ApiModelProperty("成功标志")
    private boolean ret;
    @ApiModelProperty("返回信息")
    private String msg;
    @ApiModelProperty("数据")
    private Object data;

    public JsonData(boolean ret) {
        this.ret = ret;
    }

    public static JsonData success(Object data, String msg) {
        JsonData jsonData = new JsonData(true);
        jsonData.setData(data);
        jsonData.setMsg(msg);
        return jsonData;
    }

    public static JsonData success(Object data) {
        JsonData jsonData = new JsonData(true);
        jsonData.setData(data);
        return jsonData;
    }

    public static JsonData fail(String msg) {
        JsonData jsonData = new JsonData(false);
        jsonData.msg = msg;
        return jsonData;
    }

    public static JsonData success() {
        return new JsonData(true);
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("ret", ret);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }
}
