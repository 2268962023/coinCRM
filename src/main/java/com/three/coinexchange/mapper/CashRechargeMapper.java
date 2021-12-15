package com.three.coinexchange.mapper;

import com.three.coinexchange.base.BaseMapper;
import com.three.coinexchange.bean.CashRecharge;
import com.three.coinexchange.query.CashRechargeQuery;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface CashRechargeMapper extends BaseMapper<CashRecharge,Long> {
    @MapKey("")
    List<Map<String,Object>> queryAllCashRecharge(CashRechargeQuery cashRechargeQuery);
}