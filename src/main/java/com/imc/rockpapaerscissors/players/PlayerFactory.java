package com.imc.rockpapaerscissors.players;

import com.imc.rockpapaerscissors.exceptions.FatalErrorException;
import com.imc.rockpapaerscissors.io.IOutput;
import com.imc.rockpapaerscissors.io.IUserInput;

import java.util.HashMap;

/**
 * Factory class for creating Singleton IPlayer Classes (Rock / Paper / Scissors)
 */
public class PlayerFactory {

    private static HashMap<String, IPlayer> PLAYERS = initialisePlayers();

    /**
     * Dirty implementation of factory, would be better to use reflection to register classes.
     * @return Set of players to select from.
     */
    private static HashMap<String, IPlayer> initialisePlayers() {
        HashMap<String, IPlayer> players = new HashMap<>();

        IPlayer copyingPlayer = new CopyingPlayer();
        players.put(copyingPlayer.getPlayerCharacter(), copyingPlayer);

        IPlayer basicPlayer = new BasicRandomPlayer();
        players.put(basicPlayer.getPlayerCharacter(), basicPlayer);

        IPlayer reactivePlayer = new ReactivePlayer();
        players.put(reactivePlayer.getPlayerCharacter(), reactivePlayer);

        IPlayer humanPlayer = new HumanPlayer();
        players.put(humanPlayer.getPlayerCharacter(), humanPlayer);

        return players;
    }

    /**
     * Returns a new instance of a Player.
     * @param userInput To get input from the user.
     * @param output To output information to the user in selecting a player.
     * @param playerNumber The number player to select.
     * @param excludeHumanPlayers Indicate if we should exclude human players or not.
     * @return A new Player instance.
     */
    public static IPlayer getPlayer(IUserInput userInput, IOutput output, int playerNumber, boolean excludeHumanPlayers) throws FatalErrorException {

        output.output(String.format("Please select Player %s:", playerNumber));
        if (!excludeHumanPlayers) {
            PLAYERS.forEach((key, value) -> output.output(String.format("Press %s for '%s'", key, value.getName())));
        } else {
            PLAYERS.entrySet().stream().filter(entry -> !(entry.getValue() instanceof HumanPlayer)).forEach(entry ->
                    output.output(String.format("Press %s for '%s'", entry.getKey(), entry.getValue().getName())));
        }

        try {
            return (PLAYERS.get(userInput.getNextValidInputString(PLAYERS.keySet()))).getClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new FatalErrorException("Could not create a new instance based upon reflection.", e);
        }
    }

    /**
     * Private constructor for Singleton Factory.
     */
    private PlayerFactory(){}
}