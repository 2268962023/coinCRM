package com.three.coinexchange.controller;

import com.three.coinexchange.base.BaseController;

import com.three.coinexchange.service.UserAuthInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user_auth_info")
public class UserAuthInfoController extends BaseController {

    @Autowired
    private UserAuthInfoService userAuthInfoService;


}
