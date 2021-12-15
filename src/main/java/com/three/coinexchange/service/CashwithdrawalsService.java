package com.three.coinexchange.service;


import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.three.coinexchange.base.BaseService;
import com.three.coinexchange.bean.CashRecharge;
import com.three.coinexchange.bean.Cashwithdrawals;
import com.three.coinexchange.mapper.CashwithdrawalsMapper;
import com.three.coinexchange.query.CashwithdrawalsQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class CashwithdrawalsService extends BaseService<Cashwithdrawals,Long> {

    @Resource
    private CashwithdrawalsMapper cashwithdrawalsMapper;


    public Map<String,Object> queryAllCashRecharge(CashwithdrawalsQuery cashwithdrawalsQuery){
        if (cashwithdrawalsQuery.getStartTimes()!=null  && cashwithdrawalsQuery.getStartTimes()!=""){
            cashwithdrawalsQuery.setStartTime(DateUtil.parse(cashwithdrawalsQuery.getStartTimes(),"yyyy-MM-dd HH:mm:ss"));
        }
        if (cashwithdrawalsQuery.getEndTimes()!=null  && cashwithdrawalsQuery.getEndTimes()!=""){
            cashwithdrawalsQuery.setEndTime(DateUtil.parse(cashwithdrawalsQuery.getEndTimes(),"yyyy-MM-dd HH:mm:ss"));
        }

        //存储数据
        Map<String,Object> map=new HashMap<>();
        PageHelper.startPage(cashwithdrawalsQuery.getPage(),cashwithdrawalsQuery.getLimit());
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(cashwithdrawalsMapper.queryAllCashRecharge(cashwithdrawalsQuery));
        map.put("code",0);
        map.put("msg", "success");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }
}
