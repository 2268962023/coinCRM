package com.three.coinexchange.controller;

import com.three.coinexchange.base.BaseController;
import com.three.coinexchange.base.ResultInfo;
import com.three.coinexchange.bean.Coin;
import com.three.coinexchange.bean.CoinType;
import com.three.coinexchange.query.CoinQuery;
import com.three.coinexchange.service.CoinService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("coin")
public class CoinController extends BaseController {

    @Resource
    private CoinService coinService;

    @RequestMapping("coin")
    public String index() {
        return "coin/coin";
    }

    @RequestMapping("find")
    @ResponseBody
    public Map<String,Object> findAll(CoinQuery coinQuery) {
        return coinService.findAll(coinQuery);
    }

    @RequestMapping("toAddOrUpdate")
    public String toAddOrUpdate(Long id, Model model) {
        if(id!=null){
            Coin coin = coinService.selectByPrimaryKey(id);
            model.addAttribute("coin",coin);
        }
        return "coin/add_coin_update";
    }

    @RequestMapping("save")
    @ResponseBody
    public ResultInfo save(Coin coin) {
        coinService.addCoinType(coin);
        return success("货币添加成功");
    }

    @RequestMapping("dels")
    @ResponseBody
    public ResultInfo deletes(Long[] ids) {
        coinService.removeCoinIds(ids);
        return success("批量删除成功了");
    }

    @RequestMapping("update")
    @ResponseBody
    public ResultInfo update(Coin coin) {
        coinService.changeCoin(coin);

        return success("修改成功");
    }

}
