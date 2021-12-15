package com.three.coinexchange.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.three.coinexchange.base.BaseService;
import com.three.coinexchange.bean.SysUser;
import com.three.coinexchange.bean.UserModel;
import com.three.coinexchange.mapper.SysUserMapper;
import com.three.coinexchange.query.SysUserQuery;
import com.three.coinexchange.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SysUserService extends BaseService<SysUser,Long> {

    @Resource
    private SysUserMapper sysUserMapper;


    public SysUser QueryUserNameAndPwd(String username,String password){
        AssertUtil.isTrue(StringUtils.isBlank(username),"用户名不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(password),"密码不能为空");
        SysUser user = new SysUser();
        user.setUsername(username);
        user.setPassword(Md5Util.encode(password));
        SysUser sysUser = sysUserMapper.QueryUserNameAndPwd(user);
        AssertUtil.isTrue(!sysUser.getPassword().equals(Md5Util.encode(password)) && sysUser.getUsername().equals(username),"用户名或密码错误");
        return sysUser;
    }



    public UserModel userLogin(String userName,String passWord,HttpServletResponse response){
        checkLoginParams(userName, passWord);
        SysUser user = sysUserMapper.queryUserByUserName(userName);
        AssertUtil.isTrue(user==null,"用户不存在或者已注销");
        checkLoginPwd(passWord,user.getPassword());
        return buildUserInfo(user,response);
    }

    private UserModel buildUserInfo(SysUser user,HttpServletResponse response) {
        UserModel userModel = new UserModel();
        userModel.setUserId(UserIDBase64.encoderUserID(user.getId()));
        userModel.setUsername(user.getUsername());
        CookieUtil.setCookie("userId",UserIDBase64.encoderUserID(user.getId()),"",response);
        return userModel;

    }

    private void checkLoginPwd(String passWord, String password) {
        passWord = Md5Util.encode(passWord);
        AssertUtil.isTrue(!passWord.equals(password),"密码输入错误!");
    }

    private void checkLoginParams(String userName,String passWord) {
        AssertUtil.isTrue(StringUtils.isBlank(userName),"用户名不能为空");

        AssertUtil.isTrue(StringUtils.isBlank(passWord), "用户密码不能为空！");

    }




    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUserPassword(Long id, String oldPassWord, String newPassWord, String confirmPassWord) {
        // 通过userId获取用户对象
        SysUser user = sysUserMapper.selectByPrimaryKey(id);
        System.out.println(user);
        System.out.println(oldPassWord+","+newPassWord+","+confirmPassWord);
        // 1. 参数校验
        checkPasswordParams(user,oldPassWord,newPassWord,confirmPassWord);


        // 2. 设置用户新密码
        user.setPassword(Md5Util.encode(newPassWord));
        // 3. 执行更新操作
        AssertUtil.isTrue(sysUserMapper.updateByPrimaryKeySelective(user)<1,"用户密码更改失败");
    }

    private void checkPasswordParams(SysUser user, String oldPassWord, String newPassWord, String confirmPassWord) {

        // user对象 非空验证
        AssertUtil.isTrue(user==null,"用户未登录或已经存在");
        // 原始密码 非空验证
        AssertUtil.isTrue(StringUtils.isBlank(oldPassWord),"请输入原始密码");
        // 原始密码要与数据库中的密文密码保持一致

        AssertUtil.isTrue(!(user.getPassword().equals(Md5Util.encode(oldPassWord))),"原始密码不正确");
        // 新密码 非空校验
        AssertUtil.isTrue(newPassWord==null,"新密码不能为空");
        // 新密码与原始密码不能相同
        AssertUtil.isTrue(oldPassWord.equals(newPassWord),"新密码不能与原始密码相同！");
        // 确认密码 非空校验
        AssertUtil.isTrue(confirmPassWord==null,"确认密码不能为空");
        // 新密码要与确认密码保持一致
        AssertUtil.isTrue(!(newPassWord.equals(confirmPassWord)),"新密码与确认密码不一致");

    }
















    public Map<String, Object> querySysUserByParams(SysUserQuery sysUserQuery){
        HashMap<String, Object> map = new HashMap<>();
        //分页查询
        PageHelper.startPage(sysUserQuery.getPage(),sysUserQuery.getLimit());
        //开始分页
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUserMapper.selectByParams(sysUserQuery));
        //
        map.put("code", 0);
        map.put("msg", "success");
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        //
        return map;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(SysUser sysUser){
        //校验参数
        checkParams(sysUser.getUsername(),sysUser.getEmail(),sysUser.getMobile(),sysUser.getFullname());
        //设置默认参数
        sysUser.setStatus((byte) 1);
        sysUser.setCreated(new Date());
        sysUser.setLastUpdateTime(new Date());
        sysUser.setPassword(Md5Util.encode("123456"));
        //执行添加，判断结果
        AssertUtil.isTrue(sysUserMapper.insertSelective(sysUser)<1,"用户添加失败");
        //System.out.println(sysUser.getId()+">>"+sysUser.getRoleIds());
        //关联用户角色
        // relationUserRole(user.getId(),user.getRoleIds());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(SysUser sysUser){
        //在数据库中查询用户（通过id)是否存在
        SysUser temp = sysUserMapper.selectByPrimaryKey(Long.valueOf(sysUser.getId()));
        AssertUtil.isTrue(null == temp,"待更新记录不存在！！");
        //参数检验（用户名、邮箱、手机号）
        checkParams(sysUser.getUsername(),sysUser.getEmail(),sysUser.getMobile(),sysUser.getFullname());
        //设置默认值（更新时间）
        sysUser.setLastUpdateTime(new Date());
        //判断用户更新是否成功
        AssertUtil.isTrue(sysUserMapper.updateByPrimaryKeySelective(sysUser)<1,"用户更新失败！！");
        //
        //relationUserRole(sysUser.getId(),sysUser.getRoleIds());
    }

    private void checkParams(String username, String email, String mobile, String fullname) {
        //用户名不能为空
        AssertUtil.isTrue(StringUtils.isBlank(username),"账号不能为空！！！");
        //邮箱不能为空
        AssertUtil.isTrue(StringUtils.isBlank(email),"邮箱不能为空");
        //手机号不能为空
        AssertUtil.isTrue(StringUtils.isBlank(mobile),"手机号不能为空");
        //手机号格式不正确
        AssertUtil.isTrue(!PhoneUtil.isMobile(mobile),"手机号格式不正确");
        //姓名不能为空
        AssertUtil.isTrue(StringUtils.isBlank(fullname),"姓名不能为空");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUserById(Long[] ids){
        //判断是否选择待删除的用户记录
        AssertUtil.isTrue(null == ids || ids.length == 0,"请选择待删除的用记录！！");
        //判断要删除的用户记录是否成功
        assert ids != null;
        AssertUtil.isTrue(deleteBatch(ids) != ids.length,"用户记录删除失败！！");

    }




}
