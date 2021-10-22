package com.lxl.main;

import com.lxl.Utils.beSuffix;
import com.lxl.Utils.equationCreate;
import com.lxl.Utils.filesIO;
import org.junit.Test;

import java.io.File;

/**
 * @LXL
 */
public class mainTest {
    @Test
    public void theMainTest() {
        equationCreate equC = new equationCreate();
        beSuffix suffix = new beSuffix();
        filesIO fIO = new filesIO();
        File f1 = new File("Exercises(1).txt");
        File f2 = new File("Answers(1).txt");
        int n=10000;
        int m = 50;
            for (int i = 0; i < n; i++) {
                String str = equC.equations(n, m);//生成中缀表达式
                String newStr;
                String answer = suffix.calculateSuffix(suffix.becomeSuffix(str));
                //转为后缀表达式并求解
                newStr = i + 1 + ":" + str + "\r\n";//将题目运算式写入文件
                fIO.writeFile(f1, newStr);
                newStr = i + 1 + ":" + answer + "\r\n";//将答案写入文件
                fIO.writeFile(f2, newStr);
            }
    }
}
