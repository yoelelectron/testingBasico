package com.ps.at.reto2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RomanConverterTest {

    @Test
    public void shouldConvertArabicToRoman() {
        assertThat(RomanConverter.arabicToRoman(2507), is("MMDVII"));
    }
}