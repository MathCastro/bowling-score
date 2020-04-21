package com.matheus;

import com.matheus.bowling.score.domain.Frame;
import com.matheus.bowling.score.domain.FrameStatus;
import com.matheus.bowling.score.domain.Roll;
import com.matheus.bowling.score.domain.RollStatus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FrameTest {
    @Test
    public void frameStatus() {
        Frame frame = new Frame(2, new Roll("10"));
        frame.defStatus();

        assertEquals(FrameStatus.STRIKE, frame.getStatus());

        frame = new Frame(2, new Roll("6"));
        frame.addRoll(new Roll("4"));
        frame.defStatus();

        assertEquals(FrameStatus.SPARE, frame.getStatus());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void frameIndexOutOfBounds() {
        Frame frame = new Frame(2, new Roll("2"));
        frame.addRoll(new Roll("2"));
        frame.addRoll(new Roll("2"));
    }
}
