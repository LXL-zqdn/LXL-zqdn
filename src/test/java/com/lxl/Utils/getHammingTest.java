package com.lxl.Utils;

import org.junit.Test;

/**
 * @LXL
 */
public class getHammingTest {
    @Test
    public void getHammingLenTest(){
        String s = filesIO.readFile("D:\\Test2\\orig.txt");
        String s1 = filesIO.readFile("D:\\Test2\\orig_0.8_add.txt");
        int len = getHamming.hammingValue(simHash.getSimHash(s),simHash.getSimHash(s1));
        System.out.println("Hamming距离为："+len);
        System.out.println("论文重合率为："+(100-len*100/128)+"%");
    }//对hammingValue()方法的测试

    @Test
    public void getHammingLenFail(){
        String s = "10011010";
        String s1 = "1011001";
        System.out.println(getHamming.hammingValue(s,s1));
    }//测试两simHash值长度不同的情况

    @Test
    public void getCoincidenceTest(){
        String s = filesIO.readFile("D:\\Test2\\orig.txt");
        String s1 = filesIO.readFile("D:\\Test2\\orig_0.8_add.txt");
        int len = getHamming.hammingValue(simHash.getSimHash(s),simHash.getSimHash(s1));
        double coincidence = getHamming.getCoincidence(simHash.getSimHash(s),simHash.getSimHash(s1));
        System.out.println("两论文的Hamming距离为："+len);
        System.out.println("两论文的重合率为："+coincidence);
    }//对getCoincidence()方法的测试
}

