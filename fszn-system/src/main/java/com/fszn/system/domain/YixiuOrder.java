package com.fszn.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fszn.common.annotation.Excel;
import com.fszn.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 订单管理对象 yixiu_order
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
public class YixiuOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单id */
    private Integer orderId;

    /** 游客id */
    @Excel(name = "游客id")
    private Integer touristId;

    /** 商家id */
    @Excel(name = "商家id")
    private Integer businessId;

    /** 交易总金额 */
    @Excel(name = "交易总金额")
    private Long orderTotalAmount;

    /** 优惠金额 */
    @Excel(name = "优惠金额")
    private Long orderPreferentialAmount;

    /** 结算金额 */
    @Excel(name = "结算金额")
    private Long orderSettlementAmount;

    /** 生成时间 */
    @Excel(name = "生成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderGenerationTime;

    /** 订单商品id */
    @Excel(name = "订单商品id")
    private Integer orderItemsId;

    /** 订单交易状态  0未支付  1已支付 */
    @Excel(name = "订单交易状态  0未支付  1已支付")
    private Integer orderState;

    /** 订单结算时间 */
    @Excel(name = "订单结算时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderSettlementTime;

    public void setOrderId(Integer orderId) 
    {
        this.orderId = orderId;
    }

    public Integer getOrderId() 
    {
        return orderId;
    }
    public void setTouristId(Integer touristId) 
    {
        this.touristId = touristId;
    }

    public Integer getTouristId() 
    {
        return touristId;
    }
    public void setBusinessId(Integer businessId) 
    {
        this.businessId = businessId;
    }

    public Integer getBusinessId() 
    {
        return businessId;
    }
    public void setOrderTotalAmount(Long orderTotalAmount) 
    {
        this.orderTotalAmount = orderTotalAmount;
    }

    public Long getOrderTotalAmount() 
    {
        return orderTotalAmount;
    }
    public void setOrderPreferentialAmount(Long orderPreferentialAmount) 
    {
        this.orderPreferentialAmount = orderPreferentialAmount;
    }

    public Long getOrderPreferentialAmount() 
    {
        return orderPreferentialAmount;
    }
    public void setOrderSettlementAmount(Long orderSettlementAmount) 
    {
        this.orderSettlementAmount = orderSettlementAmount;
    }

    public Long getOrderSettlementAmount() 
    {
        return orderSettlementAmount;
    }
    public void setOrderGenerationTime(Date orderGenerationTime) 
    {
        this.orderGenerationTime = orderGenerationTime;
    }

    public Date getOrderGenerationTime() 
    {
        return orderGenerationTime;
    }
    public void setOrderItemsId(Integer orderItemsId) 
    {
        this.orderItemsId = orderItemsId;
    }

    public Integer getOrderItemsId() 
    {
        return orderItemsId;
    }
    public void setOrderState(Integer orderState) 
    {
        this.orderState = orderState;
    }

    public Integer getOrderState() 
    {
        return orderState;
    }
    public void setOrderSettlementTime(Date orderSettlementTime) 
    {
        this.orderSettlementTime = orderSettlementTime;
    }

    public Date getOrderSettlementTime() 
    {
        return orderSettlementTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("touristId", getTouristId())
            .append("businessId", getBusinessId())
            .append("orderTotalAmount", getOrderTotalAmount())
            .append("orderPreferentialAmount", getOrderPreferentialAmount())
            .append("orderSettlementAmount", getOrderSettlementAmount())
            .append("orderGenerationTime", getOrderGenerationTime())
            .append("orderItemsId", getOrderItemsId())
            .append("orderState", getOrderState())
            .append("orderSettlementTime", getOrderSettlementTime())
            .toString();
    }
}
