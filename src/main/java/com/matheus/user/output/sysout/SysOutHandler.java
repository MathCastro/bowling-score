package com.matheus.user.output.sysout;

import com.matheus.bowling.score.domain.Frame;
import com.matheus.bowling.score.domain.Game;
import com.matheus.bowling.score.domain.Player;
import com.matheus.bowling.score.domain.Roll;
import com.matheus.user.output.UserOutput;

public class SysOutHandler implements UserOutput {
    @Override
    public void readFileNameMessage() {
        System.out.println("Write the name of the file:");
    }

    @Override
    public void printResult(Game game) {
        Player player;

        for (String playerName: game.getPlayers().keySet()) {
            player = game.getPlayer(playerName);
            this.handlePrint(player);
        }

    }

    private void handlePrint(Player player) {
        int score = 0;

        System.out.print("Frame");
        for(int i = 1; i <= 10; i++) {
            printWithSpaces(7, Integer.toString(i));
        }
        System.out.println();
        System.out.println(player.getName());
        System.out.print("Pinfalls");
        for(Frame frame: player.getFrames()) {
            switch (frame.getStatus()){
                case NORMAL:
                    for (Roll roll: frame.getRolls()) {
                        printWithSpaces(3, roll.getPinsKnockedDown());
                    }
                    break;
                case SPARE:
                    printWithSpaces(3, frame.getRolls().get(0).getPinsKnockedDown());
                    printWithSpaces(3, "/");
                    break;
                case STRIKE:
                    printWithSpaces(6, "X");

                    break;
                case LAST:
                    if(frame.getRolls().get(0).getValueOfPins() == 10) {
                        for (Roll roll: frame.getRolls()) {
                            if(roll.getValueOfPins() == 10) {
                                printWithSpaces(3, "X");

                            } else {
                                printWithSpaces(3, roll.getPinsKnockedDown());
                            }
                        }
                    } else if (frame.getRolls().get(0).getValueOfPins() + frame.getRolls().get(1).getValueOfPins() == 10) {
                        printWithSpaces(3, frame.getRolls().get(0).getPinsKnockedDown());
                        printWithSpaces(3, "/");

                        if(frame.getRolls().get(2).getValueOfPins() == 10) {
                            printWithSpaces(3, "X");
                        }
                    } else {
                        for (Roll roll: frame.getRolls()) {
                            if(roll.getValueOfPins() == 10) {
                                printWithSpaces(3, "X");
                            } else {
                                printWithSpaces(3, roll.getPinsKnockedDown());
                            }
                        }
                    }
            }
        }
        System.out.println();
        System.out.print("Score");
        for(Frame frame: player.getFrames()) {
            score += frame.getScore();
            if (score < 100) {
                printWithSpaces(6, Integer.toString(score));
            } else {
                printWithSpaces(5, Integer.toString(score));
            }
        }
        System.out.println();
        System.out.println();
    }

    private void printWithSpaces(int spaces, String content) {
        for (int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        System.out.print(content);
    }

}
