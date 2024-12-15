package com.xinwen.poi.tl.model;


import com.xinwen.poi.tl.enums.PicTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.File;

/**
 * @program: my-spring-all-com.xinwen.mybatis.node01.service
 * @description: 创建图片实体
 * @author: shenlx
 * @create: 2023-07-12 22:46
 **/

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class PictureContentData extends LabelData {
    /**
     * 图片宽度
     */
    private Integer width;
    /**
     * 图片高度
     */
    private Integer height;
    /**
     * 图片类型
     */
    private PicTypeEnum picType;
    /**
     * 图片地址（网络图片插入时使用）
     */
    private String picUrl;
    /**
     * 图片文件
     */
    private File file;
}
