package com.jc.calcutlatorCore;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
public class CalculatorCore {

    private int total;

    private Integer[] bundles;

    private List<Integer> combination;

    private boolean[] cache;

    public List<Integer> processData(int total,Integer[] bundles){
        this.total=total;
        this.bundles=bundles;
        generateCombination();
        return combination;
    }


    private void generateCombination(){
        Arrays.sort(bundles, (a,b)->Integer.compare(b,a));

        cache=new boolean[total+1];
        if(!findCombination(0, new ArrayList<>())){
            findCombinationOverTotal();
        }
    }

    private boolean findCombination(int sum,List<Integer> cur){
        if(sum==total){
            combination =new ArrayList<>(cur);
            return true;
        }
        if(sum>total||cache[sum])return false;
        boolean find=false;
        for (int bundle : bundles) {
            cur.add(bundle);
            find=findCombination(sum + bundle, cur);
            if(find) { break;}
            cur.remove(cur.size()-1);
        }
        if(!find){cache[sum]=true;}
        return find;
    }

    private void findCombinationOverTotal(){
        List<Integer> cur=new ArrayList<>();
        int sum=bundles[0];
        while (sum<total){
            cur.add(bundles[0]);
            sum+=bundles[0];
        }
        sum-=bundles[0];
        for(int i=bundles.length-1;i>=0;i--){
            if(sum+bundles[i]>total){
                cur.add(bundles[i]);
                break;
            }
        }
        combination=new ArrayList<>(cur);
    }
}
