package com.three.coinexchange.mapper;

import com.three.coinexchange.base.BaseMapper;
import com.three.coinexchange.bean.SysRole;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface SysRoleMapper extends BaseMapper<SysRole,Long> {

    @MapKey("")
    public List<Map<String,Object>> selectRoles(Integer userId);

    SysRole selectRoleByName(String name);
    List<String> queryUserHasRolesHasPermissions(Long userId);



}