package com.fszn.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fszn.system.mapper.YixiuOrderItemsMapper;
import com.fszn.system.domain.YixiuOrderItems;
import com.fszn.system.service.IYixiuOrderItemsService;
import com.fszn.common.core.text.Convert;

/**
 * 订单商品管理Service业务层处理
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
@Service
public class YixiuOrderItemsServiceImpl implements IYixiuOrderItemsService 
{
    @Autowired
    private YixiuOrderItemsMapper yixiuOrderItemsMapper;

    /**
     * 查询订单商品管理
     * 
     * @param orderItemsId 订单商品管理ID
     * @return 订单商品管理
     */
    @Override
    public YixiuOrderItems selectYixiuOrderItemsById(Integer orderItemsId)
    {
        return yixiuOrderItemsMapper.selectYixiuOrderItemsById(orderItemsId);
    }

    /**
     * 查询订单商品管理列表
     * 
     * @param yixiuOrderItems 订单商品管理
     * @return 订单商品管理
     */
    @Override
    public List<YixiuOrderItems> selectYixiuOrderItemsList(YixiuOrderItems yixiuOrderItems)
    {
        return yixiuOrderItemsMapper.selectYixiuOrderItemsList(yixiuOrderItems);
    }

    /**
     * 新增订单商品管理
     * 
     * @param yixiuOrderItems 订单商品管理
     * @return 结果
     */
    @Override
    public int insertYixiuOrderItems(YixiuOrderItems yixiuOrderItems)
    {
        return yixiuOrderItemsMapper.insertYixiuOrderItems(yixiuOrderItems);
    }

    /**
     * 修改订单商品管理
     * 
     * @param yixiuOrderItems 订单商品管理
     * @return 结果
     */
    @Override
    public int updateYixiuOrderItems(YixiuOrderItems yixiuOrderItems)
    {
        return yixiuOrderItemsMapper.updateYixiuOrderItems(yixiuOrderItems);
    }

    /**
     * 删除订单商品管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYixiuOrderItemsByIds(String ids)
    {
        return yixiuOrderItemsMapper.deleteYixiuOrderItemsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单商品管理信息
     * 
     * @param orderItemsId 订单商品管理ID
     * @return 结果
     */
    @Override
    public int deleteYixiuOrderItemsById(Integer orderItemsId)
    {
        return yixiuOrderItemsMapper.deleteYixiuOrderItemsById(orderItemsId);
    }
}
