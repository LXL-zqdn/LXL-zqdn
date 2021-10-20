package com.lxl.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @LXL
 */
public class checkDuplicate {
    List<String> equation = new ArrayList<String>();
    List<String> answer = new ArrayList<String>();

    /**
     * 比较答案文件中是否有相同的答案，有则再比较题目是否相同
     * @return 返回重复的题目和序号
     */
    public List compareAnswer(){
        File file = new File("Exercises.txt");
        File file1 = new File("Answers.txt");
        List<String> repeat = new ArrayList<String>();//用于存放重复表达式的集合

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str = null;
            while((str = br.readLine()) != null){
                str = str.substring(str.indexOf(":")+1,str.length());
                equation.add(str);//将冒号后的题目存放在集合中，方便后面写重复题目时按索引取出
            }
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            String str1 = null;
            while((str1 = br1.readLine()) != null){
                str1 = str1.substring(str1.indexOf(":")+1,str1.length());
                answer.add(str1);//将冒号后的答案存放在集合中，方便后面比较答案是否相同
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        for (int i = 0; i < answer.size()-1 ; i++) {
            String str = "";
            for (int j = i+1 ; j< answer.size();j++){
                if(answer.get(i).equals(answer.get(j))){
                    if(checkEquation(equation.get(i),equation.get(j))){
                        str += (i+1)+","+equation.get(i)+"repeat"+(j+1)+","+equation.get(j)+" ";
                    }
                }
            }
            if(str.length()>0){
                repeat.add(str);
            }
        }
        return repeat;
    }

    /**
     * 比较两后缀表达式是否相同
     * @param equ1 表达式1
     * @param equ2 表达式2
     * @return 返回判断值
     */
    public boolean checkEquation(String equ1,String equ2){
        becomeSuffix suffix = new becomeSuffix();
        equ1 = suffix.becomeSuffix(equ1);
        equ2 = suffix.becomeSuffix(equ2);
        String[] strings = equ1.split(" ");//比较两后缀表达式是否相同
        for (int i = 0; i < strings.length ; i++) {
            if(equ2.indexOf(strings[i] )==-1){
                return false;
                //只查看是否出现此数字或符号，有局限性，但前面答案相同，表达式出现的每个数字或符号都有的概率比较小
            }
        }
        return true;
    }
}
