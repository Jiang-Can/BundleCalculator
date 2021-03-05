package com.jc.calcutlatorCore;

import java.util.List;

/*
* CalculatorCore receives bundles array(format specs) and corresponding total required number,
* Then calling the processData method to generate combination of bundle
* which contain the minimal number of bundles.
* */
public interface CalculatorCore {

    List<Integer> processData(int total, Integer[] bundles);
}
