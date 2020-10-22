package com.fszn.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fszn.system.mapper.YixiuBusinesstypeMapper;
import com.fszn.system.domain.YixiuBusinesstype;
import com.fszn.system.service.IYixiuBusinesstypeService;
import com.fszn.common.core.text.Convert;

/**
 * 商家种类管理Service业务层处理
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
@Service
public class YixiuBusinesstypeServiceImpl implements IYixiuBusinesstypeService 
{
    @Autowired
    private YixiuBusinesstypeMapper yixiuBusinesstypeMapper;

    /**
     * 查询商家种类管理
     * 
     * @param businesstypeId 商家种类管理ID
     * @return 商家种类管理
     */
    @Override
    public YixiuBusinesstype selectYixiuBusinesstypeById(Integer businesstypeId)
    {
        return yixiuBusinesstypeMapper.selectYixiuBusinesstypeById(businesstypeId);
    }

    /**
     * 查询商家种类管理列表
     * 
     * @param yixiuBusinesstype 商家种类管理
     * @return 商家种类管理
     */
    @Override
    public List<YixiuBusinesstype> selectYixiuBusinesstypeList(YixiuBusinesstype yixiuBusinesstype)
    {
        return yixiuBusinesstypeMapper.selectYixiuBusinesstypeList(yixiuBusinesstype);
    }

    /**
     * 新增商家种类管理
     * 
     * @param yixiuBusinesstype 商家种类管理
     * @return 结果
     */
    @Override
    public int insertYixiuBusinesstype(YixiuBusinesstype yixiuBusinesstype)
    {
        return yixiuBusinesstypeMapper.insertYixiuBusinesstype(yixiuBusinesstype);
    }

    /**
     * 修改商家种类管理
     * 
     * @param yixiuBusinesstype 商家种类管理
     * @return 结果
     */
    @Override
    public int updateYixiuBusinesstype(YixiuBusinesstype yixiuBusinesstype)
    {
        return yixiuBusinesstypeMapper.updateYixiuBusinesstype(yixiuBusinesstype);
    }

    /**
     * 删除商家种类管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteYixiuBusinesstypeByIds(String ids)
    {
        return yixiuBusinesstypeMapper.deleteYixiuBusinesstypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除商家种类管理信息
     * 
     * @param businesstypeId 商家种类管理ID
     * @return 结果
     */
    @Override
    public int deleteYixiuBusinesstypeById(Integer businesstypeId)
    {
        return yixiuBusinesstypeMapper.deleteYixiuBusinesstypeById(businesstypeId);
    }
}
