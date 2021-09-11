package com.lxl.main;
import com.lxl.Utils.filesIO;
import com.lxl.Utils.getHamming;
import com.lxl.Utils.simHash;

/**
 * @LXL
 */
public class mainDupCheck {
    public static void main(String[] args) {
        String s0 = filesIO.readFile(args[0]);
        String s1 = filesIO.readFile(args[1]);//将文件内容转为字符串
        String finallyFile = args[2];//结果文件
        String sHash0 = simHash.getSimHash(s0);
        String sHash1 = simHash.getSimHash(s1);
        double coincidence = getHamming.getCoincidence(sHash0,sHash1);
        filesIO.writeFile(coincidence,finallyFile);//求出重合率写入最终结果文件
        System.exit(0);
    }
}
