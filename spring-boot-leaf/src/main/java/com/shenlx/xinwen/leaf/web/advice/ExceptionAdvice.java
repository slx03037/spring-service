//package com.bellon.leaf.web.advice;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.HttpRequestMethodNotSupportedException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * @author shenlx
// * @description
// * @date 2024/5/9 14:57
// */
//@Slf4j
//@ControllerAdvice
//public class ExceptionAdvice {
//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public BaseResponse<String> handleException(HttpServletRequest request, Exception e) {
//        BaseResponse<String> response = new BaseResponse<>();
//        if (e instanceof IllegalArgumentException) {
//            response.setMessage(e.getMessage());
//            response.setResult(ResponseCode.PARAMETER_ERROR);
//        } else if (e instanceof HttpRequestMethodNotSupportedException) {
//            response.setMessage("不支持的请求方式");
//            response.setResult(ResponseCode.PARAMETER_ERROR);
//        } else {
//            log.error(LogUtil.buildLog("请求出现异常", request.getRequestURI(), request.getParameterMap()), e);
//
//            response.setMessage("服务器未知异常");
//            response.setResult(ResponseCode.UNKNOWN_ERROR);
//        }
//
//        return response;
//    }
//}
