package com.matheus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.matheus.bowling.input.InputController;
import com.matheus.bowling.input.RollFile;
import com.matheus.bowling.score.BowlingScore;
import com.matheus.bowling.score.ScoreController;
import com.matheus.bowling.score.domain.Game;
import com.matheus.bowling.score.tenpinbowling.TenPinBowlingScore;
import com.matheus.bowling.input.file.FileHandler;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void matchScoreFile() {
        Game game;
        List<RollFile> rollsFromFile;

        InputController inputController = new InputController(new FileHandler("input-files/sample-score.txt"));
        rollsFromFile = inputController.read();

        BowlingScore bowlingScore = new ScoreController(new TenPinBowlingScore());
        game = bowlingScore.createGame(rollsFromFile);

        game = bowlingScore.calculateScore(game);

        assertEquals(167, game.getPlayer("Jeff").getScore());
        assertEquals(151, game.getPlayer("John").getScore());
    }

    @Test
    public void matchScorePerfectScore() {
        Game game;
        List<RollFile> rollsFromFile;

        InputController inputController = new InputController(new FileHandler("input-files/perfect-score.txt"));
        rollsFromFile = inputController.read();

        BowlingScore bowlingScore = new ScoreController(new TenPinBowlingScore());
        game = bowlingScore.createGame(rollsFromFile);

        game = bowlingScore.calculateScore(game);

        assertEquals(300, game.getPlayer("Carl").getScore());
    }

    @Test
    public void matchScoreZeroScore() {
        Game game;
        List<RollFile> rollsFromFile;

        InputController inputController = new InputController(new FileHandler("input-files/zero-score.txt"));
        rollsFromFile = inputController.read();

        BowlingScore bowlingScore = new ScoreController(new TenPinBowlingScore());
        game = bowlingScore.createGame(rollsFromFile);

        game = bowlingScore.calculateScore(game);

        assertEquals(0, game.getPlayer("Jean").getScore());
    }

}
