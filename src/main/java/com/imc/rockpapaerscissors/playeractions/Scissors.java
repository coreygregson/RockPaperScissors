package com.imc.rockpapaerscissors.playeractions;

/**
 * Class for the action of playing Scissors
 */
public class Scissors extends PlayerActionBase  {

    private static final String NAME = "Scissors";
    private static final String WINNING_VERB = "cuts";
    private static final String ACTION_CHARACTER = "S";

    Scissors() {
        super(NAME, WINNING_VERB, ACTION_CHARACTER);
    }

    /**
     * Checks to see if this action beats the opponentPlayerAction.
     * @param opponentPlayerAction Opponent Player Action to test against.
     * @return true if Scissors beats the opponentPlayerAction, else false.
     */
    @Override
    public boolean beats(IPlayerAction opponentPlayerAction) {
        return opponentPlayerAction.equals(PlayerActionFactory.getPaper());
    }
}
