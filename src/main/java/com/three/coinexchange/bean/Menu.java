package com.three.coinexchange.bean;

import lombok.Data;

import java.util.Date;
@Data
public class Menu {
    private Long id;

    private Long parentId;

    private String parentKey;

    private String type;

    private String name;

    private String desc;

    private String targetUrl;

    private Integer sort;

    private String status;

    private Long createBy;

    private Long modifyBy;

    private Date created;

    private Date lastUpdateTime;
}