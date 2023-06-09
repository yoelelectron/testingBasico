package com.ps.at.discounts;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PriceCalculatorShould {

    @Test
    public void totalZeroWhenThereArePrices() {
        PriceCalculator pc = new PriceCalculator();
        assertThat( pc.getTotal(), is(0.0));
    }

    @Test
    public void totalIsTheSumOfProces() {
        PriceCalculator pc = new PriceCalculator();
        pc.addPrice(10.0);
        pc.addPrice(12.2);
        assertThat( pc.getTotal(), is(22.2));
    }

    @Test
    public void applyDiscountToPrices() {
        PriceCalculator pc = new PriceCalculator();
        pc.addPrice(10.8);
        pc.addPrice(19.2);
        pc.setDiscount(20);
        assertThat( pc.getTotal(), is(24.0));
    }
}