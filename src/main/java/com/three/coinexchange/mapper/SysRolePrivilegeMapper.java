package com.three.coinexchange.mapper;

import com.three.coinexchange.base.BaseMapper;
import com.three.coinexchange.bean.SysRolePrivilege;

public interface SysRolePrivilegeMapper extends BaseMapper<SysRolePrivilege,Long> {


    int insert(SysRolePrivilege record);

;

    SysRolePrivilege selectByPrimaryKey(Long id);


    int updateByPrimaryKey(SysRolePrivilege record);
}