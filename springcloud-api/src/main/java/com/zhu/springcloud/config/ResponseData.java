package com.zhu.springcloud.config;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class ResponseData<T> implements Serializable {
    /**
     * 状态码：0-成功，1-失败
     * */
    private int code;

    /**
     * 错误消息，如果成功可为空或SUCCESS
     * */
    private String msg;

    /**
     * 返回结果数据
     * */
    private T data;

    public static ResponseData success() {
        return success(null);
    }

    public static ResponseData success(Object data) {
        ResponseData result = new ResponseData();
        result.setCode(0);
        result.setMsg("SUCCESS");
        result.setData(data);
        return result;
    }

    public static ResponseData fail(String msg) {
        return fail(msg,null);
    }

    public static ResponseData fail(String msg, Object data) {
        ResponseData result = new ResponseData();
        result.setCode(1);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}