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
import com.fszn.system.domain.YixiuCommodity;
import com.fszn.system.service.IYixiuCommodityService;
import com.fszn.common.core.controller.BaseController;
import com.fszn.common.core.domain.AjaxResult;
import com.fszn.common.utils.poi.ExcelUtil;
import com.fszn.common.core.page.TableDataInfo;

/**
 * 商品管理Controller
 * 
 * @author Ajiang
 * @date 2020-10-20
 */
@Controller
@RequestMapping("/system/commodity")
public class YixiuCommodityController extends BaseController
{
    private String prefix = "system/commodity";

    @Autowired
    private IYixiuCommodityService yixiuCommodityService;

    @RequiresPermissions("system:commodity:view")
    @GetMapping()
    public String commodity()
    {
        return prefix + "/commodity";
    }

    /**
     * 查询商品管理列表
     */
    @RequiresPermissions("system:commodity:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YixiuCommodity yixiuCommodity)
    {
        startPage();
        List<YixiuCommodity> list = yixiuCommodityService.selectYixiuCommodityList(yixiuCommodity);
        return getDataTable(list);
    }

    /**
     * 导出商品管理列表
     */
    @RequiresPermissions("system:commodity:export")
    @Log(title = "商品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YixiuCommodity yixiuCommodity)
    {
        List<YixiuCommodity> list = yixiuCommodityService.selectYixiuCommodityList(yixiuCommodity);
        ExcelUtil<YixiuCommodity> util = new ExcelUtil<YixiuCommodity>(YixiuCommodity.class);
        return util.exportExcel(list, "commodity");
    }

    /**
     * 新增商品管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存商品管理
     */
    @RequiresPermissions("system:commodity:add")
    @Log(title = "商品管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YixiuCommodity yixiuCommodity)
    {
        return toAjax(yixiuCommodityService.insertYixiuCommodity(yixiuCommodity));
    }

    /**
     * 修改商品管理
     */
    @GetMapping("/edit/{commodityId}")
    public String edit(@PathVariable("commodityId") Integer commodityId, ModelMap mmap)
    {
        YixiuCommodity yixiuCommodity = yixiuCommodityService.selectYixiuCommodityById(commodityId);
        mmap.put("yixiuCommodity", yixiuCommodity);
        return prefix + "/edit";
    }

    /**
     * 修改保存商品管理
     */
    @RequiresPermissions("system:commodity:edit")
    @Log(title = "商品管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YixiuCommodity yixiuCommodity)
    {
        return toAjax(yixiuCommodityService.updateYixiuCommodity(yixiuCommodity));
    }

    /**
     * 删除商品管理
     */
    @RequiresPermissions("system:commodity:remove")
    @Log(title = "商品管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(yixiuCommodityService.deleteYixiuCommodityByIds(ids));
    }
}
