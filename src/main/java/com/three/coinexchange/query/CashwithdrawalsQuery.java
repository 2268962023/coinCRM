package com.three.coinexchange.query;

import com.three.coinexchange.base.BaseQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class CashwithdrawalsQuery extends BaseQuery {
    private String username;
    private String phone;
    private Integer status;
    private Integer startNum;
    private Integer endNum;

    private String startTimes;
    private String endTimes;

    private String coin_id;

    private Date startTime;

    private Date endTime;

}
