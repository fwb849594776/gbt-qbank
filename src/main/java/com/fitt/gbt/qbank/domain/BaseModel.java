package com.fitt.gbt.qbank.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>@Description: 基础模型对象</p>
 * <p>@Author: SixAwn</p>
 * <p>@Created: 2017-07-17</p>
 * <p>@version: 1.0</p>
 */
@Data
public class BaseModel implements Serializable {
    @JsonProperty("create_time")
    private Date createTime;

    @JsonProperty("modify_time")
    private Date modifyTime;

    @JsonProperty("page_no")
    private transient int pageNo;

    @JsonProperty("page_size")
    private transient int pageSize;

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

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
