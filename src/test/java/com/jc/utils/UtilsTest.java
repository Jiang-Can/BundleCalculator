package com.jc.utils;

import com.jc.bean.Format;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void idGenerator() {
        for(int i=0;i<10;i++){
            System.out.println(Utils.idGenerator());
        }

    }
    @Test
    public void testJsonFileReader(){

        Format[] list= Utils.JsonFileReader("bundles.json");
        for(Format format:list){
            Utils.logger.info(format);
        }
    }

    @Test
    void inputFilerReader() {
        HashMap<String,Integer> map=Utils.inputFilerReader("input.txt");
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            Utils.logger.info(entry);
        }
    }
}