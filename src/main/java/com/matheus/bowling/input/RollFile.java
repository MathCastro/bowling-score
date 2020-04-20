package com.matheus.bowling.input;

public class RollFile {
    private String player;
    private String pinsKnockedDown;

    public RollFile(String player, String pinsKnockedDown) {
        this.player = player;
        this.pinsKnockedDown = pinsKnockedDown;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getPinsKnockedDown() {
        return pinsKnockedDown;
    }

    public void setPinsKnockedDown(String pinsKnockedDown) {
        this.pinsKnockedDown = pinsKnockedDown;
    }
}
