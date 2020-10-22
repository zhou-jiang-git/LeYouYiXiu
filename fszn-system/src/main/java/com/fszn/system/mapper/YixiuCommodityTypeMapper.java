package com.fszn.system.mapper;

import com.fszn.system.domain.YixiuCommodityType;
import java.util.List;

/**
 * 商品种类管理Mapper接口
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
public interface YixiuCommodityTypeMapper 
{
    /**
     * 查询商品种类管理
     * 
     * @param commodityTypeId 商品种类管理ID
     * @return 商品种类管理
     */
    public YixiuCommodityType selectYixiuCommodityTypeById(Integer commodityTypeId);

    /**
     * 查询商品种类管理列表
     * 
     * @param yixiuCommodityType 商品种类管理
     * @return 商品种类管理集合
     */
    public List<YixiuCommodityType> selectYixiuCommodityTypeList(YixiuCommodityType yixiuCommodityType);

    /**
     * 新增商品种类管理
     * 
     * @param yixiuCommodityType 商品种类管理
     * @return 结果
     */
    public int insertYixiuCommodityType(YixiuCommodityType yixiuCommodityType);

    /**
     * 修改商品种类管理
     * 
     * @param yixiuCommodityType 商品种类管理
     * @return 结果
     */
    public int updateYixiuCommodityType(YixiuCommodityType yixiuCommodityType);

    /**
     * 删除商品种类管理
     * 
     * @param commodityTypeId 商品种类管理ID
     * @return 结果
     */
    public int deleteYixiuCommodityTypeById(Integer commodityTypeId);

    /**
     * 批量删除商品种类管理
     * 
     * @param commodityTypeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteYixiuCommodityTypeByIds(String[] commodityTypeIds);
}
