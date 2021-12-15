package com.three.coinexchange.mapper;

import com.three.coinexchange.base.BaseMapper;
import com.three.coinexchange.bean.Account;

import java.util.List;

public interface AccountMapper extends BaseMapper<Account,Integer> {
    int deleteByPrimaryKey(Long id);

    int insert(Account record);

    Integer insertSelective(Account record);

    Account selectByPrimaryKey(Long id);

    Integer updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    List<Account> selectAll();

}