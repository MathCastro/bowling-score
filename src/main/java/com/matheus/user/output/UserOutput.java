package com.matheus.user.output;

import com.matheus.bowling.score.domain.Game;

public interface UserOutput {
    void readFileNameMessage();

    void printResult(Game game);
}
