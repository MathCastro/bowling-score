package com.matheus;

import com.matheus.bowling.input.InputController;
import com.matheus.bowling.input.RollFile;
import com.matheus.bowling.input.file.FileHandler;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileTest {

    @Test
    public void matchFileSize() {
        List<RollFile> rolls;
        InputController inputController = new InputController(new FileHandler("input-files/sample-score.txt"));
        rolls = inputController.read();
        assertEquals(35, rolls.size());

        inputController = new InputController(new FileHandler("input-files/perfect-score.txt"));
        rolls = inputController.read();

        assertEquals(12, rolls.size());
    }
}
