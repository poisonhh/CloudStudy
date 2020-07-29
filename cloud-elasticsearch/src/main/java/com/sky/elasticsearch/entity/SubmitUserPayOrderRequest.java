package com.sky.elasticsearch.entity;

import java.math.BigDecimal;

/**
 * @author hhuang
 * @date 2020-07-29 19:00
 */
public class SubmitUserPayOrderRequest {

    private String id;
    private Long merchantId;
    private Long userPayId;
    private BigDecimal amountOfConsumption;
    private BigDecimal payAblAmount;
    private Long userId;
    private BigDecimal discountAmount;
    private BigDecimal freeAmount;
    private String discountId;
    private String freeId;
    private Integer status;
    private Integer channelId;
    private BigDecimal enjoyKingAmount;
    private Integer payType;
    private Integer scanType;


    public SubmitUserPayOrderRequest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getUserPayId() {
        return userPayId;
    }

    public void setUserPayId(Long userPayId) {
        this.userPayId = userPayId;
    }

    public BigDecimal getAmountOfConsumption() {
        return amountOfConsumption;
    }

    public void setAmountOfConsumption(BigDecimal amountOfConsumption) {
        this.amountOfConsumption = amountOfConsumption;
    }

    public BigDecimal getPayAblAmount() {
        return payAblAmount;
    }

    public void setPayAblAmount(BigDecimal payAblAmount) {
        this.payAblAmount = payAblAmount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getFreeAmount() {
        return freeAmount;
    }

    public void setFreeAmount(BigDecimal freeAmount) {
        this.freeAmount = freeAmount;
    }

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public String getFreeId() {
        return freeId;
    }

    public void setFreeId(String freeId) {
        this.freeId = freeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public BigDecimal getEnjoyKingAmount() {
        return enjoyKingAmount;
    }

    public void setEnjoyKingAmount(BigDecimal enjoyKingAmount) {
        this.enjoyKingAmount = enjoyKingAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getScanType() {
        return scanType;
    }

    public void setScanType(Integer scanType) {
        this.scanType = scanType;
    }
}
