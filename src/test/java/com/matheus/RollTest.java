package com.matheus;

import com.matheus.bowling.input.InputController;
import com.matheus.bowling.input.RollFile;
import com.matheus.bowling.input.file.FileHandler;
import com.matheus.bowling.score.domain.FrameStatus;
import com.matheus.bowling.score.domain.Roll;
import com.matheus.bowling.score.domain.RollStatus;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RollTest {
    @Test
    public void roll() {
        Roll roll = new Roll("F");

        assertEquals(RollStatus.FAULT, roll.getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void rollIllegalArgument() {
        Roll roll = new Roll("H");
    }

    @Test(expected = IllegalArgumentException.class)
    public void rollIllegalArgument2() {
        Roll roll = new Roll("-5");
    }
}
