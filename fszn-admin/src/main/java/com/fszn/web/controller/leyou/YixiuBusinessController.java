package com.fszn.web.controller.leyou;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fszn.common.annotation.Log;
import com.fszn.common.enums.BusinessType;
import com.fszn.system.domain.YixiuBusiness;
import com.fszn.system.service.IYixiuBusinessService;
import com.fszn.common.core.controller.BaseController;
import com.fszn.common.core.domain.AjaxResult;
import com.fszn.common.utils.poi.ExcelUtil;
import com.fszn.common.core.page.TableDataInfo;

/**
 * 商家管理Controller
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
@Controller
@RequestMapping("/system/business")
public class YixiuBusinessController extends BaseController
{
    private String prefix = "system/business";

    @Autowired
    private IYixiuBusinessService yixiuBusinessService;

    @RequiresPermissions("system:business:view")
    @GetMapping()
    public String business()
    {
        return prefix + "/business";
    }

    /**
     * 查询商家管理列表
     */
    @RequiresPermissions("system:business:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YixiuBusiness yixiuBusiness)
    {
        startPage();
        List<YixiuBusiness> list = yixiuBusinessService.selectYixiuBusinessList(yixiuBusiness);
        return getDataTable(list);
    }

    /**
     * 导出商家管理列表
     */
    @RequiresPermissions("system:business:export")
    @Log(title = "商家管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YixiuBusiness yixiuBusiness)
    {
        List<YixiuBusiness> list = yixiuBusinessService.selectYixiuBusinessList(yixiuBusiness);
        ExcelUtil<YixiuBusiness> util = new ExcelUtil<YixiuBusiness>(YixiuBusiness.class);
        return util.exportExcel(list, "business");
    }

    /**
     * 新增商家管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商家管理
     */
    @RequiresPermissions("system:business:add")
    @Log(title = "商家管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YixiuBusiness yixiuBusiness)
    {
        return toAjax(yixiuBusinessService.insertYixiuBusiness(yixiuBusiness));
    }

    /**
     * 修改商家管理
     */
    @GetMapping("/edit/{bid}")
    public String edit(@PathVariable("bid") Integer bid, ModelMap mmap)
    {
        YixiuBusiness yixiuBusiness = yixiuBusinessService.selectYixiuBusinessById(bid);
        mmap.put("yixiuBusiness", yixiuBusiness);
        return prefix + "/edit";
    }

    /**
     * 修改保存商家管理
     */
    @RequiresPermissions("system:business:edit")
    @Log(title = "商家管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YixiuBusiness yixiuBusiness)
    {
        return toAjax(yixiuBusinessService.updateYixiuBusiness(yixiuBusiness));
    }

    /**
     * 删除商家管理
     */
    @RequiresPermissions("system:business:remove")
    @Log(title = "商家管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(yixiuBusinessService.deleteYixiuBusinessByIds(ids));
    }
}
