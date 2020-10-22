package com.fszn.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fszn.common.annotation.Excel;
import com.fszn.common.core.domain.BaseEntity;

/**
 * 折扣种类管理对象 yixiu_discount_category
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
public class YixiuDiscountCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 折扣种类id */
    private Integer discountCategoryId;

    /** 折扣种类名称 */
    @Excel(name = "折扣种类名称")
    private String discountCategoryName;

    /** 折扣模式取1/取2 */
    @Excel(name = "折扣模式取1/取2")
    private Integer discountCategoryRule;

    public void setDiscountCategoryId(Integer discountCategoryId) 
    {
        this.discountCategoryId = discountCategoryId;
    }

    public Integer getDiscountCategoryId() 
    {
        return discountCategoryId;
    }
    public void setDiscountCategoryName(String discountCategoryName) 
    {
        this.discountCategoryName = discountCategoryName;
    }

    public String getDiscountCategoryName() 
    {
        return discountCategoryName;
    }
    public void setDiscountCategoryRule(Integer discountCategoryRule) 
    {
        this.discountCategoryRule = discountCategoryRule;
    }

    public Integer getDiscountCategoryRule() 
    {
        return discountCategoryRule;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("discountCategoryId", getDiscountCategoryId())
            .append("discountCategoryName", getDiscountCategoryName())
            .append("discountCategoryRule", getDiscountCategoryRule())
            .toString();
    }
}
