package com.jeckchen.eamis.common;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenj
 * @version 1.0.0
 * @className Result.java
 * @description jc
 * @date 2022年06月07日 19:41
 */
@Data
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;

    private Boolean state = false;

    private String message = "null";

    private HashMap<String, Object> data = new HashMap<>();

    private Result() {
    }

    public static Result ok() {
        Result result = new Result();
        result.state = true;
        return result;
    }

    public static Result ok(String message) {
        Result result = new Result();
        result.state = true;
        result.message = message;
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.state = false;
        result.message = "错误！";
        return result;
    }

    public static Result error(String message) {
        Result result = new Result();
        result.state = false;
        result.message = message;
        return result;
    }

    public Result data(Map<String, Object> map) {
        this.setData((HashMap<String, Object>) map);
        return this;
    }

    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }
}
