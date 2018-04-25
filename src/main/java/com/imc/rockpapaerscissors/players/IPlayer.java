package com.imc.rockpapaerscissors.players;

import com.imc.rockpapaerscissors.playeractions.IPlayerAction;

/**
 * Methods to define the core player functionality.
 */
public interface IPlayer {

    /**
     * Return the next action for this player.
     * @return The {@link IPlayerAction}
     */
    IPlayerAction getNextPlayerAction();

    /**
     * Get the name of this player.
     * @return The name of this player.
     */
    String getName();

    /**
     * Get the character to select this player.
     * @return The character used to select this player.
     */
    String getPlayerCharacter();
}