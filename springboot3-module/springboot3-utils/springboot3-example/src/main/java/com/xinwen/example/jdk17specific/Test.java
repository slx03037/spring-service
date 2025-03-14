package com.xinwen.example.jdk17specific;

import com.alibaba.fastjson2.JSON;

/**
 * @author shenlx
 * @description
 * @date 2025/3/14 11:31
 */

public class Test {


    public static void main(String[]args){
        //文本块（Text Blocks）：告别字符串拼接地狱
        String json= """
                {
                    "name":"张三",
                    "age":25,
                    "address":"南京浦口区"
                }
               """;
        System.out.println(JSON.isValid(json));

        Object obj="www";
        //模式匹配（Pattern Matching）：if-else减肥神器
        if (obj instanceof String str) {
            //String str = (String) obj;
            System.out.println(str.toUpperCase());
        } else if (obj instanceof Integer num ) {
            System.out.println(num * 2);
        }


        //Switch表达式（Switch Expressions）：一行搞定多条件分支
        String day="Monday";
        String datType=switch (day){
            case "Monday","Tuesday","Wednesday","Thursday","Friday"->"工作日";
            case "Saturday","Sunday"->"周末";
            default -> "未知";
        };
        System.out.println(datType);
    }

}
