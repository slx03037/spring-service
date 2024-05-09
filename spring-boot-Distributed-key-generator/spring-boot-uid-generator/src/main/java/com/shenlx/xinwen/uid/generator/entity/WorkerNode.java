package com.shenlx.xinwen.uid.generator.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author shenlx
 * @description
 * @date 2024/5/9 17:13
 */
@Data
public class WorkerNode {
    private Long id;
    private String hostName;
    private String port;
    private Integer type;
    private Date launchDate;
    private Date modified;
    private Date created;
}
