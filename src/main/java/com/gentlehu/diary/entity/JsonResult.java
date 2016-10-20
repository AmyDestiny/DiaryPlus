package com.gentlehu.diary.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/17.
 */
public class JsonResult {
    private int code = 0;
    private String msg;
    private Map<String,Object> data;

    public static JsonResult create(int code ,String msg,Map<String,Object> data){
        return new JsonResult(code,msg,data);
    }
    public static JsonResult create(int code ,String msg){
        return new JsonResult(code,msg,null);
    }

    public JsonResult(int code, String msg, Map<String, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public void addData(String name,Object obj){
        this.getData().put(name,obj);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        if(data == null){
            data = new HashMap<String,Object>();
        }
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
