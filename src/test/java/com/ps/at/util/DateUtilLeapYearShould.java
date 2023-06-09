package com.ps.at.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class DateUtilLeapYearShould {

    @Test
    public void returnTrueWhenYearIsDivisibleBy400 () {
        assertThat( DateUtil.isLeapYear(1600), is(true));
        assertThat( DateUtil.isLeapYear(1600), is(true));
        assertThat( DateUtil.isLeapYear(1600), is(true));
    }

    @Test
    public void returnFalseWhenYearIsDivisibleBy100ButNot400() {
        assertThat( DateUtil.isLeapYear(1700), is(false));
        assertThat( DateUtil.isLeapYear(1800), is(false));
        assertThat( DateUtil.isLeapYear(1900), is(false));
    }

    @Test
    public void returnTrueWhenYearIsDivisibleByFourButNot100() {
        assertThat( DateUtil.isLeapYear(1996), is(true));
        assertThat( DateUtil.isLeapYear(2004), is(true));
        assertThat( DateUtil.isLeapYear(2008), is(true));
    }

    @Test
    public void returnFalseWhenYearIsNotDivisibleByFour() {
        assertThat( DateUtil.isLeapYear(2017), is(false));
        assertThat( DateUtil.isLeapYear(2019), is(false));
        assertThat( DateUtil.isLeapYear(2018), is(false));
    }
}