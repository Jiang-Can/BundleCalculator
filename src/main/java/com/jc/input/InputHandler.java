package com.jc.input;

import com.jc.UserCentre.NewUser;
import com.jc.bean.Format;
import com.jc.utils.Utils;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data
public class InputHandler {

    private static final String jsonFileName="bundles.json";

    private static final String inputFileName="input.txt";

    private HashMap<String,Format> formats;

    private HashMap<String,Integer> inputs;

    private NewUser user;

    public InputHandler(NewUser user){
        this.user=user;
        initializeData();
    }

    public Integer[] getBundlesArrayByFormatCode(String code){
        return formats.get(code).getBundles().keySet().toArray(new Integer[0]);
    }

    public int getTotalByFormatCode(String code){
        return inputs.get(code);
    }

    public String[] getAllInputFormatCodes(){
        return inputs.keySet().toArray(new String[0]);
    }

    public Format getFormatByFormatCode(String code){
        return formats.get(code);
    }

    private void initializeData(){
        setInputs();
        setFormats();
        setUserInputList();
    }

    private void setUserInputList(){
        user.handleUserInput(inputs);
    }

    private void setFormats(){
        formats=new HashMap<>();
        Arrays.stream(Utils.JsonFileReader(jsonFileName)).forEach((format)-> formats.put(format.getCode(),format));
    }
    private void setInputs(){
        inputs=Utils.inputFilerReader(inputFileName);
    }

}
