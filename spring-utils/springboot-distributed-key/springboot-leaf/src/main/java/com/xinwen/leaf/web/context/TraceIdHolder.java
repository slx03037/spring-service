package com.xinwen.leaf.web.context;

/**
 * @author shenlx
 * @description
 * @date 2024/5/9 14:56
 */
public class TraceIdHolder {
    private static final ThreadLocal<String> TRACE_ID = new ThreadLocal<>();

    public static void setTraceId(String traceId) {
        TRACE_ID.set(traceId);
    }

    public static String getTraceId() {
        return TRACE_ID.get();
    }

    public static void removeTraceId() {
        TRACE_ID.remove();
    }
}
