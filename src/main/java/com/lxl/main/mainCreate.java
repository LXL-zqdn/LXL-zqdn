package com.lxl.main;

import com.lxl.Utils.*;

import java.io.File;
import java.util.Scanner;

/**
 * @LXL
 */
public class mainCreate {
    public static void main(String[] args) {
        equationCreate equC = new equationCreate();
        beSuffix suffix = new beSuffix();
        filesIO fIO = new filesIO();

        File f1 = new File("Exercises.txt");
        File f2 = new File("Answers.txt");
        File f3 = new File("firstAnswers.txt");
        File f4 = new File("Grade.txt");

        int n=1,m=10;
        System.out.println("----------------------------------------");
        System.out.println("         四则运算生成系统            ");
        System.out.println("-n: 题目的个数    -r: 数值的范围");
        System.out.println("-o: 输出统计结果   -g: 执行程序");
        System.out.println("----------------------------------------");
        System.out.println("请输入指令: ");
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            switch (sc.next()) {
                case "-n":
                    System.out.println("请输入运算题目的个数：");
                    n = sc.nextInt();
                    break ;
                case "-r":
                    System.out.println("请输入运算数的数值范围：");
                    m = sc.nextInt();
                    break ;
                case "-o":
                    fIO.CWfiles(f2, f3, f4);
                    break ;
                case "-g":
                    for (int i = 0; i < n; i++) {
                        String str = equC.equations(n,m);//生成中缀表达式
                        String newStr;
                        String answer = suffix.calculateSuffix(suffix.becomeSuffix(str));
                        //转为后缀表达式并求解
                        newStr = i + 1 + ":" + str + "\r\n";//将题目运算式写入文件
                        fIO.writeFile(f1, newStr);
                        newStr = i + 1 + ":" + answer + "\r\n";//将答案写入文件
                        fIO.writeFile(f2, newStr);
                    }
                    break ;
                default:
                    System.out.println("请输入正确指令！");
                    break ;
            }
            System.out.println("请输入指令: ");
        }
    }
}
