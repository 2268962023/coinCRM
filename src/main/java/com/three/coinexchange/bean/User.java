package com.three.coinexchange.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User {
    private Long id;

    private Byte type;

    private String username;

    private String countryCode;

    private String mobile;

    private String password;

    private String paypassword;

    private Boolean paypassSetting;

    private String email;

    private String realName;

    private Boolean idCardType;

    private Byte authStatus;

    private String gaSecret;

    private Boolean gaStatus;

    private String idCard;

    private Integer level;

    private Date authtime;

    private Integer logins;

    private Byte status;

    private String inviteCode;

    private String directInviteid;

    private Integer isDeductible;

    private Integer reviewsStatus;

    private String accessKeyId;

    private String accessKeySecret;

    private Long refeAuthId;

    private Date lastUpdateTime;

    private Date created;


}