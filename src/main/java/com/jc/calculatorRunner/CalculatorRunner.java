package com.jc.calculatorRunner;

import com.jc.UserCentre.NewUser;
import com.jc.calcutlatorCore.CalculatorCore;
import com.jc.input.InputHandler;
import com.jc.output.OutputHandler;
import com.jc.utils.Utils;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@Data
public class CalculatorRunner {

    private CalculatorCore calculatorCore;
    private InputHandler inputHandler;
    private OutputHandler outputHandler;
    private NewUser user;

    public void runCalculator(){
        initializeComponents();
        calculatorPivot(inputHandler.getAllInputFormatCodes());
        outputHandler.outputResult();
    }

    private void calculatorPivot(String[] inputCodes){
        Arrays.stream(inputCodes).forEach((code)->{
            List<Integer> combination= calculatorCore.processData(
                    inputHandler.getTotalByFormatCode(code),
                    inputHandler.getBundlesArrayByFormatCode(code));

            outputHandler.buildOutput(combination, inputHandler.getFormatByFormatCode(code));
        });
    }

    private void initializeComponents(){
        user=new NewUser();
        inputHandler=new InputHandler(user);
        calculatorCore=new CalculatorCore();
        outputHandler=new OutputHandler(user);
    }



}
