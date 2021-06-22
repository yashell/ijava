package com.sunfish.site.common;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "返回分页结果实体",description = "")
public class PageResult<T> implements Serializable {
    @ApiModelProperty(value="当前第几页",required=true,name="current",example = "1")
    private Integer current;
    @ApiModelProperty(value="每页有多少条数据",required=true,name="size",example = "10")
    private Integer size;
    @ApiModelProperty(value="总共有多少条数据",required=true,name="total")
    private Long total;
    @ApiModelProperty(value="返回状态",required=true,name="status",example = "true")
    private boolean status;
    @ApiModelProperty(value="返回状态代码",required=true,name="code",example = "200")
    private int code;
    @ApiModelProperty(value="返回信息",required=true,name="message",example = "操作成功")
    private String message;
    @ApiModelProperty(value="返回内容",required=false,name="data",example = "")
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
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

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    private PageResult( Integer current,  Integer size, Long total, T data, boolean success, int code, String message) {
//        this.current = current;
//        this.size= size;
//        this.total = total;
//        this.data = data;
//        this.success = success;
//        this.code = code;
//        this.message = message;
//    }
    /**
     * 调用默认成功
     * @return
     */
//    public static <T> PageResult<T> defaultSuccess(T data){
//
//        return new PageResult<T>(data, true, 200, "操作成功");
//    }

}
