package com.three.coinexchange.controller;

import com.three.coinexchange.base.BaseController;
import com.three.coinexchange.bean.Notice;
import com.three.coinexchange.common.Echarts;
import com.three.coinexchange.mapper.TurnoverOrderMapper;
import com.three.coinexchange.service.NoticeService;
import com.three.coinexchange.service.TurnoverOrderService;
import com.three.coinexchange.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("echarts")
public class EchartsController extends BaseController {

    @Resource
    private UserService userService;

    @Resource
    private TurnoverOrderService turnoverOrderService;

    @Resource
    private NoticeService noticeService;

    @RequestMapping("authStatus")
    public List<Echarts> authStatus(){
        return userService.AuthStatus();
    }

    @RequestMapping("countTurnoverOrder")
    public Long selectCountTurnoverOrder(){
        return turnoverOrderService.selectCountTurnoverOrder();
    }

    @RequestMapping("selectNotice")
    public List<Notice> selectNotice(){
        return noticeService.selectNotice();
    }
}
