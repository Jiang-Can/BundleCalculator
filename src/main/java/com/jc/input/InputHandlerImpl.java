package com.jc.input;

import com.jc.bean.Format;
import com.jc.utils.Utils;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

@Data
public class InputHandlerImpl implements InputHandler {

    private static final String jsonFileName="bundles.json";
    private static final String inputFileName="input.txt";

    private static final String jsonConfigFile= Objects.requireNonNull(InputHandlerImpl.class.getClassLoader().getResource(jsonFileName)).getPath();
    private static final String inputFile= Objects.requireNonNull(InputHandlerImpl.class.getClassLoader().getResource(inputFileName)).getPath();

    /*
    * Using HashMap to store all kinds for formats read from bundles config file
    * key is the format code which is used as identity for each format
    * */
    private HashMap<String,Format> formats;

    /*
    * Using HashMap to store all needed format code with its total number
    * key is the format code which use to map its total number
     * */
    private HashMap<String,Integer> inputs;

    public InputHandlerImpl(){initializeData();}

    public Integer[] getBundlesArrayByFormatCode(String code){
        return formats.get(code).getBundles().keySet().toArray(new Integer[0]);
    }

    public HashMap<Integer, BigDecimal> getBundlesSpecsByFormatCode(String code) {
        return formats.get(code).getBundles();
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
    }

    private void setFormats(){
        formats=new HashMap<>();
        Arrays.stream(Utils.JsonFileReader(jsonConfigFile)).forEach((format)->{
            formats.put(format.getCode(),format);
        });
    }
    private void setInputs(){
        inputs=Utils.inputFilerReader(inputFile);
    }

}
