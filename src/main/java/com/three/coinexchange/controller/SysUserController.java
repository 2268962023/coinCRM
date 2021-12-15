package com.three.coinexchange.controller;

import com.three.coinexchange.base.BaseController;
import com.three.coinexchange.base.ResultInfo;
import com.three.coinexchange.bean.SysUser;
import com.three.coinexchange.bean.UserModel;
import com.three.coinexchange.exceptions.ParamsException;
import com.three.coinexchange.query.SysUserQuery;
import com.three.coinexchange.service.SysMenuService;
import com.three.coinexchange.service.SysUserService;
import com.three.coinexchange.utils.CookieUtil;
import com.three.coinexchange.utils.LoginUserUtil;
import com.three.coinexchange.utils.UserIDBase64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class SysUserController extends BaseController {

    @Resource
    private SysUserService sysUserService;

    @Resource
    private SysMenuService sysMenuService;


    @RequestMapping("login")
    public String login(){
        return "login";
    }
    /**
     * 主页面
     */
    @RequestMapping("index")
    public String main(HttpServletRequest request){
        Long userId = LoginUserUtil.releaseUserIdFromCookie(request);
        // 调用对应Service层的方法，通过userId主键查询用户对象
        SysUser user = sysUserService.selectByPrimaryKey(userId);
        // 将用户对象设置到request作用域中
        request.setAttribute("user", user);
        List<Integer> permissions = sysMenuService.queryUserHasRolesHasPermissions(userId);
        request.getSession().setAttribute("permissions",permissions);
        return "index";
    }


    /**
     * 退出
     * @return
     */

    @RequestMapping("logout")
    @ResponseBody
    public ResultInfo logout(HttpServletRequest req,HttpServletResponse resp){
         CookieUtil.deleteCookie("userId",req,resp);
         return success();
    }




    @RequestMapping("toLogin")
    @ResponseBody
    public ResultInfo userLogin(String username,String password,HttpServletResponse response){

        ResultInfo resultInfo = new ResultInfo();
        try {

            UserModel userModel = sysUserService.userLogin(username, password,response);
            resultInfo.setCode(200);
            resultInfo.setMsg("登录成功");
            resultInfo.setResult(userModel);
        } catch (ParamsException e) {
            e.printStackTrace();

            resultInfo.setCode(e.getCode());
            resultInfo.setMsg(e.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo.setCode(500);
            resultInfo.setMsg("操作失败！");
        }

        return resultInfo;
    }

    @RequestMapping("updatePwd")
    @ResponseBody
    public ResultInfo updateUserPassword (String oldPassword,String newPassword, String confirmPassword,HttpServletRequest request) {
            ResultInfo resultInfo = new ResultInfo();
            Long userId = LoginUserUtil.releaseUserIdFromCookie(request);
            sysUserService.updateUserPassword(userId,oldPassword, newPassword,confirmPassword);
            return resultInfo;
    }

    @RequestMapping("editPassword")
    public String toPasswordPage(){
        return "system/user/password";
    }






    /**
     * 进入用户信息页面
     */
    @RequestMapping("center")
    public String userInfo(HttpServletRequest request, Model model){
        Long id = LoginUserUtil.releaseUserIdFromCookie(request);
        SysUser sysUser = sysUserService.selectByPrimaryKey(id);
        if (sysUser!=null){
            model.addAttribute("sys_user",sysUser);
        }
        return "/system/user/center";
    }


    @RequestMapping("user")
    public String index() {
        return "user/users";
    }

    /**
     * 分页查询
     * @param sysUserQuery
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> querySysUserByParams(SysUserQuery sysUserQuery) {
        return sysUserService.querySysUserByParams(sysUserQuery);
    }

    @RequestMapping("addOrUpdateUserPage")
    public String addOrUpdateUserPage(Long id, Model model){
        if (id != null){
            System.out.println(id);
            model.addAttribute("sysUser",sysUserService.selectByPrimaryKey(id));
        }
        return "user/add_update";
    }

    @RequestMapping("save")
    @ResponseBody
    public ResultInfo saveUser(HttpServletRequest request, SysUser sysUser){
        sysUserService.saveUser(sysUser);
        return success("账户添加成功！！");
    }

    @RequestMapping("update")
    @ResponseBody
    public ResultInfo updateUser(SysUser sysUser){
        sysUserService.updateUser(sysUser);
        return success("账户更新成功！！");
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResultInfo deleteUser(Long[] ids){
        sysUserService.deleteUserById(ids);
        return success("用户删除成功！！");
    }



}
