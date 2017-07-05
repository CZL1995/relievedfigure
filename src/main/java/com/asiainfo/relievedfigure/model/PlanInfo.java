package com.asiainfo.relievedfigure.model;

/**
 * Created by Caozl on 2017-07-04.
 */
public class PlanInfo {
    private String planName;
    private String planType;
    private int planId;
    private String groupList;
    private int planPrice;
    private int voice;
    private int priceVoicej1;
    private int flow;
    private int priceFlowj1;
    private int flowj1;
    private int priceFlowj2;
    private int flowj2;
    private int ifShare;

    public int getFlowj1() {
        return flowj1;
    }

    public void setFlowj1(int flowj1) {
        this.flowj1 = flowj1;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getGroupList() {
        return groupList;
    }

    public void setGroupList(String groupList) {
        this.groupList = groupList;
    }

    public int getPlanPrice() {
        return planPrice;
    }

    public void setPlanPrice(int planPrice) {
        this.planPrice = planPrice;
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }

    public int getPriceVoicej1() {
        return priceVoicej1;
    }

    public void setPriceVoicej1(int priceVoicej1) {
        this.priceVoicej1 = priceVoicej1;
    }

    public int getFlow() {
        return flow;
    }

    public void setFlow(int flow) {
        this.flow = flow;
    }

    public int getPriceFlowj1() {
        return priceFlowj1;
    }

    public void setPriceFlowj1(int priceFlowj1) {
        this.priceFlowj1 = priceFlowj1;
    }

    public int getPriceFlowj2() {
        return priceFlowj2;
    }

    public void setPriceFlowj2(int priceFlowj2) {
        this.priceFlowj2 = priceFlowj2;
    }

    public int getFlowj2() {
        return flowj2;
    }

    public void setFlowj2(int flowj2) {
        this.flowj2 = flowj2;
    }

    public int getIfShare() {
        return ifShare;
    }

    public void setIfShare(int ifShare) {
        this.ifShare = ifShare;
    }

    @Override
    public String toString() {
        return "PlanInfo{" +
                "planName='" + planName + '\'' +
                ", planType='" + planType + '\'' +
                ", planId=" + planId +
                ", groupList='" + groupList + '\'' +
                ", planPrice=" + planPrice +
                ", voice=" + voice +
                ", priceVoicej1=" + priceVoicej1 +
                ", flow=" + flow +
                ", priceFlowj1=" + priceFlowj1 +
                ", flowj1=" + flowj1 +
                ", priceFlowj2=" + priceFlowj2 +
                ", flowj2=" + flowj2 +
                ", ifShare=" + ifShare +
                '}';
    }
}
