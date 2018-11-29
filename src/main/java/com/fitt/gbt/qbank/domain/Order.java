package com.fitt.gbt.qbank.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p> 订单表 </p>
 *
 * @author SixAwn
 * @since 2018-04-27
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("order_list")
public class Order extends BaseModel {
    private static final long serialVersionUID = -5126886599122250604L;
    /**
     * id
     */
    @JsonProperty("id")
    private Integer id;
    /**
     * 用户名
     */
    @JsonProperty("username")
    private String username;
    /**
     * 身份证号码
     */
    @JsonProperty("id_card")
    private String idCard;
    /**
     * 邮箱
     */
    @JsonProperty("email")
    private String email;
    /**
     * 微信
     */
    @JsonProperty("weixin")
    private String weixin;
    /**
     * 手机号码
     */
    @JsonProperty("telephone")
    private String telephone;
    /**
     * 预约区域编码
     */
    @JsonProperty("area_code")
    private String areaCode;
    /**
     * 预约区域名称
     */
    @JsonProperty("area_name")
    private String areaName;
    /**
     * 预约类型: 1-预约, 2-捡漏
     */
    @JsonProperty("order_type")
    private Integer orderType;
    /**
     * 入户渠道: 1-, 2-, 3-, 4-, 5-
     */
    @JsonProperty("residence_way")
    private Integer residenceWay;
    /**
     * 应付费用
     */
    @JsonProperty("order_money")
    private BigDecimal orderMoney;
    /**
     * 已付费用
     */
    @JsonProperty("paid_money")
    private BigDecimal paidMoney;
    /**
     * 预约要求日期时间
     */
    @JsonProperty("require_date")
    private Date requireDate;
    /**
     * 状态:1-新提交，2-预约成功，3-预约失败，4-预约撤销，5-预约重试
     */
    @JsonProperty("status")
    private Integer status;
    /**
     * 创建时间
     */
    @JsonProperty("create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @JsonProperty("modify_time")
    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getResidenceWay() {
        return residenceWay;
    }

    public void setResidenceWay(Integer residenceWay) {
        this.residenceWay = residenceWay;
    }

    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    public BigDecimal getPaidMoney() {
        return paidMoney;
    }

    public void setPaidMoney(BigDecimal paidMoney) {
        this.paidMoney = paidMoney;
    }

    public Date getRequireDate() {
        return requireDate;
    }

    public void setRequireDate(Date requireDate) {
        this.requireDate = requireDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "OrderList{" +
            "id=" + id +
            ", username=" + username +
            ", idCard=" + idCard +
            ", email=" + email +
            ", weixin=" + weixin +
            ", telephone=" + telephone +
            ", areaCode=" + areaCode +
            ", areaName=" + areaName +
            ", orderType=" + orderType +
            ", residenceWay=" + residenceWay +
            ", orderMoney=" + orderMoney +
            ", paidMoney=" + paidMoney +
            ", requireDate=" + requireDate +
            ", status=" + status +
            ", createTime=" + createTime +
            ", modifyTime=" + modifyTime +
            "}";
    }
}
