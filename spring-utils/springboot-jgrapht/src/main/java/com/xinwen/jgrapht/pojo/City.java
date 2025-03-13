package com.xinwen.jgrapht.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author shenlx
 * @description:城市模型类，表示图中的节点
 * @date 2025/3/13 10:54
 */

@Data
public class City {
    @NotBlank(message = "城市ID不能为空")
    private String id;

    @NotBlank(message = "城市名称不能为空")
    private String name;
}
