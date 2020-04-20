package com.matheus.bowling.score.domain;

public class Roll {
    private String pinsKnockedDown;
    private RollStatus status;

    public Roll(String pinsKnockedDown) {
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

    public void setPinsKnockedDown(String pinsKnockedDown) {
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
