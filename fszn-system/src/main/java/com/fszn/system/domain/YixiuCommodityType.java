package com.fszn.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fszn.common.annotation.Excel;
import com.fszn.common.core.domain.BaseEntity;

/**
 * 商品种类管理对象 yixiu_commodity_type
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
public class YixiuCommodityType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品种类id */
    private Integer commodityTypeId;

    /** 商品种类名称 */
    @Excel(name = "商品种类名称")
    private String commodityTypeName;

    /** 商品交易规则     限量0  不限量1 */
    @Excel(name = "商品交易规则     限量0  不限量1")
    private Integer commodityTypeRule;

    public void setCommodityTypeId(Integer commodityTypeId) 
    {
        this.commodityTypeId = commodityTypeId;
    }

    public Integer getCommodityTypeId() 
    {
        return commodityTypeId;
    }
    public void setCommodityTypeName(String commodityTypeName) 
    {
        this.commodityTypeName = commodityTypeName;
    }

    public String getCommodityTypeName() 
    {
        return commodityTypeName;
    }
    public void setCommodityTypeRule(Integer commodityTypeRule) 
    {
        this.commodityTypeRule = commodityTypeRule;
    }

    public Integer getCommodityTypeRule() 
    {
        return commodityTypeRule;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("commodityTypeId", getCommodityTypeId())
            .append("commodityTypeName", getCommodityTypeName())
            .append("commodityTypeRule", getCommodityTypeRule())
            .toString();
    }
}
