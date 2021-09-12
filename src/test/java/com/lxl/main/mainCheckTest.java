package com.lxl.main;
import com.lxl.Utils.simHash;
import com.lxl.Utils.filesIO;
import org.junit.Test;
import com.lxl.Utils.getHamming;
/**
 * @LXL
 */
public class mainCheckTest {
    @Test
    public void origtxtTest(){
        String s = filesIO.readFile("D:\\Test2\\orig.txt");
        String s1 = filesIO.readFile("D:\\Test2\\orig.txt");
        String finallyFile = "D:\\Test2\\finallyorigFile.txt";
        Double result = getHamming.getCoincidence(simHash.getSimHash(s),simHash.getSimHash(s1));
        filesIO.writeFile(result,finallyFile);
    }
    @Test
    public void addtxtTest(){
        String s = filesIO.readFile("D:\\Test2\\orig.txt");
        String s1 = filesIO.readFile("D:\\Test2\\orig_0.8_add.txt");
        String finallyFile = "D:\\Test2\\finallyaddFile.txt";
        Double result = getHamming.getCoincidence(simHash.getSimHash(s),simHash.getSimHash(s1));
        filesIO.writeFile(result,finallyFile);
    }
    @Test
    public void deltxtTest(){
        String s = filesIO.readFile("D:\\Test2\\orig.txt");
        String s1 = filesIO.readFile("D:\\Test2\\orig_0.8_del.txt");
        String finallyFile = "D:\\Test2\\finallydelFile.txt";
        Double result = getHamming.getCoincidence(simHash.getSimHash(s),simHash.getSimHash(s1));
        filesIO.writeFile(result,finallyFile);
    }
    @Test
    public void dis1txtTest(){
        String s = filesIO.readFile("D:\\Test2\\orig.txt");
        String s1 = filesIO.readFile("D:\\Test2\\orig_0.8_dis_1.txt");
        String finallyFile = "D:\\Test2\\finallydis_1File.txt";
        Double result = getHamming.getCoincidence(simHash.getSimHash(s),simHash.getSimHash(s1));
        filesIO.writeFile(result,finallyFile);
    }
    @Test
    public void dis_10txtTest(){
        String s = filesIO.readFile("D:\\Test2\\orig.txt");
        String s1 = filesIO.readFile("D:\\Test2\\orig_0.8_dis_10.txt");
        String finallyFile = "D:\\Test2\\finallydis_10File.txt";
        Double result = getHamming.getCoincidence(simHash.getSimHash(s),simHash.getSimHash(s1));
        filesIO.writeFile(result,finallyFile);
    }
    @Test
    public void dis_15txtTest(){
        String s = filesIO.readFile("D:\\Test2\\orig.txt");
        String s1 = filesIO.readFile("D:\\Test2\\orig_0.8_dis_15.txt");
        String finallyFile = "D:\\Test2\\finallydis_15File.txt";
        Double result = getHamming.getCoincidence(simHash.getSimHash(s),simHash.getSimHash(s1));
        filesIO.writeFile(result,finallyFile);
    }
    @Test
    public void arrayTest(){
        String[] s = new String[6];
        s[0] = filesIO.readFile("D:\\Test2\\orig.txt");
        s[1]= filesIO.readFile("D:\\Test2\\orig_0.8_add.txt");
        s[2]= filesIO.readFile("D:\\Test2\\orig_0.8_del.txt");
        s[3]= filesIO.readFile("D:\\Test2\\orig_0.8_dis_1.txt");
        s[4] = filesIO.readFile("D:\\Test2\\orig_0.8_dis_10.txt");
        s[5]=  filesIO.readFile("D:\\Test2\\orig_0.8_dis_15.txt");
        String finallyAllTest = "D:\\Test2\\finallyAll.txt";
        for (int i = 0; i < s.length ; i++) {
            double result = getHamming.getCoincidence(simHash.getSimHash(s[0]),simHash.getSimHash(s[i]));
            filesIO.writeFile(result,finallyAllTest);
        }
    }
}
