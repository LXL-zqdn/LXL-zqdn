package com.lxl.Utils;

import java.io.*;

/**
 * @LXL
 */
public class filesIO {

    /**
     * 读出txt文件，通过文件的路径，找到对应文本，
     * 将文本内容转化为字符串输出
     * @param path 文件的路径
     * @return
     */
    public static String readFile(String path){
        String s = "";
        String s1 ;
        File file = new File(path);
        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bf = new BufferedReader(inputStreamReader);
            while((s1 = bf.readLine()) != null){
                s += s1;//进行字符串的拼接，拼到s中
            }
            inputStreamReader.close();
            bf.close();
            fileInputStream.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return s;
    }


    /**
     * 写入txt文件
     * @param content 文件写入的内容
     * @param path 文件的路径
     */
    public static void writeFile(double content,String path){
        String s = Double.toString(content);
        File file = new File(path);
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(s,0,(s.length() > 3 ? 4:s.length()));
            fileWriter.write("\r\n");
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
