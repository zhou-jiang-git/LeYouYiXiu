package com.fszn.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fszn.system.mapper.YixiuCommodityMapper;
import com.fszn.system.domain.YixiuCommodity;
import com.fszn.system.service.IYixiuCommodityService;
import com.fszn.common.core.text.Convert;

/**
 * 商品管理Service业务层处理
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
@Service
public class YixiuCommodityServiceImpl implements IYixiuCommodityService 
{
    @Autowired
    private YixiuCommodityMapper yixiuCommodityMapper;

    /**
     * 查询商品管理
     * 
     * @param commodityId 商品管理ID
     * @return 商品管理
     */
    @Override
    public YixiuCommodity selectYixiuCommodityById(Integer commodityId)
    {
        return yixiuCommodityMapper.selectYixiuCommodityById(commodityId);
    }

    /**
     * 查询商品管理列表
     * 
     * @param yixiuCommodity 商品管理
     * @return 商品管理
     */
    @Override
    public List<YixiuCommodity> selectYixiuCommodityList(YixiuCommodity yixiuCommodity)
    {
        return yixiuCommodityMapper.selectYixiuCommodityList(yixiuCommodity);
    }

    /**
     * 新增商品管理
     * 
     * @param yixiuCommodity 商品管理
     * @return 结果
     */
    @Override
    public int insertYixiuCommodity(YixiuCommodity yixiuCommodity)
    {
        return yixiuCommodityMapper.insertYixiuCommodity(yixiuCommodity);
    }

    /**
     * 修改商品管理
     * 
     * @param yixiuCommodity 商品管理
     * @return 结果
     */
    @Override
    public int updateYixiuCommodity(YixiuCommodity yixiuCommodity)
    {
        return yixiuCommodityMapper.updateYixiuCommodity(yixiuCommodity);
    }

    /**
     * 删除商品管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYixiuCommodityByIds(String ids)
    {
        return yixiuCommodityMapper.deleteYixiuCommodityByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品管理信息
     * 
     * @param commodityId 商品管理ID
     * @return 结果
     */
    @Override
    public int deleteYixiuCommodityById(Integer commodityId)
    {
        return yixiuCommodityMapper.deleteYixiuCommodityById(commodityId);
    }
}
