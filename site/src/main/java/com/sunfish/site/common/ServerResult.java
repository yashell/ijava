package com.sunfish.site.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "返回结果实体",description = "200成功")
public class ServerResult<T> implements Serializable {
    @ApiModelProperty(value="返回结果",required=true,name="data")
    private T data;
    @ApiModelProperty(value="返回状态",required=true,name="status",example = "true")
    private boolean status;
    @ApiModelProperty(value="返回状态代码",required=true,name="code",example = "200")
    private int code;
    @ApiModelProperty(value="返回信息",required=true,name="message",example = "操作成功")
    private String message;

    private ServerResult() {}


    private ServerResult(boolean status, int code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    private ServerResult(T data, boolean status, int code, String message) {
        this.data = data;
        this.status = status;
        this.code = code;
        this.message = message;
    }

    /**
     * 返回失败，code码和msg自定义
     */
    public static <T> ServerResult<T> newInstance(){
        return new ServerResult<T>();
    }


    /**
     * 调用默认成功
     */
    public static <T> ServerResult<T> defaultSuccess(T data){
        return new ServerResult<T>(data, true, 200, "操作成功");
    }

    /**
     * 返回默认失败
     */
    public static <T> ServerResult<T> defaultFailure(){
        return new ServerResult<T>(false, 500, "系统内部错误");
    }

    /**
     * 自定义失败一
     */
    public static <T> ServerResult<T> failure(T data, int code, String message){
        return new ServerResult<T>(data, false, code, message);
    }

    /**
     * 自定义失败二
     */
    public static <T> ServerResult<T> failure(int code, String message){
        return new ServerResult<T>(false, code, message);
    }

    public T getData() {
        return data;
    }

    public ServerResult<T> data(T data) {
        this.data = data;
        return this;
    }
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



    public int getCode() {
        return code;
    }


    public ServerResult<T> code(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ServerResult<T> message(String message) {
        this.message = message;
        return this;
    }
}
