package com.three.coinexchange.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.three.coinexchange.base.BaseQuery;

import java.util.Date;

public class CoinTypeQuery extends BaseQuery {

    private String code;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createdBegin;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createdEnd;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date created;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date lastUpdateTime;

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCreatedBegin() {
        return createdBegin;
    }

    public void setCreatedBegin(Date createdBegin) {
        this.createdBegin = createdBegin;
    }

    public Date getCreatedEnd() {
        return createdEnd;
    }

    public void setCreatedEnd(Date createdEnd) {
        this.createdEnd = createdEnd;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "CoinTypeQuery{" +
                "code='" + code + '\'' +
                ", createdBegin=" + createdBegin +
                ", createdEnd=" + createdEnd +
                '}';
    }
}
