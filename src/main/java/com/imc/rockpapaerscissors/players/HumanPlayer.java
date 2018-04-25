package com.imc.rockpapaerscissors.players;

import com.imc.rockpapaerscissors.io.IOutput;
import com.imc.rockpapaerscissors.io.IUserInput;
import com.imc.rockpapaerscissors.playeractions.IPlayerAction;
import com.imc.rockpapaerscissors.playeractions.PlayerActionFactory;

import java.util.HashSet;

/**
 * Class for a Human player to play Rock, Paper, Scissors
 */
public class HumanPlayer extends PlayerBase {

    private static final String PLAYER_CHARACTER = "H";
    private static final String NAME = "Human Player";
    private static final HashSet<String> VALID_ACTION_INPUTS = initialiseValidActionInputs();

    private String name;
    private IUserInput userInput;
    private IOutput output;

    HumanPlayer() {
        super(NAME, PLAYER_CHARACTER);
    }

    /**
     * Method to set extra properties needed for a human player to play.
     * @param userInput The class for handling User Input for this player.
     * @param output The class for displaying output data for this player.
     */
    public void initialiseHumanPlayer(final IUserInput userInput, final IOutput output) {
        this.userInput = userInput;
        this.output = output;
        setHumanPlayerName();
    }

    /**
     * Initialise the set of valid inputs for actions for the human player.
     * @return A set of Valid Input Actions.
     */
    private static HashSet<String> initialiseValidActionInputs() {
        HashSet<String> validActionInputs = new HashSet<>(3);
        validActionInputs.add(PlayerActionFactory.getScissors().getActionCharacter());
        validActionInputs.add(PlayerActionFactory.getRock().getActionCharacter());
        validActionInputs.add(PlayerActionFactory.getPaper().getActionCharacter());
        return validActionInputs;
    }

    /**
     * Set the human players name.
     */
    private void setHumanPlayerName() {

        output.output("Please enter your name:");
        name = userInput.getNextValidInputString(null);
    }

    /**
     * Returns this players next action.
     * @return The action this player plays next.
     */
    @Override
    public IPlayerAction getNextPlayerAction() {

        output.output(String.format("%s, Please enter your next action (R, P, S):", getName()));

        String validActionInput = userInput.getNextValidInputString(VALID_ACTION_INPUTS);

        return PlayerActionFactory.getIPlayerAction(String.valueOf(validActionInput));
    }

    /**
     * Get the name of this player.  If it has not been set vy the user, use the default.
     * @return The name of this player.
     */
    @Override
    public String getName() {

        if(name == null || name.isEmpty()) {
            return super.getName();
        } else {
            return name;
        }
    }
}
