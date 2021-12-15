package com.three.coinexchange.controller;

import com.three.coinexchange.base.BaseController;
import com.three.coinexchange.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("account")
public class AccountController extends BaseController {

    @Resource
    private AccountService accountService;

    @RequestMapping("index")
    public String index() {
        return "account/account";
    }

    @RequestMapping("find")
    @ResponseBody
    public Map<String,Object> findAll(Integer page,Integer limit) {
        return accountService.findAll(page,limit);
    }

}
