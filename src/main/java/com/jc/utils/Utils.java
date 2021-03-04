package com.jc.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jc.bean.Format;

import java.io.*;
import java.util.HashMap;

public class Utils {

    /**
     * @param fileName The filename of bundles configuration file: default "bundles.json"
     * @return An array contains all kinds of formats in configuration file
     */
    public static Format[] JsonFileReader(String fileName) {
        Format[] formats=null;
        try {
            formats=new ObjectMapper().readValue(new File(fileName), Format[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return formats;
    }

    /**
     * @param fileName The filename of input file: default "input.txt"
     * @return HashMap, Key is submission format code, value is total items needed
     */
    public static HashMap<String,Integer> inputFilerReader(String fileName){
        File file = new File(fileName);
        HashMap<String,Integer> inputs=new HashMap<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] s = line.split(" ");
                inputs.put(s[1],Integer.parseInt(s[0]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            resourcesClose(fileReader,bufferedReader);
        }
        return inputs;
    }

    private static void resourcesClose(Closeable ...resources){
        for(Closeable resource:resources){
            if (resource != null) {
                try {
                    resource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
