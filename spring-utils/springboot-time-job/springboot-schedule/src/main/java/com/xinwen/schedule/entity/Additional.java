package com.xinwen.schedule.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author shenlx
 * @description
 * @date 2024/5/8 22:39
 */
@Data
public class Additional implements Serializable {
    private static final long serialVersionUID = 6837992052653216248L;
    private Long fimei;

    private String fusername;

    private String fusercer;

    private String fCarNumber;

    private String fimgperiod;

    private String fimgcar;

    private Integer fperiodtime;

    private Long fperiodparam;

    private String finsurecompany;

    private String fbuydate;

    private Long fappflag;

    private String faddaccount;

    private Long fcreatetime;

    private Long fmodifytime;

    private String fcheckdate;

    private String fbckphone;

    private String fframenum;

    private String fcartype;

    private String fimgframenum;

    private String fcarbrand;

    private String fimgmancar;

    private String fimgdevice;

    private String fimgdevpos;

    private String fimgwirelesspos;

    private Long faddfamily;

    private Long floanamount;
}
