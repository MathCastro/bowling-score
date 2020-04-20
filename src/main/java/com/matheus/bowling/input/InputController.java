package com.matheus.bowling.input;

import java.util.List;

public class InputController implements BowlingInput {
    private BowlingInput bowlingInput;

    public InputController(BowlingInput bowlingInput) {
        this.bowlingInput = bowlingInput;
    }

    public List<RollFile> read() {
        return this.bowlingInput.read();
    }

    public void write() {
        this.bowlingInput.write();
    }
}
