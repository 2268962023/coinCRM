package com.three.coinexchange.mapper;

import com.three.coinexchange.base.BaseMapper;
import com.three.coinexchange.bean.Coin;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CoinMapper extends BaseMapper<Coin,Long> {

    @Select("select id,name from coin")
    List<Coin> queryCoinNameAndCoinId();

    Coin selectByName(String name);
}