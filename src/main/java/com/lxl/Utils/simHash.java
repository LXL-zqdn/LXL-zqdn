package com.lxl.Utils;

import com.hankcs.hanlp.HanLP;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

/**
 * @LXL
 */
public class simHash {
    /**
     * 此方法用于计算分词的hash值
     * 后面便于计算simhash值
     * @param s 传入的字符串
     * @return 返回hash值
     */
    public static String getHash(String s){
        try {
            //使用MD5获得hash值
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return new BigInteger(1, messageDigest.digest(s.getBytes("UTF-8"))).toString(2);
        }catch (Exception e){
            e.printStackTrace();
            return s;
        }
    }

    /**
     * 此方法用于计算simhash值
     * @param s 传入的字符串
     * @return 返回simhash值
     */
    public static String getSimHash(String s){
        try{
            if(s.length() < 180) throw new filesException("文本异常");
        }catch (filesException  e){
            e.printStackTrace();
            return null;
        }
       int[] val = new int[128];
       //1、分词操作，运用外部依赖hankcs包提供的接口进行分词
        List<String> kwList = HanLP.extractKeyword(s,s.length());//提取关键词
        int len = kwList.size();
        int i = 0;
        for(String keyword : kwList){
            //2、求hash值
            String kwHash = getHash(keyword);
            if(kwHash.length() < 128){
                int x = 128-kwHash.length();
                for (int j = 0; j < x; j++) {
                    kwHash += "0";//低位用0补齐
                }
            }
            //3、加权
            for (int j = 0; j < val.length ; j++) {
                if(kwHash.charAt(j) == '1'){
                    val[j] += (10-(i/(len/10)));
                }else {
                    val[j] -= (10-(i/(len/10)));
                }
            }
            i++;
        }
        //4、降维
        String simhash = "";
        for (int j = 0; j <val.length ; j++) {
            if(val[j]<0){
                simhash += "0";
            }else {
                simhash += "1";
            }
        }
        return simhash;
    }
}
