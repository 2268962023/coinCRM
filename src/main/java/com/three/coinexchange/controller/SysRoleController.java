package com.three.coinexchange.controller;

import com.three.coinexchange.base.BaseController;
import com.three.coinexchange.base.ResultInfo;
import com.three.coinexchange.bean.SysRole;
import com.three.coinexchange.query.SysRoleQuery;
import com.three.coinexchange.query.SysUserQuery;
import com.three.coinexchange.service.SysRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("sysRole")
public class SysRoleController extends BaseController {

    @Resource
    private SysRoleService sysRoleService;

    @RequestMapping("index")
    public String index() {
        return "role/role";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> querySysRoleByParams(SysRoleQuery sysRoleQuery) {
        return sysRoleService.querySysRoleByParams(sysRoleQuery);
    }

    @RequestMapping("queryAllRoles")
    @ResponseBody
    public List<Map<String, Object>> queryAllRoles(Integer userId) {
        return sysRoleService.findRoles(userId);
    }

    @RequestMapping("toRoleGrantPage")
    public String toRoleGrantPage(Long roleId, Model model){
        model.addAttribute("roleId",roleId);
        return  "role/grant";
    }

    @RequestMapping("toAddOrUpdate")
    public String addOrUpdate(Long id, Model model) {
        if (id != null) {
            SysRole role = sysRoleService.selectByPrimaryKey(id);
            model.addAttribute("role", role);
        }
        return "role/add_update";
    }

    @RequestMapping("save")
    @ResponseBody
    public ResultInfo save(SysRole sysRole){
        sysRoleService.addRole(sysRole);
        return success("角色添加成功");
    }

    @RequestMapping("update")
    @ResponseBody
    public ResultInfo update(SysRole sysRole){
        sysRoleService.changeRole(sysRole);
        return success("角色添加成功");
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo delete(SysRole sysRole){
        sysRoleService.removeRoleById(sysRole);
        return success("角色添加成功");
    }













}
