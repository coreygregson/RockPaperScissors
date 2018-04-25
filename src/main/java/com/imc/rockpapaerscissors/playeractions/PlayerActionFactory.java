package com.imc.rockpapaerscissors.playeractions;

/**
 * Factory class for returning Singleton IPlayerAction Concrete Classes (Rock / Paper / Scissors)
 */
public class PlayerActionFactory {

    private static final IPlayerAction ROCK = new Rock();
    private static final IPlayerAction PAPER = new Paper();
    private static final IPlayerAction SCISSORS = new Scissors();

    /**
     * Returns the Player Action for this actionCharacter
     * @param actionCharacter The character to represent this IPlayerAction
     * @return The IPlayerAction
     */
    public static IPlayerAction getIPlayerAction(String actionCharacter)
    {
        if(ROCK.getActionCharacter().equalsIgnoreCase(actionCharacter)) {
            return ROCK;
        }

        if(PAPER.getActionCharacter().equalsIgnoreCase(actionCharacter)) {
            return PAPER;
        }

        if(SCISSORS.getActionCharacter().equalsIgnoreCase(actionCharacter)) {
            return SCISSORS;
        }

        return null;
    }

    /**
     * Get the global instance of Rock
     * @return Rock
     */
    public static IPlayerAction getRock() {
        return ROCK;
    }

    /**
     * Get the global instance of Paper
     * @return Paper
     */
    public static IPlayerAction getPaper() {
        return PAPER;
    }

    /**
     * Get the global instance of Scissors
     * @return Scissors
     */
    public static IPlayerAction getScissors() {
        return SCISSORS;
    }

    /**
     * Private constructor for singleton.
     */
    private PlayerActionFactory (){}
}