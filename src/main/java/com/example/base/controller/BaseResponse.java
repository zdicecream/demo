package com.example.base.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
public class BaseResponse<T> implements Serializable{
    private static final long serialVersionUID = 1L;
    /**
     200    请求成功             201   创建成功             202    更新成功
     400    无效请求             401  地址不存在
     403    禁止访问             404  请求资源不存在
     500    内部错误
     */
    public static final String successCode = "200";
    public static final String successMsg = "请求成功！";

    public static final String falseCode = "400";
    public static final String falseMsg = "无效请求！";

    public static final String errorCode = "500";
    public static final String errorMsg = "内部错误！";

    /*** 是否成功*/
    private boolean success;
    private String code;
    /**说明*/
    private String msg;
    /*** 返回数据*/
    private T data;

    public BaseResponse() {

    }

    public BaseResponse(boolean success, String code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResponse<T> SuccResponse(T t) {
        this.success = true;
        this.code = successCode;
        this.msg = successMsg;
        this.data = t;
        return this;
    }

    public BaseResponse<T> falseResponse() {
        this.success = false;
        this.code = falseCode;
        this.msg = falseMsg;
        return this;
    }
}
