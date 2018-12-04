/*
 * Copyright (c) 2004-2018 by Fitt.inc All rights reserved
 */
package com.fitt.gbt.qbank.common.enums;

/**
 * 预约服务部门
 *
 * @author <a href="mailto:congchun.zcc@gmail.com">congchun.zcc</a>
 * @version 1.0.0
 * @since 2018/04/28
 */
public enum ApptServiceOrgEnum {
    /**
     * 天河区人力资源和社会保障局
     */
    GZTH_MOHRSS("00750851X", "天河区人力资源和社会保障局"),
    /**
     * 天河区人才服务管理办公室
     */
    GZTH_TALENT_OA("G34014976", "天河区人才服务管理办公室"),
    /**
     * 天河区食品药品监督管理局
     */
    GZTH_SFDA("734919147", "天河区食品药品监督管理局"),
    /**
     * 天河区发展和改革局
     */
    GZTH_DEVELOP_REFORM("00750835X", "天河区发展和改革局"),
    /**
     * 天河区教育局
     */
    GZTH_EDUCATION("007508632", "天河区教育局"),
    /**
     * 天河区民族宗教事务局
     */
    GZTH_NATION_RELIGIOUS("007508245", "天河区民族宗教事务局"),
    /**
     * 天河区民政局
     */
    GZTH_CIVIL_AFFAIRS("007508675", "天河区民政局"),
    /**
     * 天河区环境保护局
     */
    GZTH_EPA("007508595", "天河区环境保护局"),
    /**
     * 天河区住房和建设水务局
     */
    GZTH_HOUSEING_CONSTRUCTION("007508405", "天河区住房和建设水务局"),
    /**
     * 天河区农业和园林局
     */
    GZTH_AGRICULTURE_GARDEN("734892300", "天河区农业和园林局"),
    /**
     * 天河区文化广电新闻出版局
     */
    GZTH_WHGDXWCB("007508624", "天河区文化广电新闻出版局"),
    /**
     * 天河区卫生和计划生育局
     */
    GZTH_HEALTH_FAMILY_PLAN("007508640", "天河区卫生和计划生育局"),
    /**
     * 天河区城市管理局
     */
    GZTH_CITY_MANAGEMENT("007508587", "天河区城市管理局"),
    /**
     * 天河区安全生产监督管理局
     */
    GZTH_SAOCMS("781238811", "天河区安全生产监督管理局"),
    /**
     * 天河区商务和金融工作局
     */
    GZTH_BUSINESS_FINANCIAL("734901377", "天河区商务和金融工作局"),
    /**
     * 天河区国土资源和规划局
     */
    GZTH_LAND_RESOURCE_PLAN("455374818", "天河区国土资源和规划局"),
    /**
     * 天河区民防办公室
     */
    GZTH_CIVIL_DENECE("007508608", "天河区民防办公室"),
    /**
     * 天河区科技工业和信息化局
     */
    GZTH_TECHNOLOGY_INDUSTRY_INFO("007508376", "天河区科技工业和信息化局"),
    /**
     * 广州市公安局天河区分局
     */
    GZTH_POLICE("007508683", "广州市公安局天河区分局"),
    /**
     * 天河区市场监督管理局
     */
    GZTH_MARKET_SUPERVISION("33150713-X", "天河区市场监督管理局"),
    /**
     * 未知
     */
    UNKNOWN("-1", "未知");

    String orgCode;
    String orgName;

    ApptServiceOrgEnum(String orgCode, String orgName) {
        this.orgCode = orgCode;
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public ApptServiceOrgEnum getByCode(String orgCode) {
        for (ApptServiceOrgEnum org : ApptServiceOrgEnum.values()) {
            if (org.orgCode.equals(orgCode)) {
                return org;
            }
        }
        return UNKNOWN;
    }
}
