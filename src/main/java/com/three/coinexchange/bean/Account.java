package com.three.coinexchange.bean;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class Account {
    private Long id;

    private Long userId;

    private Long coinId;

    private Boolean status;

    private BigDecimal balanceAmount;

    private BigDecimal freezeAmount;

    private BigDecimal rechargeAmount;

    private BigDecimal withdrawalsAmount;

    private BigDecimal netValue;

    private BigDecimal lockMargin;

    private BigDecimal floatProfit;

    private BigDecimal totalProfit;

    private String recAddr;

    private Long version;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date lastUpdateTime;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCoinId() {
        return coinId;
    }

    public void setCoinId(Long coinId) {
        this.coinId = coinId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public BigDecimal getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(BigDecimal balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public BigDecimal getFreezeAmount() {
        return freezeAmount;
    }

    public void setFreezeAmount(BigDecimal freezeAmount) {
        this.freezeAmount = freezeAmount;
    }

    public BigDecimal getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(BigDecimal rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public BigDecimal getWithdrawalsAmount() {
        return withdrawalsAmount;
    }

    public void setWithdrawalsAmount(BigDecimal withdrawalsAmount) {
        this.withdrawalsAmount = withdrawalsAmount;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public void setNetValue(BigDecimal netValue) {
        this.netValue = netValue;
    }

    public BigDecimal getLockMargin() {
        return lockMargin;
    }

    public void setLockMargin(BigDecimal lockMargin) {
        this.lockMargin = lockMargin;
    }

    public BigDecimal getFloatProfit() {
        return floatProfit;
    }

    public void setFloatProfit(BigDecimal floatProfit) {
        this.floatProfit = floatProfit;
    }

    public BigDecimal getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(BigDecimal totalProfit) {
        this.totalProfit = totalProfit;
    }

    public String getRecAddr() {
        return recAddr;
    }

    public void setRecAddr(String recAddr) {
        this.recAddr = recAddr == null ? null : recAddr.trim();
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userId=" + userId +
                ", coinId=" + coinId +
                ", status=" + status +
                ", balanceAmount=" + balanceAmount +
                ", freezeAmount=" + freezeAmount +
                ", rechargeAmount=" + rechargeAmount +
                ", withdrawalsAmount=" + withdrawalsAmount +
                ", netValue=" + netValue +
                ", lockMargin=" + lockMargin +
                ", floatProfit=" + floatProfit +
                ", totalProfit=" + totalProfit +
                ", recAddr='" + recAddr + '\'' +
                ", version=" + version +
                ", lastUpdateTime=" + lastUpdateTime +
                ", created=" + created +
                '}';
    }
}