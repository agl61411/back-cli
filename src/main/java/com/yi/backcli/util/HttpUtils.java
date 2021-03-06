package com.yi.backcli.util;

import com.alibaba.fastjson.JSONObject;
import com.yi.backcli.dto.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HttpUtils {

    public static void write(HttpServletResponse response, Integer code, String message, Object data) {
        response.setContentType("application/json;charset=utf-8");
        Result result;
        if (code == 200) {
            result = ResultUtils.success(message, data);
        } else {
            result = ResultUtils.error(code, message);
        }
        String json = JSONObject.toJSONString(result);
        try (PrintWriter out = response.getWriter()) {
            out.print(json);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
