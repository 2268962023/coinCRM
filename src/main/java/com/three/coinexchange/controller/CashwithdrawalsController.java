package com.three.coinexchange.controller;

import com.three.coinexchange.base.BaseController;
import com.three.coinexchange.query.CashRechargeQuery;
import com.three.coinexchange.query.CashwithdrawalsQuery;
import com.three.coinexchange.service.CashRechargeService;
import com.three.coinexchange.service.CashwithdrawalsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("withdrawals")
public class CashwithdrawalsController extends BaseController {
    @Resource
    private CashwithdrawalsService cashwithdrawalsService;

    @RequestMapping("index")
    public String index(){
        return "cash/withdrawals/main";
    }

    @GetMapping("withdrawals")
    @ResponseBody
    public Map<String,Object> queryAllCashRecharge(CashwithdrawalsQuery cashwithdrawalsQuery){
        return cashwithdrawalsService.queryAllCashRecharge(cashwithdrawalsQuery);
    }
}
