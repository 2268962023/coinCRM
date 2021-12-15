package com.three.coinexchange.controller;


import com.three.coinexchange.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController extends BaseController {

    @RequestMapping("console")
    public String console(){
        return "console/console";
    }
}
