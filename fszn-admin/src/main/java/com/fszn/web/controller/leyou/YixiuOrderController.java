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
import com.fszn.system.domain.YixiuOrder;
import com.fszn.system.service.IYixiuOrderService;
import com.fszn.common.core.controller.BaseController;
import com.fszn.common.core.domain.AjaxResult;
import com.fszn.common.utils.poi.ExcelUtil;
import com.fszn.common.core.page.TableDataInfo;

/**
 * 订单管理Controller
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
@Controller
@RequestMapping("/system/order")
public class YixiuOrderController extends BaseController
{
    private String prefix = "system/order";

    @Autowired
    private IYixiuOrderService yixiuOrderService;

    @RequiresPermissions("system:order:view")
    @GetMapping()
    public String order()
    {
        return prefix + "/order";
    }

    /**
     * 查询订单管理列表
     */
    @RequiresPermissions("system:order:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YixiuOrder yixiuOrder)
    {
        startPage();
        List<YixiuOrder> list = yixiuOrderService.selectYixiuOrderList(yixiuOrder);
        return getDataTable(list);
    }

    /**
     * 导出订单管理列表
     */
    @RequiresPermissions("system:order:export")
    @Log(title = "订单管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YixiuOrder yixiuOrder)
    {
        List<YixiuOrder> list = yixiuOrderService.selectYixiuOrderList(yixiuOrder);
        ExcelUtil<YixiuOrder> util = new ExcelUtil<YixiuOrder>(YixiuOrder.class);
        return util.exportExcel(list, "order");
    }

    /**
     * 新增订单管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存订单管理
     */
    @RequiresPermissions("system:order:add")
    @Log(title = "订单管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YixiuOrder yixiuOrder)
    {
        return toAjax(yixiuOrderService.insertYixiuOrder(yixiuOrder));
    }

    /**
     * 修改订单管理
     */
    @GetMapping("/edit/{orderId}")
    public String edit(@PathVariable("orderId") Integer orderId, ModelMap mmap)
    {
        YixiuOrder yixiuOrder = yixiuOrderService.selectYixiuOrderById(orderId);
        mmap.put("yixiuOrder", yixiuOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存订单管理
     */
    @RequiresPermissions("system:order:edit")
    @Log(title = "订单管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YixiuOrder yixiuOrder)
    {
        return toAjax(yixiuOrderService.updateYixiuOrder(yixiuOrder));
    }

    /**
     * 删除订单管理
     */
    @RequiresPermissions("system:order:remove")
    @Log(title = "订单管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(yixiuOrderService.deleteYixiuOrderByIds(ids));
    }
}
