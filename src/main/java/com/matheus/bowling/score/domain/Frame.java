package com.matheus.bowling.score.domain;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private int score;
    private int number;
    private List<Roll> rolls;
    private FrameStatus status;

    public Frame(int number) {
        this.number = number;
        this.rolls = new ArrayList<>();
    }

    public Frame(int number, Roll roll) {
        this.number = number;
        this.rolls = new ArrayList<>();
        this.rolls.add(roll);
    }

    public Frame(int score, int number, List<Roll> rolls) {
        validateRolls(number, rolls.size());
        this.score = score;
        this.number = number;
        this.rolls = rolls;
    }

    public void addRoll(Roll roll) {
        validateRolls(this.number, this.rolls.size() + 1);
        this.rolls.add(roll);
    }

    public void validateRolls(int number, int rollsSize) {
        if(number != 10 && rollsSize > 2)
            throw new IndexOutOfBoundsException("Frame supports only two rolls");
        else if(number == 10 && rollsSize > 3)
            throw new IndexOutOfBoundsException("Last frame supports only three rolls");
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Roll> getRolls() {
        return rolls;
    }

    public void setRolls(List<Roll> rolls) {
        this.rolls = rolls;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public FrameStatus getStatus() {
        return status;
    }

    public void setStatus(FrameStatus status) {
        this.status = status;
    }

    public void defStatus() {
        if (this.number == 10) {
            setStatus(FrameStatus.LAST);
        } else {
            if (this.sumPins() == 10) {
                if (this.rolls.size() == 2)
                    setStatus(FrameStatus.SPARE);
                else
                    setStatus(FrameStatus.STRIKE);
            } else {
                setStatus(FrameStatus.NORMAL);
            }
        }
    }

    public int sumPins() {
        int sum = 0;
        for (Roll roll:
             this.rolls) {
            sum += roll.getValueOfPins();
        }
        return sum;
    }

    public boolean isFull() {
        return ((this.number != 10 && (this.rolls.size() == 2 || this.sumPins() >= 10)) || (this.number == 10 && this.rolls.size() == 3));
    }
}
