package com.three.coinexchange.controller;

import com.three.coinexchange.base.BaseController;
import com.three.coinexchange.base.ResultInfo;
import com.three.coinexchange.bean.CoinType;
import com.three.coinexchange.query.CoinTypeQuery;
import com.three.coinexchange.service.CoinTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

@Controller
@RequestMapping("coinTypes")
public class CoinTypeController extends BaseController {

    @Resource
    private CoinTypeService coinTypeService;

    @RequestMapping("index")
    public String index() {
        return "coin/cointype";
    }

    @RequestMapping("find")
    @ResponseBody
    public Map<String,Object> findAll(CoinTypeQuery coinTypeQuery) {
        return coinTypeService.findAll(coinTypeQuery);
    }

    @RequestMapping("toAddOrUpdate")
    public String toAddOrUpdate(Long id, Model model) {
        if(id!=null){
            CoinType coinType = coinTypeService.selectByPrimaryKey(id);
            model.addAttribute("coinType",coinType);
        }
        return "coin/add_update";
    }

    @RequestMapping("save")
    @ResponseBody
    public ResultInfo save(CoinType coinType) {
        coinTypeService.addCoinType(coinType);
        return success("货币添加成功");
    }

    @RequestMapping("dels")
    @ResponseBody
    public ResultInfo deletes(Long[] ids) {
        coinTypeService.removeCoinTypeIds(ids);

        return success("批量删除成功了");
    }

    @RequestMapping("update")
    @ResponseBody
    public ResultInfo update(CoinType coinType) {
        coinTypeService.changeCoinType(coinType);

        return success("修改成功");
    }

}
