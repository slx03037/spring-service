package com.xinwen.jgrapht.pojo;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author shenlx
 * @description 运输数据模型类，包含城市和道路的信息。
 * @date 2025/3/13 10:59
 */

@Data
public class TransportData {
    @NotEmpty(message = "城市列表不能为空")
    @Valid
    private List<City>cities;

    @NotEmpty(message = "道路列表不能为空")
    @Valid
    private List<Road> roads;
}
