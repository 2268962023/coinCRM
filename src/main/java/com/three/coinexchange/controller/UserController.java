package com.three.coinexchange.controller;

import com.three.coinexchange.base.BaseController;
import com.three.coinexchange.base.ResultInfo;
import com.three.coinexchange.bean.User;
import com.three.coinexchange.query.UserQuery;
import com.three.coinexchange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("users")
public class UserController extends BaseController {


    @Resource
    private UserService userService;

    @RequestMapping("index")
    public String index() {
        return "user/user";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> list(UserQuery userQuery) {
        return userService.list(userQuery);
    }

    @RequestMapping("toUserDataPage/{id}")
    public String toCusDevPlanDataPage (@PathVariable("id") Long id, Model model) {
        // 通过id查询营销机会数据
        User user = userService.selectByPrimaryKey(id);
        // 将数据存到作用域中
        model.addAttribute("user", user);
        return "user/user_data";
    }

//    @RequestMapping("login")
//    @ResponseBody
//    public ResultInfo userLogin(String userName, String passWord){
//
//        ResultInfo resultInfo = new ResultInfo();
//        try {
//
//            UserModel userModel = userService.userLogin(userName, passWord);
//            resultInfo.setResult(userModel);
//        } catch (ParamsException e) {
//            e.printStackTrace();
//
//            resultInfo.setCode(e.getCode());
//            resultInfo.setMsg(e.getMsg());
//        } catch (Exception e) {
//            e.printStackTrace();
//            resultInfo.setCode(500);
//            resultInfo.setMsg("操作失败！");
//        }
//
//        return resultInfo;
//    }
//
//    @PostMapping("updatePwd")
//    @ResponseBody
//    public ResultInfo updateUserPassword (HttpServletRequest request,
//                                          String oldPassword, String newPassword,
//                                          String confirmPassword) {
//
//        ResultInfo resultInfo = new ResultInfo();
//
//        try {
//            Long userId = LoginUserUtil.releaseUserIdFromCookie(request);
//            userService.updateUserPassword(userId,oldPassword, newPassword,confirmPassword);
//        } catch (ParamsException e) {
//            e.printStackTrace();
//
//            resultInfo.setCode(e.getCode());
//            resultInfo.setMsg(e.getMsg());
//        } catch (Exception e) {
//            e.printStackTrace();
//            resultInfo.setCode(500);
//            resultInfo.setMsg("操作失败！");
//        }
//        return resultInfo;
//    }
//
//    @RequestMapping("toPasswordPage")
//    public String toPasswordPage(){
//        return "user/password";
//    }

}
