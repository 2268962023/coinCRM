package com.three.coinexchange.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.three.coinexchange.base.BaseQuery;

import java.util.Date;

public class CoinQuery extends BaseQuery {

    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createdBegin;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createdEnd;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date created;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date lastUpdateTime;

    private String wallet;

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public String toString() {
        return "CoinQuery{" +
                "name='" + name + '\'' +
                ", createdBegin=" + createdBegin +
                ", createdEnd=" + createdEnd +
                ", created=" + created +
                ", lastUpdateTime=" + lastUpdateTime +
                ", wallet='" + wallet + '\'' +
                '}';
    }
}
