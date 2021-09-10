package com.lxl.Utils;

/**
 * @LXL
 */
public class getHamming {
    /**
     * 比较两个simHash值，找到差异的位数，即海明距离
     * @param simHash
     * @param simHash1
     * @return 得到海明距离
     */
    public static int hammingValue(String simHash,String simHash1){
        int len = 0 ;
        if(simHash.length() != simHash1.length()){
            len = -1;
        }else{
            for (int i = 0; i < simHash.length() ; i++) {
                if(simHash.charAt(i) != simHash1.charAt(i)){
                    len ++;
                }
            }
        }
        return len;
    }

    /**
     * 通过以上方法，求得重合率
     * @param simHash
     * @param simHash1
     * @return
     */
    public static double getCoincidence(String simHash,String simHash1){
        int len = hammingValue(simHash,simHash1);
        int t = (100 - len * 10 /128)/100;
        return t;
    }
}
