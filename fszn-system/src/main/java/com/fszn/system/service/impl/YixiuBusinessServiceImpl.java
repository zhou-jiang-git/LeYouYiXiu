package com.fszn.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fszn.system.mapper.YixiuBusinessMapper;
import com.fszn.system.domain.YixiuBusiness;
import com.fszn.system.service.IYixiuBusinessService;
import com.fszn.common.core.text.Convert;

/**
 * 商家管理Service业务层处理
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
@Service
public class YixiuBusinessServiceImpl implements IYixiuBusinessService 
{
    @Autowired
    private YixiuBusinessMapper yixiuBusinessMapper;

    /**
     * 查询商家管理
     * 
     * @param bid 商家管理ID
     * @return 商家管理
     */
    @Override
    public YixiuBusiness selectYixiuBusinessById(Integer bid)
    {
        return yixiuBusinessMapper.selectYixiuBusinessById(bid);
    }

    /**
     * 查询商家管理列表
     * 
     * @param yixiuBusiness 商家管理
     * @return 商家管理
     */
    @Override
    public List<YixiuBusiness> selectYixiuBusinessList(YixiuBusiness yixiuBusiness)
    {
        return yixiuBusinessMapper.selectYixiuBusinessList(yixiuBusiness);
    }

    /**
     * 新增商家管理
     * 
     * @param yixiuBusiness 商家管理
     * @return 结果
     */
    @Override
    public int insertYixiuBusiness(YixiuBusiness yixiuBusiness)
    {
        return yixiuBusinessMapper.insertYixiuBusiness(yixiuBusiness);
    }

    /**
     * 修改商家管理
     * 
     * @param yixiuBusiness 商家管理
     * @return 结果
     */
    @Override
    public int updateYixiuBusiness(YixiuBusiness yixiuBusiness)
    {
        return yixiuBusinessMapper.updateYixiuBusiness(yixiuBusiness);
    }

    /**
     * 删除商家管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYixiuBusinessByIds(String ids)
    {
        return yixiuBusinessMapper.deleteYixiuBusinessByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商家管理信息
     * 
     * @param bid 商家管理ID
     * @return 结果
     */
    @Override
    public int deleteYixiuBusinessById(Integer bid)
    {
        return yixiuBusinessMapper.deleteYixiuBusinessById(bid);
    }
}
