package com.xinwen.word.poi.tl.model.response;


import com.xinwen.word.poi.tl.model.constant.ResponseStatus;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-07-10 22:38
 **/

@Data
@Builder
public class ResponseResult<T> {

    /**
     * response timestamp.
     */
    private long timestamp;

    /**
     * response code, 200 -> OK.
     */
    private String status;

    /**
     * response message.
     */
    private String message;

    /**
     * response data.
     */
    private T data;

    /**
     * response success result wrapper.
     *
     * @param <T> type of data class
     * @return response result
     */
    public static <T> ResponseResult<T> success() {
        return success(null);
    }

    /**
     * response success result wrapper.
     *
     * @param data response data
     * @param <T>  type of data class
     * @return response result
     */
    public static <T> ResponseResult<T> success(T data) {
        return ResponseResult.<T>builder().data(data)
                .message(ResponseStatus.SUCCESS.getDescription())
                .status(ResponseStatus.SUCCESS.getResponseCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * response error result wrapper.
     *
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T extends Serializable> ResponseResult<T> fail(String message) {
        return fail(null, message);
    }

    /**
     * response error result wrapper.
     *
     * @param data    response data
     * @param message error message
     * @param <T>     type of data class
     * @return response result
     */
    public static <T> ResponseResult<T> fail(T data, String message) {
        return ResponseResult.<T>builder().data(data)
                .message(message)
                .status(ResponseStatus.FAIL.getResponseCode())
                .timestamp(System.currentTimeMillis())
                .build();
    }


}
