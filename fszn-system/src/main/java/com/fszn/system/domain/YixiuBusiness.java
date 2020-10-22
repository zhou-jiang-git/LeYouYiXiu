package com.fszn.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.fszn.common.annotation.Excel;
import com.fszn.common.core.domain.BaseEntity;
import java.util.Date;

/**
 * 商家管理对象 yixiu_business
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
public class YixiuBusiness extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 店铺表ID */
    private Integer bid;

    /** 商家id */
    @Excel(name = "商家id")
    private Integer businessId;

    /** 店铺名称 */
    @Excel(name = "店铺名称")
    private String businessName;

    /** 店铺标题 */
    @Excel(name = "店铺标题")
    private String businessTitle;

    /** 店铺大图地址 */
    @Excel(name = "店铺大图地址")
    private String businessPicture;

    /** 店铺详细介绍 */
    @Excel(name = "店铺详细介绍")
    private String businessIntro;

    /** 店铺注册时间 */
    @Excel(name = "店铺注册时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date businessRegist;

    /** 店铺修改时间 */
    @Excel(name = "店铺修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date businessModify;

    /** 商家认证状态（是否展示）0不展示 1 展示 */
    @Excel(name = "商家认证状态", readConverterExp = "是=否展示")
    private Integer businessStatus;

    /** 区信息 */
    @Excel(name = "区信息")
    private String businessArea;

    /** 经营种类ID */
    @Excel(name = "经营种类ID")
    private Integer businessType;

    /** 店铺交易量 */
    @Excel(name = "店铺交易量")
    private Integer businessTrading;

    /** 店铺交易总金额 */
    @Excel(name = "店铺交易总金额")
    private Long businessAmount;

    /** 店铺浏览量 */
    @Excel(name = "店铺浏览量")
    private Integer businessBrowse;

    /** 店铺地址 */
    @Excel(name = "店铺地址")
    private String businessAddress;

    public void setBid(Integer bid) 
    {
        this.bid = bid;
    }

    public Integer getBid() 
    {
        return bid;
    }
    public void setBusinessId(Integer businessId) 
    {
        this.businessId = businessId;
    }

    public Integer getBusinessId() 
    {
        return businessId;
    }
    public void setBusinessName(String businessName) 
    {
        this.businessName = businessName;
    }

    public String getBusinessName() 
    {
        return businessName;
    }
    public void setBusinessTitle(String businessTitle) 
    {
        this.businessTitle = businessTitle;
    }

    public String getBusinessTitle() 
    {
        return businessTitle;
    }
    public void setBusinessPicture(String businessPicture) 
    {
        this.businessPicture = businessPicture;
    }

    public String getBusinessPicture() 
    {
        return businessPicture;
    }
    public void setBusinessIntro(String businessIntro) 
    {
        this.businessIntro = businessIntro;
    }

    public String getBusinessIntro() 
    {
        return businessIntro;
    }
    public void setBusinessRegist(Date businessRegist) 
    {
        this.businessRegist = businessRegist;
    }

    public Date getBusinessRegist() 
    {
        return businessRegist;
    }
    public void setBusinessModify(Date businessModify) 
    {
        this.businessModify = businessModify;
    }

    public Date getBusinessModify() 
    {
        return businessModify;
    }
    public void setBusinessStatus(Integer businessStatus) 
    {
        this.businessStatus = businessStatus;
    }

    public Integer getBusinessStatus() 
    {
        return businessStatus;
    }
    public void setBusinessArea(String businessArea) 
    {
        this.businessArea = businessArea;
    }

    public String getBusinessArea() 
    {
        return businessArea;
    }
    public void setBusinessType(Integer businessType) 
    {
        this.businessType = businessType;
    }

    public Integer getBusinessType() 
    {
        return businessType;
    }
    public void setBusinessTrading(Integer businessTrading) 
    {
        this.businessTrading = businessTrading;
    }

    public Integer getBusinessTrading() 
    {
        return businessTrading;
    }
    public void setBusinessAmount(Long businessAmount) 
    {
        this.businessAmount = businessAmount;
    }

    public Long getBusinessAmount() 
    {
        return businessAmount;
    }
    public void setBusinessBrowse(Integer businessBrowse) 
    {
        this.businessBrowse = businessBrowse;
    }

    public Integer getBusinessBrowse() 
    {
        return businessBrowse;
    }
    public void setBusinessAddress(String businessAddress) 
    {
        this.businessAddress = businessAddress;
    }

    public String getBusinessAddress() 
    {
        return businessAddress;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("bid", getBid())
            .append("businessId", getBusinessId())
            .append("businessName", getBusinessName())
            .append("businessTitle", getBusinessTitle())
            .append("businessPicture", getBusinessPicture())
            .append("businessIntro", getBusinessIntro())
            .append("businessRegist", getBusinessRegist())
            .append("businessModify", getBusinessModify())
            .append("businessStatus", getBusinessStatus())
            .append("businessArea", getBusinessArea())
            .append("businessType", getBusinessType())
            .append("businessTrading", getBusinessTrading())
            .append("businessAmount", getBusinessAmount())
            .append("businessBrowse", getBusinessBrowse())
            .append("businessAddress", getBusinessAddress())
            .toString();
    }
}
