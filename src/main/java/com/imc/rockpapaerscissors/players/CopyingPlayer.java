package com.imc.rockpapaerscissors.players;

import com.imc.rockpapaerscissors.playeractions.IPlayerAction;

/**
 * Player which copies it's opponents last move.
 */
public class CopyingPlayer extends PlayerBase implements ILearningPlayer {

    private static final String NAME = "Copying Cathy";
    private static final String PLAYER_CHARACTER = "C";
    private IPlayerAction lastOpponentPlayerAction = null;

    CopyingPlayer() {
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
            return lastOpponentPlayerAction;
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
