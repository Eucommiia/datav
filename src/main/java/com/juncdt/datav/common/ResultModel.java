package com.juncdt.datav.common;

import org.springframework.util.StringUtils;

/**
 * ResultModel 返回结果类
 *
 *
 * @author
 * @date 16/8/31
 */
public class ResultModel<T> {

    private int code;

    private T data;

    private String message;

    public static <T> ResultModel<T> success(T data) {
        ResultModel<T> res = new ResultModel<T>();
        res.setCode(CodeEnum.SUCCESS.getCode());
        res.setData(data);
        res.setMessage(CodeEnum.SUCCESS.getDesc());
        return res;
    }

    public static <T> ResultModel<T> fail(CodeEnum codeEnum, String msg) {
        ResultModel<T> res = new ResultModel<T>();
        res.setCode(codeEnum.getCode());
        res.setMessage(StringUtils.isEmpty(msg) ? codeEnum.getDesc() : msg);
        return res;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}
