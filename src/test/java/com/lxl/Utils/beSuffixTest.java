package com.lxl.Utils;

import org.junit.Test;

/**
 * @LXL
 */
public class beSuffixTest {
    @Test
    public void becomeSuffixTest(){
        beSuffix bs = new beSuffix();
        String str = "5+(1*7)";
        String newStr = bs.becomeSuffix(str);
        System.out.println(newStr);
    }
    @Test
    public void calculateSuffixTest(){
        beSuffix bs = new beSuffix();
        String str = "517*+";
        String end = bs.calculateSuffix(str);
        System.out.println(end);
    }
    @Test
    public void myCalculationTest(){
        beSuffix bs = new beSuffix();
        String x1 = "1'1/3";
        String x2 = "2";
        String ch = "+";
        String str = bs.myCalculation(x1,x2,ch);
        System.out.println(str);
    }
}
