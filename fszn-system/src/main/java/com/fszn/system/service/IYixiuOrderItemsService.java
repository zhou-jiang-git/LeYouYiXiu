package com.fszn.system.service;

import com.fszn.system.domain.YixiuOrderItems;
import java.util.List;

/**
 * 订单商品管理Service接口
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
public interface IYixiuOrderItemsService 
{
    /**
     * 查询订单商品管理
     * 
     * @param orderItemsId 订单商品管理ID
     * @return 订单商品管理
     */
    public YixiuOrderItems selectYixiuOrderItemsById(Integer orderItemsId);

    /**
     * 查询订单商品管理列表
     * 
     * @param yixiuOrderItems 订单商品管理
     * @return 订单商品管理集合
     */
    public List<YixiuOrderItems> selectYixiuOrderItemsList(YixiuOrderItems yixiuOrderItems);

    /**
     * 新增订单商品管理
     * 
     * @param yixiuOrderItems 订单商品管理
     * @return 结果
     */
    public int insertYixiuOrderItems(YixiuOrderItems yixiuOrderItems);

    /**
     * 修改订单商品管理
     * 
     * @param yixiuOrderItems 订单商品管理
     * @return 结果
     */
    public int updateYixiuOrderItems(YixiuOrderItems yixiuOrderItems);

    /**
     * 批量删除订单商品管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYixiuOrderItemsByIds(String ids);

    /**
     * 删除订单商品管理信息
     * 
     * @param orderItemsId 订单商品管理ID
     * @return 结果
     */
    public int deleteYixiuOrderItemsById(Integer orderItemsId);
}
