package com.lxl.Utils;

import java.util.Stack;

/**
 * @LXL
 */
public class beSuffix {
    /**
     * 将中缀表达式转换为后缀表达式
     * @param equ
     * @return
     */
    public  String becomeSuffix(String equ){
        Stack<Character> s = new Stack<Character>();
        String newStr = " ";
        int length = equ.length();
        for (int i = 0; i < length; i++) {
            char e ;
            char ch = equ.charAt(i);
            switch (ch){
                case '(':        //左括号优先级最高，直接入栈，但只有遇到右括号才出栈
                    s.push(ch);
                    break;
                case '+':
                case '-':
                    newStr += " ";
                    while(s.size() != 0){
                        e = s.pop();
                        if(e == '('){  //优先级最低，不断将比自己高级的弹出栈并输出，直到遇到左括号，左括号不出栈
                            s.push('(');//前面弹出栈，现在又压入栈
                            break;
                        }else{
                            newStr += e;
                            newStr += " ";}
                    }
                    s.push(ch);
                    break;
                case '*':
                case '÷':
                    newStr += " ";
                    while(s.size() != 0){//只需将同级符号弹出并输出，加减号低级，左括号又不能弹出，所以遇到这三者都直接入栈
                        e = s.pop();//弹出
                        if(e == '('||e == '+'||e=='-'){
                            s.push(e);
                            break;
                        }else{
                            newStr += e;//输出
                            newStr += " ";}
                    }
                    s.push(ch);
                    break;
                case ')':
                    while(!s.isEmpty()){
                        e = s.pop();//只需将栈顶依次弹出并输出，直到遇到左括号，将左括号弹出
                        if(e == '('){
                            break;
                        }else{
                            newStr += " ";
                            newStr += e;
                        }
                    }
                    break;
                default:
                    newStr += ch;//若为数字，直接输出，不入栈
                    break;
            }
        }
        while(s.size() != 0){  //把栈中剩余的符号全部输出
            newStr += " ";
            newStr += s.pop();
        }
        return newStr;
    }

    /**
     * 计算后缀表达式
     * @param newStr 由前面转换而来的后缀表达式
     * @return 返回计算结果
     */
    public  String calculateSuffix(String newStr){
        String[] strings = newStr.split(" ");//按空格分解字符串
        Stack<String> stack = new Stack<String>();//将后缀表达式中的数字入栈，若是符号则取栈顶两数运算后结果压入栈
        for (int i = 0; i < strings.length ; i++) {
            if(strings[i].equals("+")||strings[i].equals("-")||strings[i].equals("*")||strings[i].equals("÷")){
                String x2 = stack.pop();
                String x1 = stack.pop();
                String str = myCalculation(x1,x2,strings[i]);
                stack.push(str);//把计算结果压入栈作为新的操作数
                if(str.equals("无解")){
                    return str;
                }
            }else{
                stack.push(strings[i]);//若为数字，直接入栈
            }
        }
        return stack.pop();//最后的栈顶即为结果
    }

    /**
     * 自定义四则运算法则
     * @param x1 第一个数
     * @param x2 第二个数
     * @param ch 运算符
     * @return 返回两数进行运算的结果
     */
    public  String myCalculation(String x1,String x2,String ch){
        String str = "";
        boolean tag1 = false,tag2 = false;
        if(x1.contains("/")){  //判断两数是否为分数
            tag1 = true;
        }
        if(x2.contains("/")){
            tag2 = true;
        }
        int a=1,b=1,c=1,d=1,l1=0,l2=0;  //两个分数分别为 l1'a/c 和 l2'b/d
        if(tag1 == false && tag2 == false){  //第一种情况，x1,x2均为整数
            a = Integer.parseInt(x1);
            b = Integer.parseInt(x2);
        }
        if(tag1 == false && tag2 == true){   //第二种情况，x1为整数，x2为带分数
            a = Integer.parseInt(x1);
            int index2 = x2.indexOf("'");
            if(index2 != -1){
                l2 = Integer.parseInt(x2.substring(0,index2));//整数
            }
            int dex2 = x2.indexOf("/");
            b = Integer.parseInt(x2.substring(index2+1,dex2));  //分子
            d = Integer.parseInt(x2.substring(dex2+1,x2.length())); //分母
            if(l2 < 0){
                b = l2*d-b;  //比如 -1'1/3，转换为分数：分子= 1*3-1 = 2，分母为3
            }else{
                b = l2*d+b;  //比如 1'1/3，转换为分数：分子= 1*3+1 = 4，分母为3，结果为 4/3
            }
        }
        if(tag1 == true && tag2 == false){   //第三种情况，x1为带分数，x2为整数
            b = Integer.parseInt(x2);
            int index1 = x1.indexOf("'");
            if(index1 != -1){
                l1 = Integer.parseInt(x1.substring(0,index1));//整数
            }
            int dex1 = x1.indexOf("/");
            a = Integer.parseInt(x1.substring(index1+1,dex1));  //分子
            c = Integer.parseInt(x1.substring(dex1+1,x1.length())); //分母
            if(l1 < 0){
                a = l1*c-a;  //比如 -1'1/3，转换为分数：分子= 1*3-1 = 2，分母为3
            }else{
                a = l1*c+a;  //比如 1'1/3，转换为分数：分子= 1*3+1 = 4，分母为3，结果为 4/3
            }
        }
        if(tag1 == true && tag2 == true){ //第四种情况，x1,x2都为带分数
            int index1 = x1.indexOf("'");
            if(index1 != -1){
                l1 = Integer.parseInt(x1.substring(0,index1));//整数
            }
            int dex1 = x1.indexOf("/");
            a = Integer.parseInt(x1.substring(index1+1,dex1));  //分子
            c = Integer.parseInt(x1.substring(dex1+1,x1.length())); //分母
            if(l1 < 0){
                a = l1*c-a;  //比如 -1'1/3，转换为分数：分子= 1*3-1 = 2，分母为3
            }else{
                a = l1*c+a;  //比如 1'1/3，转换为分数：分子= 1*3+1 = 4，分母为3，结果为 4/3
            }

            int index2 = x2.indexOf("'");
            if(index2 != -1){
                l2 = Integer.parseInt(x2.substring(0,index2));//整数
            }
            int dex2 = x2.indexOf("/");
            b = Integer.parseInt(x2.substring(index2+1,dex2));  //分子
            d = Integer.parseInt(x2.substring(dex2+1,x2.length())); //分母
            if(l2 < 0){
                b = l2*d-b;  //比如 -1'1/3，转换为分数：分子= 1*3-1 = 2，分母为3
            }else{
                b = l2*d+b;  //比如 1'1/3，转换为分数：分子= 1*3+1 = 4，分母为3，结果为 4/3
            }
        }
        equationCreate eq = new equationCreate();  //创建一个对象，用其中的约分方法
        switch (ch) {
            case "+":
                str = eq.Simplify(a * d + c * b, c * d);//例如2/3 + 3/4 = （2*4+3*3）/(3*4) = 17/12
                break;
            case "-":
                str = eq.Simplify(a * d - c * b, c * d);
                break;
            case "*":
                str = eq.Simplify(a * b, c * d);
                break;
            case "÷":
                if (c * b == 0) {
                    str = "无解";
                    break;
                } else {
                    str = eq.Simplify(a * d, c * b);
                }
                break;
        }
        return str;
    }
}

