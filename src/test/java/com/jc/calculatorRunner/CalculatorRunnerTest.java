package com.jc.calculatorRunner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorRunnerTest {

    CalculatorRunner calculatorRunner=new CalculatorRunner();
    @Test
    void runCalculator() {
        calculatorRunner.runCalculator();
    }
}