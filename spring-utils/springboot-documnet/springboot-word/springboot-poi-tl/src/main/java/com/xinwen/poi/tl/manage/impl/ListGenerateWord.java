package com.xinwen.poi.tl.manage.impl;


import com.deepoove.poi.data.NumbericRenderData;
import com.xinwen.poi.tl.config.GenerateWordFactory;
import com.xinwen.poi.tl.enums.WordContentTypeEnum;
import com.xinwen.poi.tl.manage.GenerateWord;
import com.xinwen.poi.tl.model.LabelData;
import com.xinwen.poi.tl.model.ListRenderData;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:
 * @author: shenlx
 * @create: 2023-07-12 22:54
 **/

@Component
public class ListGenerateWord implements GenerateWord {
    @PostConstruct
    private void init(){
        GenerateWordFactory.register(WordContentTypeEnum.LIST,this);
    }
    @Override
    public Object generateWord(LabelData data) {
        ListRenderData listData =  (ListRenderData) data;
        return new NumbericRenderData(listData.getPair(),listData.getList());
    }
}
