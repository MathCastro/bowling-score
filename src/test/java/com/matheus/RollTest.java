package com.matheus;

import com.matheus.bowling.score.domain.Roll;
import com.matheus.bowling.score.domain.RollStatus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RollTest {
    @Test
    public void roll() {
        Roll roll = new Roll("F");

        assertEquals(RollStatus.FAULT, roll.getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void rollIllegalArgument() {
        new Roll("H");
    }

    @Test(expected = IllegalArgumentException.class)
    public void rollIllegalArgument2() {
        new Roll("-5");
    }
}
