package com.lxl.Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @LXL
 */
public class filesIO {
    //文件写入方法
    public void writeFile(File file,String s){
        try{
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(s);
            bw.flush();
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void CWfiles(File file1,File file2,File Grade){
        List<String> correct = new ArrayList<String>();
        List<String> wrong = new ArrayList<String>();
        try{
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            int i = 1;
            String str = null;
            while((str = br1.readLine()) != null){
                if(str.equals(br2.readLine())){
                    correct.add(Integer.toString(i));//比较两文件，相等则将正确的题目序号加入集合
                }else{                               //错误则将错误的题目序号加入集合
                    wrong.add(Integer.toString(i));
                }
                i++;
            }
            //将正确集合的元素写入文件
            this.writeFile(Grade,"Correct:"+correct.size()+"(");
            for (int j = 0; j < correct.size(); j++) {
                if(j == correct.size()-1){
                    this.writeFile(Grade,correct.get(j));
                }else{
                    this.writeFile(Grade,correct.get(j)+",");
                }
            }
            this.writeFile(Grade,")"+"\r\n");

            //将错误集合的元素写入文件
            this.writeFile(Grade,"Wrong:"+wrong.size()+"(");
            for (int j = 0; j < wrong.size(); j++) {
                if(j == wrong.size()-1){
                    this.writeFile(Grade,wrong.get(j));
                }else{
                    this.writeFile(Grade,wrong.get(j)+",");
                }
            }
            this.writeFile(Grade,")"+"\r\n");

            //将重复的数目及对应题目和序号写入文件
            checkDuplicate cd = new checkDuplicate();
            List<String> repeat = new ArrayList<String>();
            repeat = cd.compareAnswer();
            this.writeFile(Grade,"repeat:"+repeat.size()+"\r\n");
            this.writeFile(Grade,"repeatDetail:"+"\r\n");
            for (int j = 1; j <= repeat.size() ; j++) {
                this.writeFile(Grade,"("+j+")"+repeat.get(j-1)+"\r\n");
            }
            br1.close();
            br2.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
