package com.fszn.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fszn.system.mapper.YixiuCommodityTypeMapper;
import com.fszn.system.domain.YixiuCommodityType;
import com.fszn.system.service.IYixiuCommodityTypeService;
import com.fszn.common.core.text.Convert;

/**
 * 商品种类管理Service业务层处理
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
@Service
public class YixiuCommodityTypeServiceImpl implements IYixiuCommodityTypeService 
{
    @Autowired
    private YixiuCommodityTypeMapper yixiuCommodityTypeMapper;

    /**
     * 查询商品种类管理
     * 
     * @param commodityTypeId 商品种类管理ID
     * @return 商品种类管理
     */
    @Override
    public YixiuCommodityType selectYixiuCommodityTypeById(Integer commodityTypeId)
    {
        return yixiuCommodityTypeMapper.selectYixiuCommodityTypeById(commodityTypeId);
    }

    /**
     * 查询商品种类管理列表
     * 
     * @param yixiuCommodityType 商品种类管理
     * @return 商品种类管理
     */
    @Override
    public List<YixiuCommodityType> selectYixiuCommodityTypeList(YixiuCommodityType yixiuCommodityType)
    {
        return yixiuCommodityTypeMapper.selectYixiuCommodityTypeList(yixiuCommodityType);
    }

    /**
     * 新增商品种类管理
     * 
     * @param yixiuCommodityType 商品种类管理
     * @return 结果
     */
    @Override
    public int insertYixiuCommodityType(YixiuCommodityType yixiuCommodityType)
    {
        return yixiuCommodityTypeMapper.insertYixiuCommodityType(yixiuCommodityType);
    }

    /**
     * 修改商品种类管理
     * 
     * @param yixiuCommodityType 商品种类管理
     * @return 结果
     */
    @Override
    public int updateYixiuCommodityType(YixiuCommodityType yixiuCommodityType)
    {
        return yixiuCommodityTypeMapper.updateYixiuCommodityType(yixiuCommodityType);
    }

    /**
     * 删除商品种类管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYixiuCommodityTypeByIds(String ids)
    {
        return yixiuCommodityTypeMapper.deleteYixiuCommodityTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商品种类管理信息
     * 
     * @param commodityTypeId 商品种类管理ID
     * @return 结果
     */
    @Override
    public int deleteYixiuCommodityTypeById(Integer commodityTypeId)
    {
        return yixiuCommodityTypeMapper.deleteYixiuCommodityTypeById(commodityTypeId);
    }
}
