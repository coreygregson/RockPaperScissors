package com.imc.rockpapaerscissors.players;

import com.imc.rockpapaerscissors.io.IOutput;
import com.imc.rockpapaerscissors.io.IUserInput;
import com.imc.rockpapaerscissors.playeractions.PlayerActionFactory;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit test for simple App.
 */
public class HumanPlayerTester
{

    /**
     * Test Human Player
     */
    @Test
    public void testHumanPlayerActions() {

        //default behaviour
        HumanPlayer player = new HumanPlayer();
        assertEquals(player.getPlayerCharacter(), "H");
        assertEquals(player.getName(), "Human Player");

        HashSet<String> validInputs = new HashSet<>();
        validInputs.add("R");
        validInputs.add("P");
        validInputs.add("S");

        IUserInput userInputMock = mock(IUserInput.class);
        when(userInputMock.getNextValidInputString(validInputs))
                .thenReturn("R")
                .thenReturn("P")
                .thenReturn("S");

        when(userInputMock.getNextValidInputString(null))
                .thenReturn("Name");

        IOutput outputMock = mock(IOutput.class);

        player.initialiseHumanPlayer(userInputMock, outputMock);
        assertEquals(player.getName(), "Name");
        assertEquals(player.getNextPlayerAction(), PlayerActionFactory.getRock());
        assertEquals(player.getNextPlayerAction(), PlayerActionFactory.getPaper());
        assertEquals(player.getNextPlayerAction(), PlayerActionFactory.getScissors());

    }

    /**
     * Test Human Player
     */
    @Test
    public void testHumanPlayerInitialise() {

        //default behaviour
        HumanPlayer player = new HumanPlayer();
        String testName = "test Name";

        IUserInput userInputMock = mock(IUserInput.class);
        when(userInputMock.getNextValidInputString(null)).thenReturn(testName);

        IOutput outputMock = mock(IOutput.class);

        player.initialiseHumanPlayer(userInputMock, outputMock);
        assertEquals(player.getName(), testName);

        assertNull(player.getNextPlayerAction());
    }
}
