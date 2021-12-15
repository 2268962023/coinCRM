package com.three.coinexchange.mapper;

import com.three.coinexchange.base.BaseMapper;
import com.three.coinexchange.bean.SysUser;

public interface SysUserMapper extends BaseMapper<SysUser,Long> {

    /**
     * 根据用户名和用户密码查询用户
     * @param sysUser
     * @return
     */
    SysUser QueryUserNameAndPwd(SysUser sysUser);

    /**
     * 根据用户名查询用户信息
     */
    SysUser QueryUserName(String username);

    SysUser selectSysUserByName(String userName);

    SysUser queryUserByUserName(String username);
}