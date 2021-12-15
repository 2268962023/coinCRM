package com.three.coinexchange.service;

import com.three.coinexchange.base.BaseService;
import com.three.coinexchange.bean.Menu;
import com.three.coinexchange.common.SysMenu;
import com.three.coinexchange.dto.TreeDto;
import com.three.coinexchange.mapper.MenuMapper;
import com.three.coinexchange.utils.LoginUserUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysMenuService extends BaseService<Menu,Long> {

    @Resource
    private MenuMapper menuMapper;

    public List<SysMenu> menus(Menu menu, Long userId){
        //存储菜单信息
        List<SysMenu> menuList=new ArrayList<>();
        System.out.println("--------------");
        List<Menu> menus = menuMapper.QueryAllMenu(userId, menu.getStatus());
        for (Menu m:menus) {
            menuList.add(new SysMenu(m.getId(),m.getParentId(),m.getName(),"---",m.getType(),"_iframe",m.getTargetUrl()));
        }

        List<SysMenu> builder = builder(menuList,0l);
        return  builder;
    }

    public  List<SysMenu> builder(List<SysMenu> sysMenuList,Long pid){
          List<SysMenu> sysMenus=new ArrayList<>();
          //循环遍历
        for (SysMenu sysMenu:sysMenuList) {
              if (sysMenu.getParentId()==pid){
                  sysMenus.add(new SysMenu(sysMenu.getId(),sysMenu.getTitle(),sysMenu.getIcon(),sysMenu.getType(), sysMenu.getHref(),sysMenu.getChildren()));
              }
            //遍历每个主菜单下的子菜单
            for (SysMenu sysMenu1:sysMenuList) {
                if (sysMenu1.getParentId()==sysMenu.getId()){
                    sysMenu.getChildren().add(new SysMenu(sysMenu1.getId(), sysMenu1.getTitle(),sysMenu1.getIcon(),sysMenu1.getType(),sysMenu1.getOpenType(),sysMenu1.getHref()));
                }
            }
        }
        System.out.println(sysMenus);
        return sysMenus;

    }


    public List<Integer> queryUserHasRolesHasPermissions(Long userId){
        return menuMapper.queryUserHasRolesHasPermissions(userId);
    }



    public List<TreeDto> findMenusByRoleId(Long roleId){
        //获取所有资源信息
        List<TreeDto> tlist = menuMapper.selectMenus();
        //获取当前角色的拥有的资源信息
        List<Integer> roleHasMenus=menuMapper.selectModelByRoleId(roleId);
        roleHasMenus.forEach(System.out::println);
        //遍历
        for (TreeDto treeDto: tlist) {
            /*若当前角色的资源信息（roleHasModules）包含在（TreeDto）中，就选中前面的勾选框*/
            if(roleHasMenus.contains(treeDto.getId())){
                treeDto.setChecked(true);
            }
        }
        //判断比对，checked=true;
        return tlist;
    }


}
