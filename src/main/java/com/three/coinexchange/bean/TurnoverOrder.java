package com.three.coinexchange.bean;

import java.math.BigDecimal;
import java.util.Date;

public class TurnoverOrder {
    private Long id;

    private Long marketId;

    private Integer marketType;

    private Boolean tradeType;

    private String symbol;

    private String marketName;

    private Long sellUserId;

    private Long sellCoinId;

    private Long sellOrderId;

    private BigDecimal sellPrice;

    private BigDecimal sellFeeRate;

    private BigDecimal sellVolume;

    private Long buyUserId;

    private Long buyCoinId;

    private Long buyOrderId;

    private BigDecimal buyVolume;

    private BigDecimal buyPrice;

    private BigDecimal buyFeeRate;

    private Long orderId;

    private BigDecimal amount;

    private BigDecimal price;

    private BigDecimal volume;

    private BigDecimal dealSellFee;

    private BigDecimal dealSellFeeRate;

    private BigDecimal dealBuyFee;

    private BigDecimal dealBuyFeeRate;

    private Boolean status;

    private Date lastUpdateTime;

    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public Integer getMarketType() {
        return marketType;
    }

    public void setMarketType(Integer marketType) {
        this.marketType = marketType;
    }

    public Boolean getTradeType() {
        return tradeType;
    }

    public void setTradeType(Boolean tradeType) {
        this.tradeType = tradeType;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol == null ? null : symbol.trim();
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName == null ? null : marketName.trim();
    }

    public Long getSellUserId() {
        return sellUserId;
    }

    public void setSellUserId(Long sellUserId) {
        this.sellUserId = sellUserId;
    }

    public Long getSellCoinId() {
        return sellCoinId;
    }

    public void setSellCoinId(Long sellCoinId) {
        this.sellCoinId = sellCoinId;
    }

    public Long getSellOrderId() {
        return sellOrderId;
    }

    public void setSellOrderId(Long sellOrderId) {
        this.sellOrderId = sellOrderId;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getSellFeeRate() {
        return sellFeeRate;
    }

    public void setSellFeeRate(BigDecimal sellFeeRate) {
        this.sellFeeRate = sellFeeRate;
    }

    public BigDecimal getSellVolume() {
        return sellVolume;
    }

    public void setSellVolume(BigDecimal sellVolume) {
        this.sellVolume = sellVolume;
    }

    public Long getBuyUserId() {
        return buyUserId;
    }

    public void setBuyUserId(Long buyUserId) {
        this.buyUserId = buyUserId;
    }

    public Long getBuyCoinId() {
        return buyCoinId;
    }

    public void setBuyCoinId(Long buyCoinId) {
        this.buyCoinId = buyCoinId;
    }

    public Long getBuyOrderId() {
        return buyOrderId;
    }

    public void setBuyOrderId(Long buyOrderId) {
        this.buyOrderId = buyOrderId;
    }

    public BigDecimal getBuyVolume() {
        return buyVolume;
    }

    public void setBuyVolume(BigDecimal buyVolume) {
        this.buyVolume = buyVolume;
    }

    public BigDecimal getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    public BigDecimal getBuyFeeRate() {
        return buyFeeRate;
    }

    public void setBuyFeeRate(BigDecimal buyFeeRate) {
        this.buyFeeRate = buyFeeRate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getDealSellFee() {
        return dealSellFee;
    }

    public void setDealSellFee(BigDecimal dealSellFee) {
        this.dealSellFee = dealSellFee;
    }

    public BigDecimal getDealSellFeeRate() {
        return dealSellFeeRate;
    }

    public void setDealSellFeeRate(BigDecimal dealSellFeeRate) {
        this.dealSellFeeRate = dealSellFeeRate;
    }

    public BigDecimal getDealBuyFee() {
        return dealBuyFee;
    }

    public void setDealBuyFee(BigDecimal dealBuyFee) {
        this.dealBuyFee = dealBuyFee;
    }

    public BigDecimal getDealBuyFeeRate() {
        return dealBuyFeeRate;
    }

    public void setDealBuyFeeRate(BigDecimal dealBuyFeeRate) {
        this.dealBuyFeeRate = dealBuyFeeRate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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