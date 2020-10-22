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
import com.fszn.system.domain.YixiuDiscountCategory;
import com.fszn.system.service.IYixiuDiscountCategoryService;
import com.fszn.common.core.controller.BaseController;
import com.fszn.common.core.domain.AjaxResult;
import com.fszn.common.utils.poi.ExcelUtil;
import com.fszn.common.core.page.TableDataInfo;

/**
 * 折扣种类管理Controller
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
@Controller
@RequestMapping("/system/category")
public class YixiuDiscountCategoryController extends BaseController
{
    private String prefix = "system/category";

    @Autowired
    private IYixiuDiscountCategoryService yixiuDiscountCategoryService;

    @RequiresPermissions("system:category:view")
    @GetMapping()
    public String category()
    {
        return prefix + "/category";
    }

    /**
     * 查询折扣种类管理列表
     */
    @RequiresPermissions("system:category:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YixiuDiscountCategory yixiuDiscountCategory)
    {
        startPage();
        List<YixiuDiscountCategory> list = yixiuDiscountCategoryService.selectYixiuDiscountCategoryList(yixiuDiscountCategory);
        return getDataTable(list);
    }

    /**
     * 导出折扣种类管理列表
     */
    @RequiresPermissions("system:category:export")
    @Log(title = "折扣种类管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YixiuDiscountCategory yixiuDiscountCategory)
    {
        List<YixiuDiscountCategory> list = yixiuDiscountCategoryService.selectYixiuDiscountCategoryList(yixiuDiscountCategory);
        ExcelUtil<YixiuDiscountCategory> util = new ExcelUtil<YixiuDiscountCategory>(YixiuDiscountCategory.class);
        return util.exportExcel(list, "category");
    }

    /**
     * 新增折扣种类管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存折扣种类管理
     */
    @RequiresPermissions("system:category:add")
    @Log(title = "折扣种类管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YixiuDiscountCategory yixiuDiscountCategory)
    {
        return toAjax(yixiuDiscountCategoryService.insertYixiuDiscountCategory(yixiuDiscountCategory));
    }

    /**
     * 修改折扣种类管理
     */
    @GetMapping("/edit/{discountCategoryId}")
    public String edit(@PathVariable("discountCategoryId") Integer discountCategoryId, ModelMap mmap)
    {
        YixiuDiscountCategory yixiuDiscountCategory = yixiuDiscountCategoryService.selectYixiuDiscountCategoryById(discountCategoryId);
        mmap.put("yixiuDiscountCategory", yixiuDiscountCategory);
        return prefix + "/edit";
    }

    /**
     * 修改保存折扣种类管理
     */
    @RequiresPermissions("system:category:edit")
    @Log(title = "折扣种类管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YixiuDiscountCategory yixiuDiscountCategory)
    {
        return toAjax(yixiuDiscountCategoryService.updateYixiuDiscountCategory(yixiuDiscountCategory));
    }

    /**
     * 删除折扣种类管理
     */
    @RequiresPermissions("system:category:remove")
    @Log(title = "折扣种类管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(yixiuDiscountCategoryService.deleteYixiuDiscountCategoryByIds(ids));
    }
}
