package com.matheus.user.output;

import com.matheus.bowling.score.domain.Game;

public class UserOutputController implements UserOutput{

    UserOutput userOutput;

    public UserOutputController(UserOutput userOutput) {
        this.userOutput = userOutput;
    }

    @Override
    public void readFileNameMessage () {
        this.userOutput.readFileNameMessage();
    }

    @Override
    public void printResult(Game game) {
        this.userOutput.printResult(game);
    }
}
