package com.ps.at.util;

//import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void stringRepeatTest() {

        String result = StringUtil.repeat("hola", 3);
        Assert.assertEquals("holaholahola", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void stringRepeatNegativeTimesTest(){
        StringUtil.repeat("hola",-1);
    }

    @Test
    public void stringEmptyNotNull(){
        Assert.assertFalse(StringUtil.isEmpty("hola"));
    }

    @Test
    public void stringEmptyNonCharacter(){
        Assert.assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void stringEmptyNullCheck(){
        Assert.assertTrue(StringUtil.isEmpty(null));
    }

}