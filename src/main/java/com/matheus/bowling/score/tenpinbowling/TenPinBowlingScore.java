package com.matheus.bowling.score.tenpinbowling;

import com.matheus.bowling.input.RollFile;
import com.matheus.bowling.score.BowlingScore;
import com.matheus.bowling.score.domain.Game;
import com.matheus.bowling.score.domain.Player;
import com.matheus.bowling.score.domain.Roll;

import java.util.List;

public class TenPinBowlingScore implements BowlingScore {

    @Override
    public Game createGame(List<RollFile> rolls) {
        Game game = new Game();
        Player player;
        for (RollFile fileRoll: rolls) {
            Roll roll = new Roll(fileRoll.getPinsKnockedDown());
            if(game.playerExist(fileRoll.getPlayer())) {
                player = game.getPlayer(fileRoll.getPlayer());
                player.addRoll(roll);
            } else {
                player = new Player(fileRoll.getPlayer());
                player.addRoll(roll);
                game.addPlayer(player);
            }
        }
        return game;
    }

    @Override
    public Game calculateScore(Game game) {
        Player player;

        for (String playerName: game.getPlayers().keySet()) {
            player = game.getPlayer(playerName);
            player.calculateScore();
        }
        return game;
    }
}
