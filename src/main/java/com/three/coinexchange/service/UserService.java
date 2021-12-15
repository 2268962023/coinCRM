package com.three.coinexchange.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.three.coinexchange.base.BaseService;
import com.three.coinexchange.bean.User;
import com.three.coinexchange.bean.UserModel;
import com.three.coinexchange.common.Echarts;
import com.three.coinexchange.mapper.UserMapper;
import com.three.coinexchange.query.UserQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService extends BaseService<User,Long> {

    @Resource
    private UserMapper userMapper;

    public List<Echarts> AuthStatus(){

        int count = userMapper.authStatus();
        int count1 = userMapper.authStatus1();
        int count2 = userMapper.authStatus2();

        //存储不同认证的数据
        List<Echarts> echarts=new ArrayList<>();
        echarts.add(new Echarts(count,"未认证"));
        echarts.add(new Echarts(count1,"初级实名认证"));
        echarts.add(new Echarts(count2,"高级实名认证"));

        return echarts;
    }

    public Map<String,Object> list(UserQuery query){
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(query.getPage(),query.getLimit());
        PageInfo<User> plist = new PageInfo<User>(userMapper.selectByParams(query));

        map.put("code", 0);
        map.put("msg", "success");
        map.put("count", plist.getTotal());
        map.put("data", plist.getList());
        //返回目标map
        return map;
    }

}
