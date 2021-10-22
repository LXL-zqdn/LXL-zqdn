package com.lxl.Utils;

import org.junit.Test;

/**
 * @LXL
 */
public class equationCreateTest {
    @Test
    public void equationsTest(){
        equationCreate ec = new equationCreate();
        int m = 10;
        int n=10;
        String s1 = ec.equations(n,m);
        String s2 = ec.equations(n,m);
        String s3 = ec.equations(n,m);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
    @Test
    public void numberCreateTest(){
        equationCreate ec = new equationCreate();
        int m=10;
        String s1 = ec.numberCreate(m);
        String s2 = ec.numberCreate(m);
        System.out.println(s1);
        System.out.println(s2);
    }
    @Test
    public void SimplifyTest(){
        equationCreate ec = new equationCreate();
        int a = 24;
        int b = 16;
        String s = ec.Simplify(a,b);
        System.out.println(s);
    }
    @Test
    public void symbolCreateTest(){
        equationCreate ec = new equationCreate();
        System.out.println(ec.symbolCreate());
        System.out.println(ec.symbolCreate());
        System.out.println(ec.symbolCreate());
    }
    @Test
    public void bracketTest(){
        equationCreate ec = new equationCreate();
        System.out.println(ec.bracket());
        System.out.println(ec.bracket());
    }
}
