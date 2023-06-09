package com.ps.at.player;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void playersLoseWhenNumberIsTooLow() {

        //Dice dice = new Dice(6);
        Dice dice = Mockito.mock(Dice.class);

        Mockito.when(dice.roll()).thenReturn(2);
        Player player = new Player(dice, 4);
        //assertEquals(false, player.play());
        assertFalse(player.play());
    }

    @Test
    public void playersWinWhenNumberIsEqualOrHigher() {

        Dice dice = Mockito.mock(Dice.class);

        Mockito.when(dice.roll()).thenReturn(4);
        Player player = new Player(dice, 4);
        assertEquals(true, player.play());
    }
}