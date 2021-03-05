package com.jc.calculatorRunner;

import com.jc.calcutlatorCore.CalculatorCore;
import com.jc.calcutlatorCore.CalculatorCoreImpl;
import com.jc.input.InputHandler;
import com.jc.input.InputHandlerImpl;
import com.jc.output.OutputHandler;
import com.jc.output.OutputHandlerImpl;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
public class CalculatorRunner {

    private CalculatorCore calculatorCore;
    private InputHandler inputHandler;
    private OutputHandler outputHandler;

    //running calculator by call this method only
    public void runCalculator(){
        initializeComponents();
        //pass all required format codes
        calculatorPivot(inputHandler.getAllInputFormatCodes());
        outputHandler.outputResult();
    }

    /*
    *  This is the pivot of calculator.
    *  It gathers all required code from inputHandler.
    *  Then iteratively passing data on calculatorCore so as to get the combination,
    *  further, using this combination and corresponding format to generate output string
    * */
    private void calculatorPivot(String[] inputCodes){
        Arrays.stream(inputCodes).forEach((code)->{
            List<Integer> combination= calculatorCore.processData(
                    inputHandler.getTotalByFormatCode(code),
                    inputHandler.getBundlesArrayByFormatCode(code));

            outputHandler.buildOutputStr(combination, inputHandler.getFormatByFormatCode(code));
        });
    }

    private void initializeComponents(){
        inputHandler=new InputHandlerImpl();
        calculatorCore=new CalculatorCoreImpl();
        outputHandler=new OutputHandlerImpl();
    }



}
