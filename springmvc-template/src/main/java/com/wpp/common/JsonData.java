package com.wpp.common;

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
public class JsonData {
    private boolean ret;
    private String msg;
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
