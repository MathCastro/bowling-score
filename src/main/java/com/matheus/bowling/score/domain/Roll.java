package com.matheus.bowling.score.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Roll {
    private String pinsKnockedDown;
    private RollStatus status;

    public Roll(String pinsKnockedDown) {
        validate(pinsKnockedDown);
        this.pinsKnockedDown = pinsKnockedDown;
        this.defStatus();
    }

    public void defStatus() {
        if(this.pinsKnockedDown.equals("F"))
            this.setStatus(RollStatus.FAULT);
        else
            this.setStatus(RollStatus.NORMAL);
    }

    public String getPinsKnockedDown() {
        return pinsKnockedDown;
    }

    public int getValueOfPins() {
        if (this.status != RollStatus.FAULT)
            return Integer.parseInt(this.pinsKnockedDown);
        else
            return 0;
    }

    public void validate(String pinsKnockedDown) {
        Pattern p = Pattern.compile("[^F0-9]");
        Matcher m = p.matcher(pinsKnockedDown);
        boolean b = m.find();
        if(b)
            throw new IllegalArgumentException("Rolls can only have numbers and F`s");
    }

    public void setPinsKnockedDown(String pinsKnockedDown) {
        validate(pinsKnockedDown);
        this.pinsKnockedDown = pinsKnockedDown;
        this.defStatus();
    }

    public RollStatus getStatus() {
        return status;
    }

    private void setStatus(RollStatus status) {
        this.status = status;
    }
}
