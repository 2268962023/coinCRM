package com.three.coinexchange;

import com.three.coinexchange.bean.Menu;
import com.three.coinexchange.common.SysMenu;
import com.three.coinexchange.service.SysMenuService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class CoinexchangeApplicationTests {

    @Resource
    private SysMenuService menuService;

    @Test
    void contextLoads() {
        Menu menu = new Menu();
        menu.setStatus("1");
        menu.setType("1");
        List<SysMenu> menus = menuService.menus(menu, 1010101010101010101L);
        System.out.println(menus);
    }

}
