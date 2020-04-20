package com.matheus.bowling.score;

import com.matheus.bowling.input.RollFile;
import com.matheus.bowling.score.domain.Game;

import java.util.List;

public interface BowlingScore {
    Game createGame(List<RollFile> rolls);

    Game calculateScore(Game game);
}
