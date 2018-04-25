package com.imc.rockpapaerscissors.playeractions;

/**
 * Class for the action of playing Rock
 */
public class Rock extends PlayerActionBase  {

    private static final String NAME = "Rock";
    private static final String WINNING_VERB = "blunts";
    private static final String ACTION_CHARACTER = "R";

    Rock() {
        super(NAME, WINNING_VERB, ACTION_CHARACTER);
    }

    /**
     * Checks to see if this action beats the opponentPlayerAction.
     * @param opponentPlayerAction Opponent Player Action to test against.
     * @return true if Rock beats the opponentPlayerAction, else false.
     */
    @Override
    public boolean beats(IPlayerAction opponentPlayerAction) {
        return opponentPlayerAction.equals(PlayerActionFactory.getScissors());
    }
}
