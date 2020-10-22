package com.fszn.system.service;

import com.fszn.system.domain.YixiuDiscountCategory;
import java.util.List;

/**
 * 折扣种类管理Service接口
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
public interface IYixiuDiscountCategoryService 
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
     * 批量删除折扣种类管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYixiuDiscountCategoryByIds(String ids);

    /**
     * 删除折扣种类管理信息
     * 
     * @param discountCategoryId 折扣种类管理ID
     * @return 结果
     */
    public int deleteYixiuDiscountCategoryById(Integer discountCategoryId);
}
