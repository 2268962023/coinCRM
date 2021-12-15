package com.three.coinexchange.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.three.coinexchange.base.BaseService;
import com.three.coinexchange.bean.CoinType;
import com.three.coinexchange.mapper.CoinTypeMapper;
import com.three.coinexchange.query.CoinTypeQuery;
import com.three.coinexchange.utils.AssertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class CoinTypeService extends BaseService<CoinType,Long> {

    @Resource
    private CoinTypeMapper coinTypeMapper;

    public Map<String,Object> findAll(CoinTypeQuery coinTypeQuery) {

        Map<String,Object> map = new HashMap<String, Object>();

        PageHelper.startPage(coinTypeQuery.getPage(),coinTypeQuery.getLimit());
        PageInfo<CoinType> pageInfo = new PageInfo<>(coinTypeMapper.selectByParams(coinTypeQuery));

        map.put("code",0);
        map.put("msg","success");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());

        return map;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addCoinType(CoinType coinType) {
        AssertUtil.isTrue(StringUtils.isBlank(coinType.getCode()), "货币代码不能为空");

        CoinType temp = coinTypeMapper.selectByCode(coinType.getCode());

        AssertUtil.isTrue(temp != null,"该类型货币已经存在");

        coinType.setStatus((byte) 1);
        coinType.setCreated(new Date());
        coinType.setLastUpdateTime(new Date());

        AssertUtil.isTrue(insertHasKey(coinType) < 1, "添加失败了");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void removeCoinTypeIds(Long[] ids) {

        AssertUtil.isTrue(ids==null || ids.length==0,"请选择要删除的数据");
        AssertUtil.isTrue(deleteBatch(ids)==0,"请选择要删除的数据");
    }

    public void changeCoinType(CoinType coinType) {

        CoinType temp = coinTypeMapper.selectByPrimaryKey(coinType.getId());
        AssertUtil.isTrue(temp==null,"待更新数据不存在");

        if (StringUtils.isBlank(coinType.getDescription()) && StringUtils.isBlank(coinType.getCode())) {
            coinType.setStatus((byte)1);
            coinType.setLastUpdateTime(new Date());
            coinType.setCreated(temp.getCreated());
            coinType.setCode(coinType.getCode());
        }

        AssertUtil.isTrue(updateByPrimaryKeySelective(coinType)<1,"修改失败了");

    }

}
