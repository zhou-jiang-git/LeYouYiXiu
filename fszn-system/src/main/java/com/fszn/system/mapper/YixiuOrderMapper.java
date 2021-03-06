package com.fszn.system.mapper;

import com.fszn.system.domain.YixiuOrder;
import java.util.List;

/**
 * 订单管理Mapper接口
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
public interface YixiuOrderMapper 
{
    /**
     * 查询订单管理
     * 
     * @param orderId 订单管理ID
     * @return 订单管理
     */
    public YixiuOrder selectYixiuOrderById(Integer orderId);

    /**
     * 查询订单管理列表
     * 
     * @param yixiuOrder 订单管理
     * @return 订单管理集合
     */
    public List<YixiuOrder> selectYixiuOrderList(YixiuOrder yixiuOrder);

    /**
     * 新增订单管理
     * 
     * @param yixiuOrder 订单管理
     * @return 结果
     */
    public int insertYixiuOrder(YixiuOrder yixiuOrder);

    /**
     * 修改订单管理
     * 
     * @param yixiuOrder 订单管理
     * @return 结果
     */
    public int updateYixiuOrder(YixiuOrder yixiuOrder);

    /**
     * 删除订单管理
     * 
     * @param orderId 订单管理ID
     * @return 结果
     */
    public int deleteYixiuOrderById(Integer orderId);

    /**
     * 批量删除订单管理
     * 
     * @param orderIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteYixiuOrderByIds(String[] orderIds);
}
