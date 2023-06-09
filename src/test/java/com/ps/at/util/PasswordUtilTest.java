package com.ps.at.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void weakWhenHasLessThanEightChar() {
        assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.accessPassword("123456"));
    }

    @Test
    public void weakWhenHasOnlyLetters() {
        assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.accessPassword("abcdgdfjjeuh"));
    }

    @Test
    public void mediumWhenHasLettersAndNumbersAndAtLeastEightChar() {
        assertEquals(PasswordUtil.SecurityLevel.MEDIUM, PasswordUtil.accessPassword("123456abc"));
    }

    @Test
    public void strongWhenHasLettersAndNumbersAndSymbols() {
        assertEquals(PasswordUtil.SecurityLevel.STRONG, PasswordUtil.accessPassword("123456abc@"));
    }
}