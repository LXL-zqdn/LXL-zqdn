package com.lxl.Utils;

import org.junit.Test;

/**
 * @LXL
 */
public class simHashTest {
    @Test
    public void getHashTest(){
        String[] strings = {"用","同情","的","目光","看待","世界"};
        for(String str : strings){
            String strHash = simHash.getHash(str);
            System.out.println(strHash.length());
            System.out.println(strHash);
        }
    }
    @Test
    public void getSimHashTest(){
        String s = filesIO.readFile("D:\\Test2\\orig.txt");
        String s1 = filesIO.readFile("D:\\Test2\\orig_0.8_add.txt");
        System.out.println(simHash.getSimHash(s));
        System.out.println(simHash.getSimHash(s1));
    }
}
