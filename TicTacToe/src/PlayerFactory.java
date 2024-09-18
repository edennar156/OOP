public class PlayerFactory {
    Player buildPlayer(String playerName) {
        switch (playerName) {
            case "human":
                return new HumanPlayer();
            case "clever":
                return new CleverPlayer();
            case "whatever":
                return new WhateverPlayer();
            default:
                return null;
        }
    }
}
