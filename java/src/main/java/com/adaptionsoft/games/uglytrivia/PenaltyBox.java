package com.adaptionsoft.games.uglytrivia;

import java.util.HashMap;
import java.util.Map;

public class PenaltyBox {
    private boolean playerStatus;

    Map<Integer, Boolean> players = new HashMap<>();

    public boolean containsPlayer(int player) {
        return players.getOrDefault(player, false);
    }

    public void putPlayer(int player) {
        players.put(player,true);
    }
}
