package com.three.coinexchange.mapper;

import com.three.coinexchange.base.BaseMapper;
import com.three.coinexchange.bean.Notice;
import com.three.coinexchange.query.NoticeQuery;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface NoticeMapper  extends BaseMapper<Notice,Long> {

    @Select("select * from notice")
    List<Notice> selectNotice();

    @MapKey("")
    List<Map<String,Object>> queryAllNotice(NoticeQuery noticeQuery);

}