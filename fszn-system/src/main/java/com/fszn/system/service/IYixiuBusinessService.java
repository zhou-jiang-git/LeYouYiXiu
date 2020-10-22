package com.fszn.system.service;

import com.fszn.system.domain.YixiuBusiness;
import java.util.List;

/**
 * 商家管理Service接口
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
public interface IYixiuBusinessService 
{
    /**
     * 查询商家管理
     * 
     * @param bid 商家管理ID
     * @return 商家管理
     */
    public YixiuBusiness selectYixiuBusinessById(Integer bid);

    /**
     * 查询商家管理列表
     * 
     * @param yixiuBusiness 商家管理
     * @return 商家管理集合
     */
    public List<YixiuBusiness> selectYixiuBusinessList(YixiuBusiness yixiuBusiness);

    /**
     * 新增商家管理
     * 
     * @param yixiuBusiness 商家管理
     * @return 结果
     */
    public int insertYixiuBusiness(YixiuBusiness yixiuBusiness);

    /**
     * 修改商家管理
     * 
     * @param yixiuBusiness 商家管理
     * @return 结果
     */
    public int updateYixiuBusiness(YixiuBusiness yixiuBusiness);

    /**
     * 批量删除商家管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYixiuBusinessByIds(String ids);

    /**
     * 删除商家管理信息
     * 
     * @param bid 商家管理ID
     * @return 结果
     */
    public int deleteYixiuBusinessById(Integer bid);
}
