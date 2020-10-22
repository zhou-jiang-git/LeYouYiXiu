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
import com.fszn.system.domain.YixiuOrderItems;
import com.fszn.system.service.IYixiuOrderItemsService;
import com.fszn.common.core.controller.BaseController;
import com.fszn.common.core.domain.AjaxResult;
import com.fszn.common.utils.poi.ExcelUtil;
import com.fszn.common.core.page.TableDataInfo;

/**
 * 订单商品管理Controller
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
@Controller
@RequestMapping("/system/items")
public class YixiuOrderItemsController extends BaseController
{
    private String prefix = "system/items";

    @Autowired
    private IYixiuOrderItemsService yixiuOrderItemsService;

    @RequiresPermissions("system:items:view")
    @GetMapping()
    public String items()
    {
        return prefix + "/items";
    }

    /**
     * 查询订单商品管理列表
     */
    @RequiresPermissions("system:items:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YixiuOrderItems yixiuOrderItems)
    {
        startPage();
        List<YixiuOrderItems> list = yixiuOrderItemsService.selectYixiuOrderItemsList(yixiuOrderItems);
        return getDataTable(list);
    }

    /**
     * 导出订单商品管理列表
     */
    @RequiresPermissions("system:items:export")
    @Log(title = "订单商品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YixiuOrderItems yixiuOrderItems)
    {
        List<YixiuOrderItems> list = yixiuOrderItemsService.selectYixiuOrderItemsList(yixiuOrderItems);
        ExcelUtil<YixiuOrderItems> util = new ExcelUtil<YixiuOrderItems>(YixiuOrderItems.class);
        return util.exportExcel(list, "items");
    }

    /**
     * 新增订单商品管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存订单商品管理
     */
    @RequiresPermissions("system:items:add")
    @Log(title = "订单商品管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YixiuOrderItems yixiuOrderItems)
    {
        return toAjax(yixiuOrderItemsService.insertYixiuOrderItems(yixiuOrderItems));
    }

    /**
     * 修改订单商品管理
     */
    @GetMapping("/edit/{orderItemsId}")
    public String edit(@PathVariable("orderItemsId") Integer orderItemsId, ModelMap mmap)
    {
        YixiuOrderItems yixiuOrderItems = yixiuOrderItemsService.selectYixiuOrderItemsById(orderItemsId);
        mmap.put("yixiuOrderItems", yixiuOrderItems);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单商品管理
     */
    @RequiresPermissions("system:items:edit")
    @Log(title = "订单商品管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YixiuOrderItems yixiuOrderItems)
    {
        return toAjax(yixiuOrderItemsService.updateYixiuOrderItems(yixiuOrderItems));
    }

    /**
     * 删除订单商品管理
     */
    @RequiresPermissions("system:items:remove")
    @Log(title = "订单商品管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(yixiuOrderItemsService.deleteYixiuOrderItemsByIds(ids));
    }
}
