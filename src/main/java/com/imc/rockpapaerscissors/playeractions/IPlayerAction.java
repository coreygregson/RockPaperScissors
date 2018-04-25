package com.imc.rockpapaerscissors.playeractions;

/**
 * Interface for Player Action logic.
 */
public interface IPlayerAction {
    /**
     * Return the Name of the Player Action for display.
     * @return Player Action Name.
     */
    String getName();

    /**
     * Return the character that users can input for this player action.
     * @return The character representing this player action.
     */
    String getActionCharacter();

    /**
     * Indicate if this player action beats the opponentPlayerAction.
     * @param opponentPlayerAction Player action to check if we beat.
     * @return true if we win, else false.
     */
    boolean beats(IPlayerAction opponentPlayerAction);

    /**
     * Return the word to describe the winning action.
     * @return The word describing the winning action.
     */
    String getWinningVerb();
}
