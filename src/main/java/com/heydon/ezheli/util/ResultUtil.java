package com.heydon.ezheli.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ResultUtil implements Serializable {

    private static final long serialVersionUID = -1802122468331526708L;
    private int code = -1;
    private String message = "待处理";
    private Map data = new HashMap();

    public ResultUtil(){}

    public ResultUtil(int status, String message){
        this.code = status;
        this.message = message;
    }

    public ResultUtil(int status, String message, Map data){
        this.code = status;
        this.message = message;
        this.data = data;
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

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public void putData(String key, Object value) {
        data.put(key, value);
    }

    public void removeData(String key) {
        data.remove(key);
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
