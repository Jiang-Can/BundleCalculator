package com;

import com.jc.calculatorRunner.CalculatorRunner;
import com.jc.utils.Utils;

public class Boot {
    public static void main(String[] args) {

        CalculatorRunner calculatorRunner=new CalculatorRunner();

        calculatorRunner.runCalculator();

        Utils.logger.debug(calculatorRunner.getUser());

    }
}
