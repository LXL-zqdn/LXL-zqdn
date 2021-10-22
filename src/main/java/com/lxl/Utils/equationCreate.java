package com.lxl.Utils;

import java.util.Random;

/**
 * @LXL
 */
public class equationCreate {
    /**
     * 生成算数运算式（中缀表达式）
     * @param m 运算式所需数字的范围
     * @return 返回算数运算式（中缀表达式）
     */
    public  String equations(int n, int m){
        String equ = numberCreate(m);
        Random r = new Random();
        int ch = r.nextInt(2);
        boolean tag = false;
        if(ch > 0){
            tag = bracket();
        }
        if(tag = true){
            equ = equ + symbolCreate()+"("+numberCreate(m)+symbolCreate()+numberCreate(m)+")";
        }else{
            equ = equ + symbolCreate() + numberCreate(m);
        }
        return equ;
    }

    /**
     * 随机生成运算需要的数字
     * @param m 运算数的范围
     * @return 返回生成的数字的字符串形式
     */
    public  String numberCreate(int m){
        String s = " ";
        Random r = new Random();
        int ch = r.nextInt(2);
        switch (ch){
            case 0:
                s = Integer.toString(r.nextInt(m-1)+1);
                break;
            case 1:
                int a = r.nextInt(m-1)+1;
                int b = r.nextInt(m-2)+2;
                s = Simplify(a ,b);
                break;
        }
        return s;
    }

    /**
     * 若生成的数为分数，对分数进行约分化简
     * @param a 操作数a
     * @param b 操作数b
     * @return 返回化简结果
     */
    public  String Simplify(int a,int b){
        String s = "";
        int commonNum = 1 ,c;//公约数
        c = a/b;
        a = a % b;
        if(c < 0){
            a = a*(-1);//当c小于0时，有一个负号了，将余数的负号删去
        }
        for(int i =1;i <= a;i++){
            if(a % i==0 && b % i ==0){
                commonNum = i;  //求出最大公约数
            }
        }
        a = a / commonNum;
        b = b / commonNum;   //化简
        if(a == 0){
            s = Integer.toString(c);
        }else if(c == 0){
            s = Integer.toString(a)+"/"+Integer.toString(b);
        }else{
            s = Integer.toString(c)+"'"+Integer.toString(a)+"/"+Integer.toString(b);
        }
        return s;
    }

    /**
     * 随机生成运算需要的符号
     * @return
     */
    public String symbolCreate(){
        String s = "";
        Random r = new Random();
        int ch = r.nextInt(4);
        switch (ch){
            case 0 :s = "+";break;
            case 1 :s = "-";break;
            case 2 :s = "*";break;
            case 3 :s = "÷";break;
        }
        return s;
    }
    public  boolean bracket(){
        boolean tag = false;
        Random r = new Random();
        if((r.nextInt(3))>1){  //0、1、2中大于1的只有2，所以生成括号的概率是三分之一
            tag = true;
        }
        return tag;
    }
}
