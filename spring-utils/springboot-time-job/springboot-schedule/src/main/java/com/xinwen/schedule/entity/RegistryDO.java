package com.xinwen.schedule.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shenlx
 * @description
 * @date 2024/5/8 22:44
 */
@Data
public class RegistryDO implements Serializable {
    private static final long serialVersionUID = -6308099044063306000L;
    private Long id;

    private Integer plateType;

    private Integer vehicleUse;

    private String tid;

    private String plateNo;

    private Integer useType;

    private Date registerTime;

    private Date buyTime;

    private String vin;

    private String ownerName;

    private Integer sex;

    private String cardId;

    private String phoneNum;

    private String insuranceCompanyId;

    private Integer isTheftInsurance;

    private Integer isTripleLiabilityInsurance;

    private Integer isAdditionalDriverInsurance;

    private Integer isLowIncome;

    private Integer insuranceYears;

    private String insurancePic;

    private String cardIdFacePic;

    private String cardIdBackPic;

    private String vehiclePic;

    private String organ;

    private String region;

    private Integer standard;

    private String productCertificateNo;

    private String certificateNo;

    private Integer vehicleStatus;

    private String productBusinessName;

    private String vehicleColor;

    private String saleBusinessName;

    private String ownerAddress;

    private String areaName;

    private String belongPlace;

    private String createName;

    private Date createTime;

    private Date updateTime;

    private String updateName;

    private Long delFlag;
}
