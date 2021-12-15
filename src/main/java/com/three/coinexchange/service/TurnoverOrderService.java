package com.three.coinexchange.service;

import com.three.coinexchange.base.BaseService;
import com.three.coinexchange.bean.TurnoverOrder;
import com.three.coinexchange.mapper.TurnoverOrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TurnoverOrderService extends BaseService<TurnoverOrder,Long> {

    @Resource
    private TurnoverOrderMapper turnoverOrderMapper;

    public Long selectCountTurnoverOrder(){
        return turnoverOrderMapper.selectCountTurnoverOrder();
    }
}
