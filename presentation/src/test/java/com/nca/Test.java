package com.nca;

import junit.framework.Assert;

public class Test {

    @org.junit.Test
    public void test() {

        int a = plus(2,  2);


        Assert.assertEquals(4, a);
    }

    private int plus(int a, int b) {
        return a + b;
    }
}
