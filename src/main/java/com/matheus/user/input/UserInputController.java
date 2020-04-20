package com.matheus.user.input;

import com.matheus.user.output.UserOutput;
import com.matheus.user.output.UserOutputController;

public class UserInputController implements UserInput{

    UserInput input;

    UserOutputController userOutputController;

    public UserInputController(UserInput input, UserOutput userOutput) {
        this.input = input;
        this.userOutputController = new UserOutputController(userOutput);
    }

    @Override
    public String readFileName() {
        userOutputController.readFileNameMessage();
        return this.input.readFileName();
    }
}
