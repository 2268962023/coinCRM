package com.three.coinexchange.controller;

import com.three.coinexchange.base.BaseController;
import com.three.coinexchange.bean.Menu;
import com.three.coinexchange.common.SysMenu;
import com.three.coinexchange.dto.TreeDto;
import com.three.coinexchange.service.SysMenuService;
import com.three.coinexchange.utils.LoginUserUtil;
import com.three.coinexchange.utils.UserIDBase64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("menu")
public class SysMenuController extends BaseController {
    @Resource
    private SysMenuService sysMenuService;

    @RequestMapping("/menu")
    @ResponseBody
    public List<SysMenu> menus(HttpServletRequest req){
        Long userId = LoginUserUtil.releaseUserIdFromCookie(req);
        System.out.println(userId);
        Menu menu = new Menu();
        menu.setStatus("1");
        List<SysMenu> menuss = sysMenuService.menus(menu, userId);
        return menuss;
    }

    @RequestMapping("index")
    public String index() {
        return "menu/menu";
    }

    @RequestMapping("findMenus")
    @ResponseBody
    public List<TreeDto> findMenus(String roleId){
        System.out.println(roleId);
        List<TreeDto> list = sysMenuService.findMenusByRoleId(Long.valueOf(roleId));
        list.forEach(System.out::println);
        return list;
    }


}
