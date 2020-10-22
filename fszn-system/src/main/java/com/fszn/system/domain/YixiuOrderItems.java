package com.fszn.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fszn.common.annotation.Excel;
import com.fszn.common.core.domain.BaseEntity;

/**
 * 订单商品管理对象 yixiu_order_items
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
public class YixiuOrderItems extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单商品表id */
    private Integer orderItemsId;

    /** 订单表id */
    @Excel(name = "订单表id")
    private Integer orderId;

    /** 商品交易数量 */
    @Excel(name = "商品交易数量")
    private Integer orderItemsQuantity;

    /** 商品id */
    @Excel(name = "商品id")
    private Integer commodityId;

    /** 交易额 */
    @Excel(name = "交易额")
    private Long orderItemsAmount;

    /** 优惠额 */
    @Excel(name = "优惠额")
    private Long orderItemsPreferential;

    /** 结算额 */
    @Excel(name = "结算额")
    private Long orderItemsSettlement;

    public void setOrderItemsId(Integer orderItemsId) 
    {
        this.orderItemsId = orderItemsId;
    }

    public Integer getOrderItemsId() 
    {
        return orderItemsId;
    }
    public void setOrderId(Integer orderId) 
    {
        this.orderId = orderId;
    }

    public Integer getOrderId() 
    {
        return orderId;
    }
    public void setOrderItemsQuantity(Integer orderItemsQuantity) 
    {
        this.orderItemsQuantity = orderItemsQuantity;
    }

    public Integer getOrderItemsQuantity() 
    {
        return orderItemsQuantity;
    }
    public void setCommodityId(Integer commodityId) 
    {
        this.commodityId = commodityId;
    }

    public Integer getCommodityId() 
    {
        return commodityId;
    }
    public void setOrderItemsAmount(Long orderItemsAmount) 
    {
        this.orderItemsAmount = orderItemsAmount;
    }

    public Long getOrderItemsAmount() 
    {
        return orderItemsAmount;
    }
    public void setOrderItemsPreferential(Long orderItemsPreferential) 
    {
        this.orderItemsPreferential = orderItemsPreferential;
    }

    public Long getOrderItemsPreferential() 
    {
        return orderItemsPreferential;
    }
    public void setOrderItemsSettlement(Long orderItemsSettlement) 
    {
        this.orderItemsSettlement = orderItemsSettlement;
    }

    public Long getOrderItemsSettlement() 
    {
        return orderItemsSettlement;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderItemsId", getOrderItemsId())
            .append("orderId", getOrderId())
            .append("orderItemsQuantity", getOrderItemsQuantity())
            .append("commodityId", getCommodityId())
            .append("orderItemsAmount", getOrderItemsAmount())
            .append("orderItemsPreferential", getOrderItemsPreferential())
            .append("orderItemsSettlement", getOrderItemsSettlement())
            .toString();
    }
}
