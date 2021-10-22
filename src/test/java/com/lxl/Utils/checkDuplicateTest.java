package com.lxl.Utils;

import org.junit.Test;

/**
 * @LXL
 */
public class checkDuplicateTest {
    @Test
    public void checkEquationTest(){
        checkDuplicate cd = new checkDuplicate();
        String equ1 = "1+(2+3)";
        String equ2 = "1+2+3";
        boolean tag = cd.checkEquation(equ1,equ2);
        System.out.println(tag);
    }

}
