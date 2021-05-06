package com.yi.backcli.handler;

import com.yi.backcli.dto.Result;
import com.yi.backcli.exception.ExistsException;
import com.yi.backcli.util.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ExistsException.class)
    public Result existsException(HttpServletRequest request, HttpServletResponse response, ExistsException e) {
        return ResultUtils.error(0, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result globalException(HttpServletRequest request, HttpServletResponse response, Exception e) {
        return ResultUtils.error(0, "Internal Server Error");
    }
}
