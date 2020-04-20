package com.matheus.bowling.score;

import com.matheus.bowling.input.RollFile;
import com.matheus.bowling.score.domain.Game;

import java.util.List;

public class ScoreController implements BowlingScore {

    BowlingScore bowlingScore;

    public ScoreController(BowlingScore bowlingScore) {
        this.bowlingScore = bowlingScore;
    }


    @Override
    public Game createGame(List<RollFile> rolls) {
        return this.bowlingScore.createGame(rolls);
    }

    @Override
    public Game calculateScore(Game game) {
        return this.bowlingScore.calculateScore(game);
    }
}
