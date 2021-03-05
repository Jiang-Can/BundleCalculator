package com.jc.calcutlatorCore;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@NoArgsConstructor
public class CalculatorCoreImpl implements CalculatorCore {

    /*
    * Number of items in Each order
     * */
    private int total;

    /*
     * This array contains different combinations of bundles for each format
     * */
    private Integer[] bundles;

    /*
    *  store the minimal number of bundles combination.
    * */
    private List<Integer> combination;

    /*
    * the findCombination method may find a number(<total) which cannot get to the total
    * by using exist bundle in array
    * */
    private boolean[] cache;

    public List<Integer> processData(int total,Integer[] bundles){
        this.total=total;
        this.bundles=bundles;
        generateCombination();
        return combination;
    }


    private void generateCombination(){
        // sort bundles in descending order so as to give priority to combine bigger bundle
        Arrays.sort(bundles, (a,b)->Integer.compare(b,a));

        cache=new boolean[total+1];
        if(!findCombination(0, new ArrayList<>())){
            //if it does not exist a combination which is exactly equal to the total,
            // find a combination that is closest to and greater than the total
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
            //if found, no need to go further, since it is greedy to combine the bigger bundle,
            //which means that the first combination found  contains the minimal number of bundles.
            if(find)break;
            cur.remove(cur.size()-1);
        }
        //if the sum at this point fails to get the total by combining all possible combination
        //store this position at cache so as to avoid recursion at this point next time
        // reduce unnecessary recursive call
        if(!find)cache[sum]=true;
        return find;
    }

    private void findCombinationOverTotal(){
        ArrayList<Integer> cur=new ArrayList<>();
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
