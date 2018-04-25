package com.imc.rockpapaerscissors.players;

import com.imc.rockpapaerscissors.playeractions.IPlayerAction;

/**
 * Implementation of a basic Random Player, 33% chance for each action.
 */
public class BasicRandomPlayer extends PlayerBase {

    private static final String NAME = "Basic Bob";
    private static final String PLAYER_CHARACTER = "B";

    BasicRandomPlayer() {
        super(NAME, PLAYER_CHARACTER);
    }

    /**
     * Returns this players next action.
     * @return The action this player plays next.
     */
    @Override
    public IPlayerAction getNextPlayerAction() {
        return PlayerActionHelper.getRandomPlayerAction();
    }
}
