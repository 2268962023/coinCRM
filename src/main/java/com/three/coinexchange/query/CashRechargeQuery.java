package com.three.coinexchange.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.three.coinexchange.base.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class CashRechargeQuery extends BaseQuery {
    private String username;
    private String phone;
    private BigDecimal coinId;
    private Integer status;
    private Integer startNum;
    private Integer endNum;

    private String startTimes;
    private String endTimes;

    private String coin_id;

    private Date startTime;

    private Date endTime;

}
