package com.three.coinexchange.mapper;

import com.three.coinexchange.base.BaseController;
import com.three.coinexchange.base.BaseMapper;
import com.three.coinexchange.bean.User;
import com.three.coinexchange.bean.UserWithBLOBs;
import com.three.coinexchange.query.UserQuery;

import java.util.List;

public interface UserMapper extends BaseMapper<UserMapper,Long> {

    int authStatus();
    int authStatus1();
    int authStatus2();
    List<User>selectByParams(UserQuery userQuery);
}