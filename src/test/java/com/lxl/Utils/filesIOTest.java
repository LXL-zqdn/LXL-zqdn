package com.lxl.Utils;

import org.junit.Test;

/**
 * @LXL
 */
public class filesIOTest {
    @Test
    public void readFileTest(){
        String s = filesIO.readFile("D:\\Test2\\orig.txt");
        String[] strings = s.split(" ");
        for(String str : strings){
            System.out.println(str);
        }//测试路径正常，读取
    }
    @Test
    public void readFileFalse(){
        String s = filesIO.readFile("D:\\Test2\\none.txt");
    }  //读取路径失败
    @Test
    public void writeFileTest(){
        double[] testData = {0.32,0.42,0.12,0.23,0.45};
        for (int i = 0; i < testData.length ; i++) {
            filesIO.writeFile(testData[i],"D:\\Test2\\finally.txt");
        }  //测试路径存在，写入
    }
    @Test
    public void writeFileFalse(){
        double[] testData = {0.32,0.42,0.12,0.23,0.45};
        for (int i = 0; i < testData.length ; i++) {
            filesIO.writeFile(testData[i],"C:\\Users\\86135\\finally.txt");
        }  //测试路径错误，写入失败
    }

}
