package com.matheus;

import com.matheus.bowling.input.InputController;
import com.matheus.bowling.input.RollFile;
import com.matheus.bowling.score.BowlingScore;
import com.matheus.bowling.score.ScoreController;
import com.matheus.bowling.score.domain.Game;
import com.matheus.bowling.score.tenpinbowling.TenPinBowlingScore;
import com.matheus.user.input.UserInput;
import com.matheus.user.input.UserInputController;
import com.matheus.user.input.scanner.ScannerHandler;
import com.matheus.bowling.input.file.FileHandler;
import com.matheus.user.output.sysout.SysOutHandler;

import java.io.IOException;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws IOException {
        Game game;
        List<RollFile> rollsFromFile;

        UserInput input = new UserInputController(new ScannerHandler(), new SysOutHandler());

        InputController inputController = new InputController(new FileHandler(input.readFileName()));
        rollsFromFile = inputController.read();

        BowlingScore bowlingScore = new ScoreController(new TenPinBowlingScore());
        game = bowlingScore.createGame(rollsFromFile);

        bowlingScore.calculateScore(game);
    }
}
