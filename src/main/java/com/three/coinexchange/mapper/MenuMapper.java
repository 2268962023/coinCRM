package com.three.coinexchange.mapper;

import com.three.coinexchange.base.BaseMapper;
import com.three.coinexchange.bean.Menu;
import com.three.coinexchange.dto.TreeDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu,Long> {


    List<Menu> QueryAllMenu(@Param("userId") Long userId, @Param("status") String status);

    List<TreeDto> selectMenus();

    List<Integer> selectModelByRoleId(Long roleId);

    List<Integer> queryUserHasRolesHasPermissions(Long userId);
}