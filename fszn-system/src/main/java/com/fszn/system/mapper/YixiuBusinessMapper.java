package com.fszn.system.mapper;

import com.fszn.system.domain.YixiuBusiness;
import java.util.List;

/**
 * 商家管理Mapper接口
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
public interface YixiuBusinessMapper 
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
     * 删除商家管理
     * 
     * @param bid 商家管理ID
     * @return 结果
     */
    public int deleteYixiuBusinessById(Integer bid);

    /**
     * 批量删除商家管理
     * 
     * @param bids 需要删除的数据ID
     * @return 结果
     */
    public int deleteYixiuBusinessByIds(String[] bids);
}
