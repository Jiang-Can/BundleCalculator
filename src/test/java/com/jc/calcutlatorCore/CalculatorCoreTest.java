package com.jc.calcutlatorCore;

import com.jc.utils.Utils;
import org.junit.jupiter.api.Test;

import javax.rmi.CORBA.Util;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorCoreTest {
    CalculatorCore calculatorCore=new CalculatorCore();
    @Test
    void processData() {
        calculatorCore.processData(13,new Integer[]{3,5,9});
        for(Integer i:calculatorCore.getCombination()){
            Utils.logger.debug(i);
        }
        calculatorCore.processData(7,new Integer[]{3,5,9});
        for(Integer i:calculatorCore.getCombination()){
            Utils.logger.debug(i);
        }
    }
}