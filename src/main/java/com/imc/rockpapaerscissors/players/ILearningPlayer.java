package com.imc.rockpapaerscissors.players;

import com.imc.rockpapaerscissors.playeractions.IPlayerAction;

/**
 * Methods to allow players to learn from opponents previous moves
 */
public interface ILearningPlayer {

    /**
     * Set the last action which the opponent played.
     * @param lastOpponentPlayerAction The opponents last action.
     */
    void setOpponentsLastAction(IPlayerAction lastOpponentPlayerAction);
}
