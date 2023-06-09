package com.ps.at.reto2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FizzBuzzTest {

    @Test
    public void returnIfNumIsDivByThree() {
        assertThat(FizzBuzz.fizzBuzz(3), is("Fizz"));
    }

    @Test
    public void returnIfNumIsDivByFive() {
        assertThat(FizzBuzz.fizzBuzz(5), is("Buzz"));
    }

    @Test
    public void returnIfNumIsDivByThreeAndByFive() {
        assertThat(FizzBuzz.fizzBuzz(15), is("FizzBuzz"));
    }

    @Test
    public void returnIfNumIsNotDivByThreeOrFive() {
        assertThat(FizzBuzz.fizzBuzz(14), is("14"));
    }
}