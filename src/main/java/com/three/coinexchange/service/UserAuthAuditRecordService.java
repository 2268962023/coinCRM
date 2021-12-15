package com.three.coinexchange.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.three.coinexchange.base.BaseService;
;
import com.three.coinexchange.bean.UserAuthAuditRecord;
import com.three.coinexchange.mapper.UserAuthAuditRecordMapper;

import com.three.coinexchange.query.UserAuthAuditRecordQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserAuthAuditRecordService extends BaseService<UserAuthAuditRecord,Integer> {

    @Resource
    private UserAuthAuditRecordMapper userAuthAuditRecordMapper;

    public Map<String,Object> list(UserAuthAuditRecordQuery query){
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(query.getPage(),query.getLimit());
        PageInfo<UserAuthAuditRecord> plist = new PageInfo<UserAuthAuditRecord>(userAuthAuditRecordMapper.selectByParams(query));

        map.put("code", 0);
        map.put("msg", "success");
        map.put("count", plist.getTotal());
        map.put("data", plist.getList());
        //返回目标map
        return map;
    }

}
