package com.fitt.gbt.qbank.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <p> 订单表 </p>
 *
 * @author SixAwn
 * @since 2018-04-27
 */
@Data
public class OrderList extends BaseModel {
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
