package com.three.coinexchange.mapper;

import com.three.coinexchange.base.BaseMapper;
import com.three.coinexchange.bean.SysPrivilege;
import com.three.coinexchange.bean.SysRolePrivilege;

public interface SysPrivilegeMapper extends BaseMapper<SysPrivilege,Long> {


    int insert(SysPrivilege record);


    SysPrivilege selectByPrimaryKey(Long id);

;

    int updateByPrimaryKey(SysPrivilege record);
}