package com.matheus.bowling.score.domain;

import java.util.HashMap;

public class Game {
    private HashMap<String, Player> players;

    public Game() {
        this.players = new HashMap<>();
    }

    public Game(HashMap player) {
        this.players = player;
    }

    public void addPlayer(Player player) {
        this.players.put(player.getName(), player);
    }

    public Player getPlayer(String name) {
        return players.get(name);
    }

    public boolean playerExist(String name) {
        return this.players.containsKey(name);
    }

    public HashMap<String, Player> getPlayers() {
        return players;
    }

    public void setPlayers(HashMap<String, Player> players2) {
        this.players = players;
    }
}
