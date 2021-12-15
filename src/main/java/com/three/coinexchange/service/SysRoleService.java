package com.three.coinexchange.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.three.coinexchange.base.BaseService;
import com.three.coinexchange.bean.SysRole;
import com.three.coinexchange.mapper.SysRoleMapper;
import com.three.coinexchange.query.SysRoleQuery;
import com.three.coinexchange.utils.AssertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysRoleService extends BaseService<SysRole,Long> {

    @Resource
    private SysRoleMapper sysRoleMapper;

    public Map<String, Object> querySysRoleByParams(SysRoleQuery sysRoleQuery) {
        //实例化Map
        Map<String, Object> map = new HashMap<String, Object>();
        //开启分页单位
        PageHelper.startPage(sysRoleQuery.getPage(), sysRoleQuery.getLimit());
        PageInfo<SysRole> pageInfo = new PageInfo<>(sysRoleMapper.selectByParams(sysRoleQuery));
        //准备数据
        map.put("code", 0);
        map.put("msg", "success");
        map.put("count", pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        //返回目标map
        return map;
    }

    public List<Map<String,Object>> findRoles(Integer userId){
        return sysRoleMapper.selectRoles(userId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addRole(SysRole sysRole) {
        //1.角色名非空
        System.out.println(sysRole.getName());
        AssertUtil.isTrue(StringUtils.isBlank(sysRole.getName()), "请输入角色名称");
        //2.角色名唯一
        SysRole temp = sysRoleMapper.selectRoleByName(sysRole.getName());
        AssertUtil.isTrue(null != temp, "角色已经存在");
        //3.设定默认值
        sysRole.setCode("123");
        sysRole.setStatus((byte) 1);
        sysRole.setCreated(new Date());
        sysRole.setLastUpdateTime(new Date());
        System.out.println(sysRole);
        sysRoleMapper.insertSelective(sysRole);
    }

    public void changeRole(SysRole sysRole) {
        //验证当前对象是否存在
        SysRole temp = sysRoleMapper.selectByPrimaryKey(Long.valueOf(sysRole.getId()));
        AssertUtil.isTrue(temp == null || sysRole.getId()==null, "待修改记录不存在");
        //1.角色名非空
        AssertUtil.isTrue(StringUtils.isBlank(sysRole.getName()), "角色名称不能为空");
        //2.角色名唯一
        SysRole temp2 = sysRoleMapper.selectRoleByName(sysRole.getName());
        AssertUtil.isTrue(temp2 != null && !(temp2.getId().equals(sysRole.getId())), "角色已经存在");
        //3.设定默认值
        sysRole.setLastUpdateTime(new Date());
        //4.修改是否成功
        AssertUtil.isTrue(updateByPrimaryKeySelective(sysRole) < 1, "修改失败了");
    }

    public void removeRoleById(SysRole sysRole) {
        //验证
        AssertUtil.isTrue(sysRole.getId()==null || selectByPrimaryKey(Long.valueOf(sysRole.getId()))==null,"请选择数据");
        //设定默认值
        sysRole.setStatus((byte) 0);
        sysRole.setLastUpdateTime(new Date());
        //判断是否成功
        AssertUtil.isTrue(sysRoleMapper.updateByPrimaryKeySelective(sysRole)<1,"删除失败了");
    }






}



