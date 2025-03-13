package com.xinwen.jgrapht.pojo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author shenlx
 * @description 道路模型类，表示图中的边
 * @date 2025/3/13 10:56
 */
@Data
public class Road {

    @NotNull(message = "源城市ID不能为空")
    private String sourceId;


    @NotNull(message = "目标城市ID不能为空")
    private String targetId;

    @Min(value = 0,message = "权重必须为非负")
    private double weight;//表示距离或其他成本
}
