package com.jc.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Format {
    private String name;
    private String code;
    private HashMap<Integer,BigDecimal> bundles;


}
