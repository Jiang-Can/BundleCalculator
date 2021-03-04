package com.jc.input;


import com.jc.bean.Format;

import java.math.BigDecimal;
import java.util.HashMap;

/*
* The user of this interface can convert the data in bundles configuration file
* and input file to the form which can be processed by Calculator Core and
* provide necessary data for the output component
*
* */
public interface InputHandler {

    /**
     * @param code string of code
     * @return corresponding format
     */
    Format getFormatByFormatCode(String code);

    /**
     * read file from input so as to get all the submission formats which are required to be processed
     * @return a String array contains all needed format code in order(input file)
     */
    String[] getAllInputFormatCodes();

    /**
     * @param code string of code
     * @return An integer array contains all kinds of bundle relate to the format code provided in param
     */
    Integer[] getBundlesArrayByFormatCode(String code);

    /**
     * @param code string of code
     * @return An HashMap contains the specification of bundles related to this code,
     * I.e.The item provides the size of the bundles and the corresponding price
     */
    HashMap<Integer, BigDecimal> getBundlesSpecsByFormatCode(String code);

    /**
     * @param code string of code
     * @return the number of items according to the format code provided in param
     */
    int getTotalByFormatCode(String code);


}
