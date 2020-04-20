package com.matheus.bowling.score.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int score;
    private List<Frame> frames;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.frames = new ArrayList<>();
    }

    public Player(String name, int score, List<Frame> frames) {
        validate(frames.size());
        this.name = name;
        this.score = score;
        this.frames = frames;
    }

    public void addFrame(Frame frame) {
        validate(this.frames.size() + 1);
        frames.add(frame);
    }

    public void addRoll(Roll roll) {
        if (!frames.isEmpty()) {
            Frame frame = frames.get(frames.size()-1);
            if(frame.isFull()) {
                frame.defStatus();
                Frame newFrame = new Frame(frames.size() + 1, roll);
                this.addFrame(newFrame);
            } else {
                frame.defStatus();
                frame.addRoll(roll);
            }
        } else {
            Frame frame = new Frame(1, roll);
            this.addFrame(frame);
        }
    }

    public void calculateScore() {
        int i;
        Frame frame;
        int scoreAux = 0;
        for(i = 0; i < this.frames.size(); i++) {
            frame = this.frames.get(i);
            switch (frame.getStatus()) {
                case NORMAL:
                    frame.setScore(frame.sumPins());
                    this.score += frame.sumPins();
                    break;
                case SPARE:
                    scoreAux = frame.sumPins() + this.frames.get(i+1).getRolls().get(0).getValueOfPins();
                    frame.setScore(scoreAux);
                    this.score += scoreAux;
                    break;
                case STRIKE:
                    scoreAux = frame.sumPins() + this.frames.get(i+1).sumPins();
                    frame.setScore(scoreAux);
                    this.score += scoreAux;
                    break;
            }
        }
    }

    public void validate(int framesSize) {
        if(framesSize > 10)
            throw new IndexOutOfBoundsException("Player has only ten frames");
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Frame> getFrames() {
        return frames;
    }

    public void setFrames(List<Frame> frames) {
        this.frames = frames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
