package com.three.coinexchange.controller;


import com.three.coinexchange.base.BaseController;
import com.three.coinexchange.base.ResultInfo;
import com.three.coinexchange.query.NoticeQuery;
import com.three.coinexchange.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("notice")
public class NoticeController extends BaseController {

    @Resource
    private NoticeService noticeService;

    @RequestMapping("index")
    public String index(){
      return "notice/main";
    }

    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> queryAllNotice(NoticeQuery noticeQuery){
      return noticeService.queryAllNotice(noticeQuery);
    }


}
