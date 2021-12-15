package com.three.coinexchange.mapper;

import com.three.coinexchange.base.BaseMapper;
import com.three.coinexchange.bean.Cashwithdrawals;
import com.three.coinexchange.query.CashwithdrawalsQuery;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface CashwithdrawalsMapper extends BaseMapper<Cashwithdrawals,Long> {
   @MapKey("")
   List<Map<String,Object>> queryAllCashRecharge(CashwithdrawalsQuery cashwithdrawalsQuery);
}