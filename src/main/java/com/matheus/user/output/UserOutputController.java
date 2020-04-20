package com.matheus.user.output;

public class UserOutputController implements UserOutput{

    UserOutput userOutput;

    public UserOutputController(UserOutput userOutput) {
        this.userOutput = userOutput;
    }

    @Override
    public void readFileNameMessage () {
        this.userOutput.readFileNameMessage();
    }
}
