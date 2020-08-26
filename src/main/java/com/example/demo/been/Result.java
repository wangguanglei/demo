package com.example.demo.been;

import lombok.Data;

/**
 * 通用返回对象
 * @param <T>
 */
@Data
public class Result <T>{
    private Integer code;
    private String msg;
    private T data;
}
