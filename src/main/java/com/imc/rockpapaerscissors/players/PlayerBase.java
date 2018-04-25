package com.imc.rockpapaerscissors.players;

/**
 * Abstract base class implementing common functionality for Players.
 */
public abstract class PlayerBase implements IPlayer {
    private String name;
    private String playerCharacter;

    /**
     * Base Constructor for handling common Player functionality.
     * @param name The display Name for this Player.
     * @param playerCharacter The character to indicate the use of this Player.
     */
    PlayerBase(String name, String playerCharacter) {
        this.name = name;
        this.playerCharacter = playerCharacter;
    }

    /**
     * Return the character that users can input for this player action.
     * @return The character representing this player action.
     */
    @Override
    public String getPlayerCharacter() {
        return playerCharacter;
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
