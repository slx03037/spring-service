package com.xinwen.poi.tl.manage.impl;


import com.deepoove.poi.data.MiniTableRenderData;
import com.deepoove.poi.data.RowRenderData;
import com.xinwen.poi.tl.config.GenerateWordFactory;
import com.xinwen.poi.tl.enums.WordContentTypeEnum;
import com.xinwen.poi.tl.manage.GenerateWord;
import com.xinwen.poi.tl.model.LabelData;
import com.xinwen.poi.tl.model.TableSeriesRenderData;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description:  列封装类
 * @author: shenlx
 * @create: 2023-07-12 22:51
 **/

@Component
public class TableGenerateWord implements GenerateWord {
    @PostConstruct
    private void init(){
        GenerateWordFactory.register(WordContentTypeEnum.TABLE,this);
    }
    @Override
    public Object generateWord(LabelData data) {
        TableSeriesRenderData tableData = (TableSeriesRenderData) data;
        RowRenderData header = RowRenderData.build(tableData.getHeader());
        List<RowRenderData> contentData = new ArrayList<>();
        tableData.getContents().forEach(con ->{
            contentData.add(RowRenderData.build(con));
        });
        return new MiniTableRenderData(header,contentData);
    }
}
