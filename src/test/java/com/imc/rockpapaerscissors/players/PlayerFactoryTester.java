package com.imc.rockpapaerscissors.players;

import com.imc.rockpapaerscissors.exceptions.FatalErrorException;
import com.imc.rockpapaerscissors.io.IOutput;
import com.imc.rockpapaerscissors.io.IUserInput;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit test for simple App.
 */
public class PlayerFactoryTester
{

    /**
     * Test Player Factory
     */
    @Test
    public void testPlayerFactory() {

        //default behaviour
        HumanPlayer player = new HumanPlayer();
        assertEquals(player.getPlayerCharacter(), "H");
        assertEquals(player.getName(), "Human Player");

        HashSet<String> validInputs = new HashSet<>();
        validInputs.add("C");
        validInputs.add("R");
        validInputs.add("B");
        validInputs.add("H");

        IUserInput userInputMock = mock(IUserInput.class);
        when(userInputMock.getNextValidInputString(validInputs))
                .thenReturn("C")
                .thenReturn("R")
                .thenReturn("B")
                .thenReturn("H")
                .thenReturn("H");

        when(userInputMock.getNextValidInputString(null))
                .thenReturn("Name");

        IOutput outputMock = mock(IOutput.class);

        try {
            IPlayer player1 = PlayerFactory.getPlayer(userInputMock, outputMock, 1, false);
            assertEquals(player1.getName(), "Copying Cathy");
            assertEquals(player1.getPlayerCharacter(), "C");
            assertNotNull(player1.getNextPlayerAction());

            IPlayer player2 = PlayerFactory.getPlayer(userInputMock, outputMock, 2, false);
            assertEquals(player2.getName(), "Reactive Rolf");
            assertEquals(player2.getPlayerCharacter(), "R");
            assertNotNull(player2.getNextPlayerAction());

            IPlayer player3 = PlayerFactory.getPlayer(userInputMock, outputMock, 3, false);
            assertEquals(player3.getName(), "Basic Bob");
            assertEquals(player3.getPlayerCharacter(), "B");
            assertNotNull(player3.getNextPlayerAction());

            IPlayer player4 = PlayerFactory.getPlayer(userInputMock, outputMock, 4, false);
            assertEquals(player4.getName(), "Human Player");
            assertEquals(player4.getPlayerCharacter(), "H");

        } catch (FatalErrorException e) {
            fail();
        }
    }
}
