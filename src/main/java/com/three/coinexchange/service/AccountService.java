package com.three.coinexchange.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.three.coinexchange.base.BaseService;
import com.three.coinexchange.bean.Account;
import com.three.coinexchange.mapper.AccountMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountService extends BaseService<Account,Integer> {

    @Resource
    private AccountMapper accountMapper;

    public Map<String, Object> findAll(Integer page, Integer limit) {

        Map<String,Object> map = new HashMap<String, Object>();

        PageHelper.startPage(page,limit);
        PageInfo<Account> pageInfo = new PageInfo<>(accountMapper.selectAll());

        map.put("code",0);
        map.put("msg","success");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());

        return map;
    }

}
