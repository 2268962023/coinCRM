package com.three.coinexchange.mapper;

import com.three.coinexchange.base.BaseMapper;
import com.three.coinexchange.bean.UserAuthAuditRecord;

public interface UserAuthAuditRecordMapper extends BaseMapper<UserAuthAuditRecord,Integer> {
    int deleteByPrimaryKey(Long id);

    int insert(UserAuthAuditRecord record);

    Integer insertSelective(UserAuthAuditRecord record);

    UserAuthAuditRecord selectByPrimaryKey(Long id);

    Integer updateByPrimaryKeySelective(UserAuthAuditRecord record);

    int updateByPrimaryKey(UserAuthAuditRecord record);
}