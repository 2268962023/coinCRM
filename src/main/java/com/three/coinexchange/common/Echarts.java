package com.three.coinexchange.common;


import lombok.Data;

import java.io.Serializable;

@Data
public class Echarts<T> implements Serializable {
    private static final long serialVersionUID = -8093411787723692004L;

    private T value;
    private String name;



    public Echarts(T value, String name) {
        this.value = value;
        this.name = name;
    }
}
