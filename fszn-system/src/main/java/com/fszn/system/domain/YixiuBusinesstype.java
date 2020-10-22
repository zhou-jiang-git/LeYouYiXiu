package com.fszn.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fszn.common.annotation.Excel;
import com.fszn.common.core.domain.BaseEntity;

/**
 * 商家种类管理对象 yixiu_businesstype
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
public class YixiuBusinesstype extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 经营种类id */
    private Integer businesstypeId;

    /** 经营种类名称 */
    @Excel(name = "经营种类名称")
    private String businesstypeName;

    public void setBusinesstypeId(Integer businesstypeId) 
    {
        this.businesstypeId = businesstypeId;
    }

    public Integer getBusinesstypeId() 
    {
        return businesstypeId;
    }
    public void setBusinesstypeName(String businesstypeName) 
    {
        this.businesstypeName = businesstypeName;
    }

    public String getBusinesstypeName() 
    {
        return businesstypeName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("businesstypeId", getBusinesstypeId())
            .append("businesstypeName", getBusinesstypeName())
            .toString();
    }
}
