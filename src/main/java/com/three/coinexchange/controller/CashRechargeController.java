package com.three.coinexchange.controller;

import cn.hutool.core.date.DateUtil;
import com.three.coinexchange.base.BaseController;
import com.three.coinexchange.query.CashRechargeQuery;
import com.three.coinexchange.service.CashRechargeService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("cash")
public class CashRechargeController extends BaseController {
    @Resource
    private CashRechargeService cashRechargeService;

    @RequestMapping("rechargeIndex")
    public String index(){
        return "cash/recharge/main";
    }

    @GetMapping("recharge")
    @ResponseBody
    public Map<String,Object> queryAllCashRecharge(CashRechargeQuery cashRechargeQuery){
        return cashRechargeService.queryAllCashRecharge(cashRechargeQuery);
    }
}
