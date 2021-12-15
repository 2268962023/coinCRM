package com.three.coinexchange.service;


import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.three.coinexchange.base.BaseService;
import com.three.coinexchange.bean.CashRecharge;

import com.three.coinexchange.mapper.CashRechargeMapper;

import com.three.coinexchange.query.CashRechargeQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class CashRechargeService extends BaseService<CashRecharge,Long> {

    @Resource
    private CashRechargeMapper cashRechargeMapper;


    public Map<String,Object> queryAllCashRecharge(CashRechargeQuery cashRechargeQuery){
        if (cashRechargeQuery.getStartTimes()!=null  && cashRechargeQuery.getStartTimes()!=""){
            cashRechargeQuery.setStartTime(DateUtil.parse(cashRechargeQuery.getStartTimes(),"yyyy-MM-dd HH:mm:ss"));
        }
        if (cashRechargeQuery.getEndTimes()!=null  && cashRechargeQuery.getEndTimes()!=""){
            cashRechargeQuery.setEndTime(DateUtil.parse(cashRechargeQuery.getEndTimes(),"yyyy-MM-dd HH:mm:ss"));
        }

        //存储数据
        Map<String,Object> map=new HashMap<>();
        PageHelper.startPage(cashRechargeQuery.getPage(),cashRechargeQuery.getLimit());

        PageInfo<Map<String,Object>> pageInfo=new PageInfo<>(cashRechargeMapper.queryAllCashRecharge(cashRechargeQuery));
        map.put("code",0);
        map.put("msg", "success");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }
}
