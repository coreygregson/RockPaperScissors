package com.imc.rockpapaerscissors.playeractions;

/**
 * Abstract base class implementing common functionality for Player Actions.
 */
public abstract class PlayerActionBase implements  IPlayerAction{
    private String name;
    private String winningVerb;
    private String actionCharacter;

    /**
     * Base Constructor for handling common Player Action information.
     * @param name The display Name for this Player Action.
     * @param winningVerb The winning verb for this Player Action
     * @param actionCharacter The character to indicate the use of this Player Action.
     */
    PlayerActionBase(String name, String winningVerb, String actionCharacter) {
        this.name = name;
        this.winningVerb = winningVerb;
        this.actionCharacter = actionCharacter;
    }

    /**
     * Return the word to describe the winning action.
     * @return The word describing the winning action.
     */
    @Override
    public String getWinningVerb() {
        return winningVerb;
    }

    /**
     * Return the character that users can input for this player action.
     * @return The character representing this player action.
     */
    @Override
    public String getActionCharacter() {
        return actionCharacter;
    }

    /**
     * Return the Name of the Player Action for display.
     * @return Player Action Name.
     */
    @Override
    public String getName() {
        return name;
    }
}
