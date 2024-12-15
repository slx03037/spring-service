package com.xinwen.mybatis.node01.mode;

import lombok.Data;

/**
 * @author shenlx
 * @description
 * @date 2024/1/30 23:58
 */
@Data
public class Result<T> {
    private String code;

    private T data;

    private String msg;

    private static String successCode="200";

    private static String errorCode="500";

    private static String successMsg="操作成功";

    private static String errorMsg="操作失败";


    public static <T> Result<T> success() {
        return new Result<>(successCode, null, successMsg);
    }

    public static <T> Result<T> success(String msg) {
        return new Result<>(successCode, null, msg);
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(successCode, data, successMsg);
    }

    public static <T> Result<T> error(T data) {
        return new Result<>(errorCode, data, errorMsg);
    }

    public static <T> Result<T> error(String code, T data) {
        return new Result<>(code, data, errorMsg);
    }


    public static <T> Result<T> error(String code, String msg) {
        return new Result<>(code, null, msg);
    }

    public static <T> Result<T> error(String msg) {
        return new Result<>(errorCode, null, msg);
    }

    private Result() {
    }

    private Result(String code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
