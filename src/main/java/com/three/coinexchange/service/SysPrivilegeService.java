package com.three.coinexchange.service;

import com.three.coinexchange.base.BaseService;
import com.three.coinexchange.bean.SysPrivilege;
import com.three.coinexchange.mapper.SysPrivilegeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysPrivilegeService extends BaseService<SysPrivilege,Long> {

    @Resource
    private SysPrivilegeMapper sysPrivilegeMapper;


}
