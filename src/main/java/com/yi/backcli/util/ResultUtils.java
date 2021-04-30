package com.yi.backcli.util;

import com.yi.backcli.dto.Result;

public class ResultUtils {

    public static Result success(String message, Object object) {
        Result result = new Result();
        result.setCode(200);
        result.setMessage(message);
        result.setData(object);
        return result;
    }

    public static Result success(Object object) {
        return success("success", object);
    }

    public static Result success(String message) {
        return success(message, null);
    }

    public static Result success() {
        return success("success", null);
    }

    public static Result error(Integer code, String message, Object object) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(object);
        return result;
    }

    public static Result error(Integer code, String message) {
        return error(code, message, null);
    }

    public static Result error(Integer code) {
        return error(code, "error", null);
    }
}
