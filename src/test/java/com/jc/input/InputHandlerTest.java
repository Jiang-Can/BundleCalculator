package com.jc.input;

import com.jc.UserCentre.NewUser;
import com.jc.bean.Format;
import com.jc.utils.Utils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class InputHandlerTest {

    InputHandler inputHandler=new InputHandler(new NewUser());
    @Test
    void getBundlesArrayByFormatCode() {
        Utils.logger.info(Arrays.toString(inputHandler.getBundlesArrayByFormatCode("IMG")));
    }

    @Test
    void getTotalByFormatCode() {
        Utils.logger.info(inputHandler.getTotalByFormatCode("IMG"));
    }

    @Test
    void getAllInputFormatCodes() {
        Arrays.stream(inputHandler.getAllInputFormatCodes()).forEach(Utils.logger::info);
    }

    @Test
    void getUser() {
        System.out.println(inputHandler.getUser());
    }

    @Test
    void getFormats(){
        for(Map.Entry<String, Format>  entry:inputHandler.getFormats().entrySet()){
            Utils.logger.debug(entry);
        }

    }
}