package com.chaos.common;

import com.chaos.constant.Constant;
import com.chaos.constant.ResponseEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class JsonData implements Serializable {
    private static final long serialVersionUID = 1L;

    /**状态码 0 表示成功，1表示处理中，-1表示失败*/
    private Integer code;
    /** 数据 */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;
    /** 描述    */
    private String msg;

    public JsonData() {
    }

    public JsonData(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public JsonData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    // 成功，给出提示数据
    public static JsonData buildSuccess(String msg){
        return new JsonData(0, msg);
    }

    // 成功，传入数据
    public static JsonData buildSuccess() {
        return new JsonData(0, Constant.MSG);
    }

    // 成功，传入数据
    public static JsonData buildSuccess(Object data) {
        return new JsonData(0, data, "成功");
    }

    // 失败，传入描述信息
    public static JsonData buildError(String msg) {
        return new JsonData(-1, msg);
    }

    // 失败，传入描述信息,状态码
    public static JsonData buildError(String msg, Integer code) {
        return new JsonData(code, msg);
    }

    // 成功，传入数据,及描述信息
    public static JsonData buildSuccess(Object data, String msg) {
        return new JsonData(0, data, msg);
    }


    // 成功，传入数据,及状态码
//    public static JsonData buildSuccess(Object data, int code) {
//        return new JsonData(code, data, null);
//    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "JsonData [code=" + code + ", data=" + data + ", msg=" + msg
                + "]";
    }
}
