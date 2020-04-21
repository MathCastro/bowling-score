package com.matheus;

import com.matheus.bowling.score.domain.Frame;
import com.matheus.bowling.score.domain.FrameStatus;
import com.matheus.bowling.score.domain.Player;
import com.matheus.bowling.score.domain.Roll;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void calculateScore() {
        List<Frame> frames = new ArrayList<>();

        Frame frame = new Frame(2, new Roll("2"));
        frame.addRoll(new Roll("2"));
        frame.defStatus();

        for (int i = 0; i < 10; i++) {
            frames.add(frame);
        }

        Player player = new Player("John", 35, frames);
        player.calculateScore();

        assertEquals(75, player.getScore());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void playerIndexOutOfBounds() {
        List<Frame> frames = new ArrayList<>();

        Frame frame = new Frame(2, new Roll("2"));
        frame.addRoll(new Roll("2"));

        for (int i = 0; i < 15; i++) {
            frames.add(frame);
        }

        new Player("John", 35, frames);
    }
}
