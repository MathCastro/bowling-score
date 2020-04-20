package com.matheus.bowling.input;

import java.util.List;

public interface BowlingInput {
    List<RollFile> read();
    void write();
}
