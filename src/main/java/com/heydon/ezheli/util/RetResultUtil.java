package com.heydon.ezheli.util;

public class RetResultUtil {
    private  Integer code;
    private String msg;
    private Object data;

    public RetResultUtil(){
        this.code = Integer.valueOf(0);
        this.msg = "";
        this.data = null;
    }
    /**
     *返回状态码、信息、以及数据
     */
    public RetResultUtil(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = "";
        this.data = null;
    }
    /**
     *只返回状态码，以及信息可以用于失败时候来使用
     */
    public RetResultUtil(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
    }
    /**
     *只返回状态码和数据
     */
    public RetResultUtil(Integer code, Object data) {
        this.code = code;
        this.msg = "";
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}