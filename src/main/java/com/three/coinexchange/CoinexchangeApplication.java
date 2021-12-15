package com.three.coinexchange;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.three.coinexchange.mapper")
public class CoinexchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoinexchangeApplication.class, args);
    }

}
