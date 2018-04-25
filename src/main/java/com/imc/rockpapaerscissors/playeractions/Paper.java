package com.imc.rockpapaerscissors.playeractions;

/**
 * Class for the action of playing Paper 
 */
public class Paper extends PlayerActionBase  {

    private static final String NAME = "Paper";
    private static final String WINNING_VERB = "wraps";
    private static final String ACTION_CHARACTER = "P";

    /**
     * Constructor.
     */
    Paper() {
        super(NAME, WINNING_VERB, ACTION_CHARACTER);
    }

    /**
     * Checks to see if this action beats the opponentPlayerAction.
     * @param opponentPlayerAction Opponent Player Action to test against.
     * @return true if Paper beats the opponentPlayerAction, else false.
     */
    @Override
    public boolean beats(IPlayerAction opponentPlayerAction) {
        return opponentPlayerAction.equals(PlayerActionFactory.getRock());
    }
}
