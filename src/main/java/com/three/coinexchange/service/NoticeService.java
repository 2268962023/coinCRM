package com.three.coinexchange.service;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.three.coinexchange.base.BaseService;
import com.three.coinexchange.bean.Notice;
import com.three.coinexchange.mapper.NoticeMapper;
import com.three.coinexchange.query.NoticeQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeService extends BaseService<Notice,Long> {

    @Resource
    private NoticeMapper noticeMapper;

    public List<Notice> selectNotice(){
        return noticeMapper.selectNotice();
    }


    public Map<String,Object> queryAllNotice(NoticeQuery noticeQuery){
        if (noticeQuery.getStartTimes()!=null  && noticeQuery.getStartTimes()!=""){
            noticeQuery.setStartTime(DateUtil.parse(noticeQuery.getStartTimes(),"yyyy-MM-dd HH:mm:ss"));
        }
        if (noticeQuery.getEndTimes()!=null  && noticeQuery.getEndTimes()!=""){
            noticeQuery.setEndTime(DateUtil.parse(noticeQuery.getEndTimes(),"yyyy-MM-dd HH:mm:ss"));
        }

        //存储数据
        Map<String,Object> map=new HashMap<>();
        PageHelper.startPage(noticeQuery.getPage(),noticeQuery.getLimit());

        PageInfo<Map<String,Object>> pageInfo=new PageInfo<>(noticeMapper.queryAllNotice(noticeQuery));
        map.put("code",0);
        map.put("msg", "success");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }
}
