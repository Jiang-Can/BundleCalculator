package com.jc.output;

import com.jc.UserCentre.NewUser;
import com.jc.bean.Format;
import com.jc.utils.Utils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputHandler {

    private HashMap<Integer,Integer> optimizedCombination;

    private StringBuilder outputStr;

    private int realTotal;

    private NewUser user;

    public OutputHandler(NewUser user){
        outputStr=new StringBuilder();
        this.user=user;
    }

    public void buildOutput(List<Integer> combination, Format format){
        optimizeCombinationArray(combination);
        StringBuilder itemOutput=new StringBuilder();
        BigDecimal amounts=new BigDecimal(0);
        HashMap<Integer,BigDecimal> bundlesSpecs=format.getBundles();
        int quantity;
        BigDecimal subTotal;

        for(Map.Entry<Integer,Integer> entry:optimizedCombination.entrySet()){
            quantity=entry.getValue();
            subTotal=bundlesSpecs.get(entry.getKey()).multiply(new BigDecimal(quantity));
            itemOutput.append(" ").append(quantity).append(" x ").append(entry.getKey())
                    .append(" $").append(subTotal).append("\n");

            user.buildInvoiceList(quantity,subTotal);

            amounts=amounts.add(subTotal);
        }

        outputStr.append(realTotal).append(" ").append(format.getCode()).append(" ")
                .append(amounts).append("\n").append(itemOutput);
        user.setTotal(user.getTotal().add(amounts));
    }

    public void outputResult(){
        Utils.logger.info(outputStr);
    }


    private void optimizeCombinationArray(List<Integer> combination){
        realTotal=0;
        optimizedCombination =new HashMap<>();
        for(Integer num:combination){
            if(optimizedCombination.containsKey(num)){
                optimizedCombination.put(num, optimizedCombination.get(num)+1);
            }else {
                optimizedCombination.put(num,1);
            }
            realTotal+=num;
        }
    }
}
