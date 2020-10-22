package com.fszn.system.mapper;

import com.fszn.system.domain.YixiuDiscountCategory;
import java.util.List;

/**
 * 折扣种类管理Mapper接口
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
public interface YixiuDiscountCategoryMapper 
{
    /**
     * 查询折扣种类管理
     * 
     * @param discountCategoryId 折扣种类管理ID
     * @return 折扣种类管理
     */
    public YixiuDiscountCategory selectYixiuDiscountCategoryById(Integer discountCategoryId);

    /**
     * 查询折扣种类管理列表
     * 
     * @param yixiuDiscountCategory 折扣种类管理
     * @return 折扣种类管理集合
     */
    public List<YixiuDiscountCategory> selectYixiuDiscountCategoryList(YixiuDiscountCategory yixiuDiscountCategory);

    /**
     * 新增折扣种类管理
     * 
     * @param yixiuDiscountCategory 折扣种类管理
     * @return 结果
     */
    public int insertYixiuDiscountCategory(YixiuDiscountCategory yixiuDiscountCategory);

    /**
     * 修改折扣种类管理
     * 
     * @param yixiuDiscountCategory 折扣种类管理
     * @return 结果
     */
    public int updateYixiuDiscountCategory(YixiuDiscountCategory yixiuDiscountCategory);

    /**
     * 删除折扣种类管理
     * 
     * @param discountCategoryId 折扣种类管理ID
     * @return 结果
     */
    public int deleteYixiuDiscountCategoryById(Integer discountCategoryId);

    /**
     * 批量删除折扣种类管理
     * 
     * @param discountCategoryIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteYixiuDiscountCategoryByIds(String[] discountCategoryIds);
}
