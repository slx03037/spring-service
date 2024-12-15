package com.xinwen.leaf.web.context;

/**
 * @author shenlx
 * @description
 * @date 2024/5/9 14:58
 */
public class RequestParamContext {
    private static final ThreadLocal<String> HOLDER = new ThreadLocal<>();

    public static void set(String content) {
        HOLDER.set(content);
    }

    public static String get() {
        return HOLDER.get();
    }

    public static void remove() {
        HOLDER.remove();
    }
}
