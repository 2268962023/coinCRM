package com.three.coinexchange.mapper;

import com.three.coinexchange.base.BaseMapper;
import com.three.coinexchange.bean.TurnoverOrder;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TurnoverOrderMapper extends BaseMapper<TurnoverOrder,Long> {


    Long selectCountTurnoverOrder();
}