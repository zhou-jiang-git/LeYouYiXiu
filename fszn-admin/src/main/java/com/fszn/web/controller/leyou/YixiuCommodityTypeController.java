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
import com.fszn.system.domain.YixiuCommodityType;
import com.fszn.system.service.IYixiuCommodityTypeService;
import com.fszn.common.core.controller.BaseController;
import com.fszn.common.core.domain.AjaxResult;
import com.fszn.common.utils.poi.ExcelUtil;
import com.fszn.common.core.page.TableDataInfo;

/**
 * 商品种类管理Controller
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
@Controller
@RequestMapping("/system/type")
public class YixiuCommodityTypeController extends BaseController
{
    private String prefix = "system/type";

    @Autowired
    private IYixiuCommodityTypeService yixiuCommodityTypeService;

    @RequiresPermissions("system:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询商品种类管理列表
     */
    @RequiresPermissions("system:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YixiuCommodityType yixiuCommodityType)
    {
        startPage();
        List<YixiuCommodityType> list = yixiuCommodityTypeService.selectYixiuCommodityTypeList(yixiuCommodityType);
        return getDataTable(list);
    }

    /**
     * 导出商品种类管理列表
     */
    @RequiresPermissions("system:type:export")
    @Log(title = "商品种类管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YixiuCommodityType yixiuCommodityType)
    {
        List<YixiuCommodityType> list = yixiuCommodityTypeService.selectYixiuCommodityTypeList(yixiuCommodityType);
        ExcelUtil<YixiuCommodityType> util = new ExcelUtil<YixiuCommodityType>(YixiuCommodityType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 新增商品种类管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品种类管理
     */
    @RequiresPermissions("system:type:add")
    @Log(title = "商品种类管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YixiuCommodityType yixiuCommodityType)
    {
        return toAjax(yixiuCommodityTypeService.insertYixiuCommodityType(yixiuCommodityType));
    }

    /**
     * 修改商品种类管理
     */
    @GetMapping("/edit/{commodityTypeId}")
    public String edit(@PathVariable("commodityTypeId") Integer commodityTypeId, ModelMap mmap)
    {
        YixiuCommodityType yixiuCommodityType = yixiuCommodityTypeService.selectYixiuCommodityTypeById(commodityTypeId);
        mmap.put("yixiuCommodityType", yixiuCommodityType);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品种类管理
     */
    @RequiresPermissions("system:type:edit")
    @Log(title = "商品种类管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YixiuCommodityType yixiuCommodityType)
    {
        return toAjax(yixiuCommodityTypeService.updateYixiuCommodityType(yixiuCommodityType));
    }

    /**
     * 删除商品种类管理
     */
    @RequiresPermissions("system:type:remove")
    @Log(title = "商品种类管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(yixiuCommodityTypeService.deleteYixiuCommodityTypeByIds(ids));
    }
}
