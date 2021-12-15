package com.three.coinexchange.controller;

import com.three.coinexchange.base.BaseController;
import com.three.coinexchange.query.UserAuthAuditRecordQuery;
import com.three.coinexchange.service.UserAuthAuditRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("user_auth_audit_record")
public class UserAuthAuditRecordController extends BaseController {

    @Autowired
    private UserAuthAuditRecordService userAuthAuditRecordService;

    @RequestMapping("index")
    private String index(){
        return "userAuthAuditRecord/user_auth_audit_record";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> list(UserAuthAuditRecordQuery query) {
        return userAuthAuditRecordService.list(query);
    }



}
