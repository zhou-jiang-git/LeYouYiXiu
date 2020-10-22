package com.fszn.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fszn.system.mapper.YixiuDiscountCategoryMapper;
import com.fszn.system.domain.YixiuDiscountCategory;
import com.fszn.system.service.IYixiuDiscountCategoryService;
import com.fszn.common.core.text.Convert;

/**
 * 折扣种类管理Service业务层处理
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
@Service
public class YixiuDiscountCategoryServiceImpl implements IYixiuDiscountCategoryService 
{
    @Autowired
    private YixiuDiscountCategoryMapper yixiuDiscountCategoryMapper;

    /**
     * 查询折扣种类管理
     * 
     * @param discountCategoryId 折扣种类管理ID
     * @return 折扣种类管理
     */
    @Override
    public YixiuDiscountCategory selectYixiuDiscountCategoryById(Integer discountCategoryId)
    {
        return yixiuDiscountCategoryMapper.selectYixiuDiscountCategoryById(discountCategoryId);
    }

    /**
     * 查询折扣种类管理列表
     * 
     * @param yixiuDiscountCategory 折扣种类管理
     * @return 折扣种类管理
     */
    @Override
    public List<YixiuDiscountCategory> selectYixiuDiscountCategoryList(YixiuDiscountCategory yixiuDiscountCategory)
    {
        return yixiuDiscountCategoryMapper.selectYixiuDiscountCategoryList(yixiuDiscountCategory);
    }

    /**
     * 新增折扣种类管理
     * 
     * @param yixiuDiscountCategory 折扣种类管理
     * @return 结果
     */
    @Override
    public int insertYixiuDiscountCategory(YixiuDiscountCategory yixiuDiscountCategory)
    {
        return yixiuDiscountCategoryMapper.insertYixiuDiscountCategory(yixiuDiscountCategory);
    }

    /**
     * 修改折扣种类管理
     * 
     * @param yixiuDiscountCategory 折扣种类管理
     * @return 结果
     */
    @Override
    public int updateYixiuDiscountCategory(YixiuDiscountCategory yixiuDiscountCategory)
    {
        return yixiuDiscountCategoryMapper.updateYixiuDiscountCategory(yixiuDiscountCategory);
    }

    /**
     * 删除折扣种类管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYixiuDiscountCategoryByIds(String ids)
    {
        return yixiuDiscountCategoryMapper.deleteYixiuDiscountCategoryByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除折扣种类管理信息
     * 
     * @param discountCategoryId 折扣种类管理ID
     * @return 结果
     */
    @Override
    public int deleteYixiuDiscountCategoryById(Integer discountCategoryId)
    {
        return yixiuDiscountCategoryMapper.deleteYixiuDiscountCategoryById(discountCategoryId);
    }
}
