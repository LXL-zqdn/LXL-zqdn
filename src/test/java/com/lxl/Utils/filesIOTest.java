package com.lxl.Utils;

import org.junit.Test;

import java.io.File;

/**
 * @LXL
 */
public class filesIOTest {
    @Test
    public void writeFileTest(){
        String s = "aaaaaaaaaaa";
        String s1 = "bbbbbbbbbb";
        filesIO io = new filesIO();
        File f1 = new File("iotest.txt");
        io.writeFile(f1,s);
        io.writeFile(f1,"\n");
        io.writeFile(f1,s1);
    }
}
