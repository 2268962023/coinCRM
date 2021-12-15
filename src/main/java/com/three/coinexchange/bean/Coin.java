package com.three.coinexchange.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Coin {
    private Long id;

    private String name;

    private String title;

    private String img;

    private String type;

    private String wallet;

    private Byte round;

    private BigDecimal baseAmount;

    private BigDecimal minAmount;

    private BigDecimal maxAmount;

    private BigDecimal dayMaxAmount;

    private Boolean status;

    private Double autoOut;

    private Double rate;

    private BigDecimal minFeeNum;

    private Byte withdrawFlag;

    private Byte rechargeFlag;

    private Date lastUpdateTime;

    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet == null ? null : wallet.trim();
    }

    public Byte getRound() {
        return round;
    }

    public void setRound(Byte round) {
        this.round = round;
    }

    public BigDecimal getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(BigDecimal baseAmount) {
        this.baseAmount = baseAmount;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public BigDecimal getDayMaxAmount() {
        return dayMaxAmount;
    }

    public void setDayMaxAmount(BigDecimal dayMaxAmount) {
        this.dayMaxAmount = dayMaxAmount;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getAutoOut() {
        return autoOut;
    }

    public void setAutoOut(Double autoOut) {
        this.autoOut = autoOut;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public BigDecimal getMinFeeNum() {
        return minFeeNum;
    }

    public void setMinFeeNum(BigDecimal minFeeNum) {
        this.minFeeNum = minFeeNum;
    }

    public Byte getWithdrawFlag() {
        return withdrawFlag;
    }

    public void setWithdrawFlag(Byte withdrawFlag) {
        this.withdrawFlag = withdrawFlag;
    }

    public Byte getRechargeFlag() {
        return rechargeFlag;
    }

    public void setRechargeFlag(Byte rechargeFlag) {
        this.rechargeFlag = rechargeFlag;
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
}