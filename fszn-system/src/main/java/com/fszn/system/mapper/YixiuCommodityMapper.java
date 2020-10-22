package com.fszn.system.mapper;

import com.fszn.system.domain.YixiuCommodity;
import java.util.List;

/**
 * 商品管理Mapper接口
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
public interface YixiuCommodityMapper 
{
    /**
     * 查询商品管理
     * 
     * @param commodityId 商品管理ID
     * @return 商品管理
     */
    public YixiuCommodity selectYixiuCommodityById(Integer commodityId);

    /**
     * 查询商品管理列表
     * 
     * @param yixiuCommodity 商品管理
     * @return 商品管理集合
     */
    public List<YixiuCommodity> selectYixiuCommodityList(YixiuCommodity yixiuCommodity);

    /**
     * 新增商品管理
     * 
     * @param yixiuCommodity 商品管理
     * @return 结果
     */
    public int insertYixiuCommodity(YixiuCommodity yixiuCommodity);

    /**
     * 修改商品管理
     * 
     * @param yixiuCommodity 商品管理
     * @return 结果
     */
    public int updateYixiuCommodity(YixiuCommodity yixiuCommodity);

    /**
     * 删除商品管理
     * 
     * @param commodityId 商品管理ID
     * @return 结果
     */
    public int deleteYixiuCommodityById(Integer commodityId);

    /**
     * 批量删除商品管理
     * 
     * @param commodityIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteYixiuCommodityByIds(String[] commodityIds);
}
