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
import com.fszn.system.domain.YixiuBusinesstype;
import com.fszn.system.service.IYixiuBusinesstypeService;
import com.fszn.common.core.controller.BaseController;
import com.fszn.common.core.domain.AjaxResult;
import com.fszn.common.utils.poi.ExcelUtil;
import com.fszn.common.core.page.TableDataInfo;

/**
 * 商家种类管理Controller
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
@Controller
@RequestMapping("/system/businesstype")
public class YixiuBusinesstypeController extends BaseController
{
    private String prefix = "system/businesstype";

    @Autowired
    private IYixiuBusinesstypeService yixiuBusinesstypeService;

    @RequiresPermissions("system:businesstype:view")
    @GetMapping()
    public String businesstype()
    {
        return prefix + "/businesstype";
    }

    /**
     * 查询商家种类管理列表
     */
    @RequiresPermissions("system:businesstype:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YixiuBusinesstype yixiuBusinesstype)
    {
        startPage();
        List<YixiuBusinesstype> list = yixiuBusinesstypeService.selectYixiuBusinesstypeList(yixiuBusinesstype);
        return getDataTable(list);
    }

    /**
     * 导出商家种类管理列表
     */
    @RequiresPermissions("system:businesstype:export")
    @Log(title = "商家种类管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YixiuBusinesstype yixiuBusinesstype)
    {
        List<YixiuBusinesstype> list = yixiuBusinesstypeService.selectYixiuBusinesstypeList(yixiuBusinesstype);
        ExcelUtil<YixiuBusinesstype> util = new ExcelUtil<YixiuBusinesstype>(YixiuBusinesstype.class);
        return util.exportExcel(list, "businesstype");
    }

    /**
     * 新增商家种类管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商家种类管理
     */
    @RequiresPermissions("system:businesstype:add")
    @Log(title = "商家种类管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YixiuBusinesstype yixiuBusinesstype)
    {
        return toAjax(yixiuBusinesstypeService.insertYixiuBusinesstype(yixiuBusinesstype));
    }

    /**
     * 修改商家种类管理
     */
    @GetMapping("/edit/{businesstypeId}")
    public String edit(@PathVariable("businesstypeId") Integer businesstypeId, ModelMap mmap)
    {
        YixiuBusinesstype yixiuBusinesstype = yixiuBusinesstypeService.selectYixiuBusinesstypeById(businesstypeId);
        mmap.put("yixiuBusinesstype", yixiuBusinesstype);
        return prefix + "/edit";
    }

    /**
     * 修改保存商家种类管理
     */
    @RequiresPermissions("system:businesstype:edit")
    @Log(title = "商家种类管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YixiuBusinesstype yixiuBusinesstype)
    {
        return toAjax(yixiuBusinesstypeService.updateYixiuBusinesstype(yixiuBusinesstype));
    }

    /**
     * 删除商家种类管理
     */
    @RequiresPermissions("system:businesstype:remove")
    @Log(title = "商家种类管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(yixiuBusinesstypeService.deleteYixiuBusinesstypeByIds(ids));
    }
}
