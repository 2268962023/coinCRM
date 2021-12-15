package com.three.coinexchange.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.three.coinexchange.base.BaseService;
import com.three.coinexchange.bean.Coin;
import com.three.coinexchange.mapper.CoinMapper;
import com.three.coinexchange.query.CoinQuery;
import com.three.coinexchange.utils.AssertUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class CoinService extends BaseService<Coin,Long> {

    @Resource
    private CoinMapper coinMapper;

    public Map<String,Object> findAll(CoinQuery coinQuery) {

        Map<String,Object> map = new HashMap<String, Object>();

        PageHelper.startPage(coinQuery.getPage(),coinQuery.getLimit());
        PageInfo<Coin> pageInfo = new PageInfo<>(coinMapper.selectByParams(coinQuery));

        map.put("code",0);
        map.put("msg","success");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());

        return map;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void addCoinType(Coin coin) {

        AssertUtil.isTrue(StringUtils.isBlank(coin.getName()), "货币代码不能为空");

        Coin temp = coinMapper.selectByName(coin.getName());

        AssertUtil.isTrue(temp != null,"该货币已经存在");

        coin.setTitle(coin.getName());
        coin.setId((long)(UUID.randomUUID().toString().hashCode()));
        coin.setMinFeeNum(BigDecimal.valueOf(1));
        coin.setStatus(true);
        coin.setCreated(new Date());
        coin.setLastUpdateTime(new Date());

        AssertUtil.isTrue(insertHasKey(coin) < 1, "添加失败了");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void removeCoinIds(Long[] ids) {

        AssertUtil.isTrue(ids==null || ids.length==0,"请选择要删除的数据");
        AssertUtil.isTrue(deleteBatch(ids)==0,"请选择要删除的数据");
    }

    public void changeCoin(Coin coin) {

        Coin temp = coinMapper.selectByPrimaryKey(coin.getId());
        AssertUtil.isTrue(temp==null,"待更新数据不存在");

        if (StringUtils.isBlank(coin.getName()) && StringUtils.isBlank(coin.getWallet())) {
            coin.setStatus(true);
            coin.setLastUpdateTime(new Date());
            coin.setCreated(temp.getCreated());
            coin.setTitle(coin.getTitle());
            coin.setMinFeeNum(temp.getMinFeeNum());
            coin.setMinAmount(temp.getMinAmount());

        }

        AssertUtil.isTrue(updateByPrimaryKeySelective(coin)<1,"修改失败了");

    }

}
