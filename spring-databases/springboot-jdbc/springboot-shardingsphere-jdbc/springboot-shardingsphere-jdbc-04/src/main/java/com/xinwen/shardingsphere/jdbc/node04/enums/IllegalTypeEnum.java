package com.xinwen.shardingsphere.jdbc.node04.enums;

import lombok.Getter;

/**
 * @author shenlx
 * @description 违法类型
 * @date 2024/5/8 14:56
 */
@Getter
public enum IllegalTypeEnum {
    normal(0,"正常",0)
    ,RUN_RED_LIGHT(10109,"闯红灯",2)
    ,OCCUPY_MOTORWAY(10601,"占用机动车道",4)
    ,NON_MOTORIZED_VEHICLES_PASSENGERS(10602,"非机动车载人",6)
    ,NON_MOTORIZED_HELMETS_NOT_WORN(10604,"非机动车未戴头盔",8)
    ,NON_MOTORIZED_VEHICLES_REVERSE_HELMET(10110,"非机动车逆行",10)
    ;

    private final int code;

    private final String value;

    private int type;

    IllegalTypeEnum(int code,String value){
        this.code=code;
        this.value=value;
    }

    IllegalTypeEnum(int code, String value, int type) {
        this.code = code;
        this.value = value;
        this.type = type;
    }

    public static String get(int code){
        for(IllegalTypeEnum illegalTypeEnum:values()){
            if(illegalTypeEnum.getCode()==code){
                return illegalTypeEnum.getValue();
            }
        }
        return "";
    }


    public static IllegalTypeEnum gets(int code){
        for(IllegalTypeEnum illegalTypeEnum:values()){
            if(illegalTypeEnum.getCode()==code){
                return illegalTypeEnum;
            }
        }
        return null;
    }

    public static int getType(int code){
        for(IllegalTypeEnum illegalTypeEnum:values()){
            if(illegalTypeEnum.getCode()==code){
                return illegalTypeEnum.getType();
            }
        }
        return 0;
    }

}
