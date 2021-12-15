package com.three.coinexchange.mapper;

import com.three.coinexchange.base.BaseMapper;
import com.three.coinexchange.bean.CoinType;

public interface CoinTypeMapper extends BaseMapper<CoinType,Long> {
    Integer deleteByPrimaryKey(Long id);

    int insert(CoinType record);

    Integer insertSelective(CoinType record);

    CoinType selectByPrimaryKey(Long id);

    Integer updateByPrimaryKeySelective(CoinType record);

    int updateByPrimaryKey(CoinType record);

    CoinType selectByCode(String code);
}