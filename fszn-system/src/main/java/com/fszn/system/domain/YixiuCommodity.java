package com.fszn.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fszn.common.annotation.Excel;
import com.fszn.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 商品管理对象 yixiu_commodity
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
public class YixiuCommodity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 商品id */
    private Integer commodityId;

    /** 店铺id */
    @Excel(name = "店铺id")
    private Integer businessId;

    /** 折扣种类id */
    @Excel(name = "折扣种类id")
    private Integer discountCategoryId;

    /** 商品价格 */
    @Excel(name = "商品价格")
    private Long commodityPrice;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String commodityName;

    /** 商品图片BASE64编码 */
    @Excel(name = "商品图片BASE64编码")
    private String commodityImg;

    /** 商品介绍 */
    @Excel(name = "商品介绍")
    private String commodityIntro;

    /** 商品库存 */
    @Excel(name = "商品库存")
    private Integer commodityInventory;

    /** 商品售出库存 */
    @Excel(name = "商品售出库存")
    private Integer commodityInventorySold;

    /** 商品可售库存 */
    @Excel(name = "商品可售库存")
    private Integer commodityInventoryOnsale;

    /** 商品种类id */
    @Excel(name = "商品种类id")
    private Integer commodityTypeId;

    /** 折扣种类id1 */
    @Excel(name = "折扣种类id1")
    private Integer discountCategoryId1;

    /** 折扣参数A */
    @Excel(name = "折扣参数A")
    private String discountParameterA;

    /** 折扣参数B */
    @Excel(name = "折扣参数B")
    private String discountParameterB;

    /** 折扣种类id2 */
    @Excel(name = "折扣种类id2")
    private Integer discountCategoryId2;

    /** 折扣参数C */
    @Excel(name = "折扣参数C")
    private String discountParameterC;

    /** 折扣参数D */
    @Excel(name = "折扣参数D")
    private String discountParameterD;

    /** 商品在售状态 0  下架  1  上架 */
    @Excel(name = "商品在售状态 0  下架  1  上架")
    private Integer commodityState;

    /** 促销开始时间段 */
    @Excel(name = "促销开始时间段", width = 30, dateFormat = "yyyy-MM-dd")
    private Date commodityPromotionStart;

    /** 促销结束时间段 */
    @Excel(name = "促销结束时间段", width = 30, dateFormat = "yyyy-MM-dd")
    private Date commodityPromotionEnd;

    public void setCommodityId(Integer commodityId) 
    {
        this.commodityId = commodityId;
    }

    public Integer getCommodityId() 
    {
        return commodityId;
    }
    public void setBusinessId(Integer businessId) 
    {
        this.businessId = businessId;
    }

    public Integer getBusinessId() 
    {
        return businessId;
    }
    public void setDiscountCategoryId(Integer discountCategoryId) 
    {
        this.discountCategoryId = discountCategoryId;
    }

    public Integer getDiscountCategoryId() 
    {
        return discountCategoryId;
    }
    public void setCommodityPrice(Long commodityPrice) 
    {
        this.commodityPrice = commodityPrice;
    }

    public Long getCommodityPrice() 
    {
        return commodityPrice;
    }
    public void setCommodityName(String commodityName) 
    {
        this.commodityName = commodityName;
    }

    public String getCommodityName() 
    {
        return commodityName;
    }
    public void setCommodityImg(String commodityImg) 
    {
        this.commodityImg = commodityImg;
    }

    public String getCommodityImg() 
    {
        return commodityImg;
    }
    public void setCommodityIntro(String commodityIntro) 
    {
        this.commodityIntro = commodityIntro;
    }

    public String getCommodityIntro() 
    {
        return commodityIntro;
    }
    public void setCommodityInventory(Integer commodityInventory) 
    {
        this.commodityInventory = commodityInventory;
    }

    public Integer getCommodityInventory() 
    {
        return commodityInventory;
    }
    public void setCommodityInventorySold(Integer commodityInventorySold) 
    {
        this.commodityInventorySold = commodityInventorySold;
    }

    public Integer getCommodityInventorySold() 
    {
        return commodityInventorySold;
    }
    public void setCommodityInventoryOnsale(Integer commodityInventoryOnsale) 
    {
        this.commodityInventoryOnsale = commodityInventoryOnsale;
    }

    public Integer getCommodityInventoryOnsale() 
    {
        return commodityInventoryOnsale;
    }
    public void setCommodityTypeId(Integer commodityTypeId) 
    {
        this.commodityTypeId = commodityTypeId;
    }

    public Integer getCommodityTypeId() 
    {
        return commodityTypeId;
    }
    public void setDiscountCategoryId1(Integer discountCategoryId1) 
    {
        this.discountCategoryId1 = discountCategoryId1;
    }

    public Integer getDiscountCategoryId1() 
    {
        return discountCategoryId1;
    }
    public void setDiscountParameterA(String discountParameterA) 
    {
        this.discountParameterA = discountParameterA;
    }

    public String getDiscountParameterA() 
    {
        return discountParameterA;
    }
    public void setDiscountParameterB(String discountParameterB) 
    {
        this.discountParameterB = discountParameterB;
    }

    public String getDiscountParameterB() 
    {
        return discountParameterB;
    }
    public void setDiscountCategoryId2(Integer discountCategoryId2) 
    {
        this.discountCategoryId2 = discountCategoryId2;
    }

    public Integer getDiscountCategoryId2() 
    {
        return discountCategoryId2;
    }
    public void setDiscountParameterC(String discountParameterC) 
    {
        this.discountParameterC = discountParameterC;
    }

    public String getDiscountParameterC() 
    {
        return discountParameterC;
    }
    public void setDiscountParameterD(String discountParameterD) 
    {
        this.discountParameterD = discountParameterD;
    }

    public String getDiscountParameterD() 
    {
        return discountParameterD;
    }
    public void setCommodityState(Integer commodityState) 
    {
        this.commodityState = commodityState;
    }

    public Integer getCommodityState() 
    {
        return commodityState;
    }
    public void setCommodityPromotionStart(Date commodityPromotionStart) 
    {
        this.commodityPromotionStart = commodityPromotionStart;
    }

    public Date getCommodityPromotionStart() 
    {
        return commodityPromotionStart;
    }
    public void setCommodityPromotionEnd(Date commodityPromotionEnd) 
    {
        this.commodityPromotionEnd = commodityPromotionEnd;
    }

    public Date getCommodityPromotionEnd() 
    {
        return commodityPromotionEnd;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("commodityId", getCommodityId())
            .append("businessId", getBusinessId())
            .append("discountCategoryId", getDiscountCategoryId())
            .append("commodityPrice", getCommodityPrice())
            .append("commodityName", getCommodityName())
            .append("commodityImg", getCommodityImg())
            .append("commodityIntro", getCommodityIntro())
            .append("commodityInventory", getCommodityInventory())
            .append("commodityInventorySold", getCommodityInventorySold())
            .append("commodityInventoryOnsale", getCommodityInventoryOnsale())
            .append("commodityTypeId", getCommodityTypeId())
            .append("discountCategoryId1", getDiscountCategoryId1())
            .append("discountParameterA", getDiscountParameterA())
            .append("discountParameterB", getDiscountParameterB())
            .append("discountCategoryId2", getDiscountCategoryId2())
            .append("discountParameterC", getDiscountParameterC())
            .append("discountParameterD", getDiscountParameterD())
            .append("commodityState", getCommodityState())
            .append("commodityPromotionStart", getCommodityPromotionStart())
            .append("commodityPromotionEnd", getCommodityPromotionEnd())
            .toString();
    }
}
