package com.example.demo.util;

import com.example.demo.been.Result;

/**
 * 统一返回封装工具类
 */
public class ResultUtil {

    public static Result succse() {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        return result;
    }

    public static Result succse(Object obj) {
        Result result = new Result();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(obj);
        return result;
    }

    public static Result err() {
        Result result = new Result();
        result.setCode(500);
        result.setMsg("失败");
        return result;
    }

    public static Result err(String msg) {
        Result result = new Result();
        result.setCode(500);
        result.setMsg(msg);
        return result;
    }
}
