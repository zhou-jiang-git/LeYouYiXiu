package com.fszn.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fszn.system.mapper.YixiuOrderMapper;
import com.fszn.system.domain.YixiuOrder;
import com.fszn.system.service.IYixiuOrderService;
import com.fszn.common.core.text.Convert;

/**
 * 订单管理Service业务层处理
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
@Service
public class YixiuOrderServiceImpl implements IYixiuOrderService 
{
    @Autowired
    private YixiuOrderMapper yixiuOrderMapper;

    /**
     * 查询订单管理
     * 
     * @param orderId 订单管理ID
     * @return 订单管理
     */
    @Override
    public YixiuOrder selectYixiuOrderById(Integer orderId)
    {
        return yixiuOrderMapper.selectYixiuOrderById(orderId);
    }

    /**
     * 查询订单管理列表
     * 
     * @param yixiuOrder 订单管理
     * @return 订单管理
     */
    @Override
    public List<YixiuOrder> selectYixiuOrderList(YixiuOrder yixiuOrder)
    {
        return yixiuOrderMapper.selectYixiuOrderList(yixiuOrder);
    }

    /**
     * 新增订单管理
     * 
     * @param yixiuOrder 订单管理
     * @return 结果
     */
    @Override
    public int insertYixiuOrder(YixiuOrder yixiuOrder)
    {
        return yixiuOrderMapper.insertYixiuOrder(yixiuOrder);
    }

    /**
     * 修改订单管理
     * 
     * @param yixiuOrder 订单管理
     * @return 结果
     */
    @Override
    public int updateYixiuOrder(YixiuOrder yixiuOrder)
    {
        return yixiuOrderMapper.updateYixiuOrder(yixiuOrder);
    }

    /**
     * 删除订单管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYixiuOrderByIds(String ids)
    {
        return yixiuOrderMapper.deleteYixiuOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除订单管理信息
     * 
     * @param orderId 订单管理ID
     * @return 结果
     */
    @Override
    public int deleteYixiuOrderById(Integer orderId)
    {
        return yixiuOrderMapper.deleteYixiuOrderById(orderId);
    }
}
