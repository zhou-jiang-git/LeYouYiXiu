package com.fszn.system.service;

import com.fszn.system.domain.YixiuBusinesstype;
import java.util.List;

/**
 * 商家种类管理Service接口
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
public interface IYixiuBusinesstypeService 
{
    /**
     * 查询商家种类管理
     * 
     * @param businesstypeId 商家种类管理ID
     * @return 商家种类管理
     */
    public YixiuBusinesstype selectYixiuBusinesstypeById(Integer businesstypeId);

    /**
     * 查询商家种类管理列表
     * 
     * @param yixiuBusinesstype 商家种类管理
     * @return 商家种类管理集合
     */
    public List<YixiuBusinesstype> selectYixiuBusinesstypeList(YixiuBusinesstype yixiuBusinesstype);

    /**
     * 新增商家种类管理
     * 
     * @param yixiuBusinesstype 商家种类管理
     * @return 结果
     */
    public int insertYixiuBusinesstype(YixiuBusinesstype yixiuBusinesstype);

    /**
     * 修改商家种类管理
     * 
     * @param yixiuBusinesstype 商家种类管理
     * @return 结果
     */
    public int updateYixiuBusinesstype(YixiuBusinesstype yixiuBusinesstype);

    /**
     * 批量删除商家种类管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYixiuBusinesstypeByIds(String ids);

    /**
     * 删除商家种类管理信息
     * 
     * @param businesstypeId 商家种类管理ID
     * @return 结果
     */
    public int deleteYixiuBusinesstypeById(Integer businesstypeId);
}
