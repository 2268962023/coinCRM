package com.three.coinexchange.service;

import com.three.coinexchange.base.BaseService;


import com.three.coinexchange.bean.UserAuthInfo;
import com.three.coinexchange.mapper.UserAuthInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserAuthInfoService extends BaseService<UserAuthInfo,Integer> {

    @Resource
    private UserAuthInfoMapper mapper;


}
