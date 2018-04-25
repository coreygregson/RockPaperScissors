package com.imc.rockpapaerscissors.players;

import com.imc.rockpapaerscissors.playeractions.IPlayerAction;

/**
 * Player which plays actions which beat it's opponent's last move.
 */
public class ReactivePlayer extends PlayerBase implements ILearningPlayer {

    private static final String NAME = "Reactive Rolf";
    private static final String PLAYER_CHARACTER = "R";
    private IPlayerAction lastOpponentPlayerAction = null;

    ReactivePlayer() {
        super(NAME, PLAYER_CHARACTER);
    }

    /**
     * Returns this players next action.
     * @return The action this player plays next.
     */
    @Override
    public IPlayerAction getNextPlayerAction() {

        if(lastOpponentPlayerAction == null) {
            return PlayerActionHelper.getRandomPlayerAction();
        } else {
            return PlayerActionHelper.getPlayerActionWhichBeats(lastOpponentPlayerAction);
        }
    }

    /**
     * Set the last action which the opponent played.
     * @param lastOpponentPlayerAction The opponents last action.
     */
    @Override
    public void setOpponentsLastAction(IPlayerAction lastOpponentPlayerAction) {
        this.lastOpponentPlayerAction = lastOpponentPlayerAction;
    }
}