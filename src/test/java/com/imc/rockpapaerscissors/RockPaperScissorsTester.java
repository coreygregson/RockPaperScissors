package com.imc.rockpapaerscissors;

import com.imc.rockpapaerscissors.io.IOutput;
import com.imc.rockpapaerscissors.io.IUserInput;
import com.imc.rockpapaerscissors.io.PrintStreamOutput;
import com.imc.rockpapaerscissors.playeractions.PlayerActionFactory;
import com.imc.rockpapaerscissors.players.BasicRandomPlayer;
import com.imc.rockpapaerscissors.players.IPlayer;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Unit test for simple App.
 */
public class RockPaperScissorsTester
{

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    /**
     * Test Rock, Paper, Scissors 1
     */
    @Test
    public void testRockPaperScissors1() {

        IPlayer player1Mock = mock(BasicRandomPlayer.class);
        when(player1Mock.getNextPlayerAction())
                .thenReturn(PlayerActionFactory.getRock())
                .thenReturn(PlayerActionFactory.getPaper())
                .thenReturn(PlayerActionFactory.getScissors());
        when(player1Mock.getName()).thenReturn("Player1");

        IPlayer player2Mock = mock(BasicRandomPlayer.class);
        when(player2Mock.getNextPlayerAction())
                .thenReturn(PlayerActionFactory.getRock())
                .thenReturn(PlayerActionFactory.getRock())
                .thenReturn(PlayerActionFactory.getPaper());
        when(player2Mock.getName()).thenReturn("Player2");

        IUserInput userInputMock = mock(IUserInput.class);

        //3 rounds
        when(userInputMock.getNextPositiveNumber())
                .thenReturn(3);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);

        ByteArrayInputStream in = new ByteArrayInputStream(baos.toByteArray());

        IOutput output = new PrintStreamOutput(out);

        RockPaperScissors rps = new RockPaperScissors(userInputMock, output, player1Mock, player2Mock);
        rps.play();


        int n = in.available();
        byte[] bytes = baos.toByteArray();
        in.read(bytes, 0, n);
        String displayOutput  = new String(bytes, StandardCharsets.UTF_8);

        assertTrue(displayOutput.contains("Player1's Rock drew with Player2's Rock"));
        assertTrue(displayOutput.contains("Player1's Paper wraps Player2's Rock"));
        assertTrue(displayOutput.contains("Player1's Scissors cuts Player2's Paper"));

        assertTrue(displayOutput.contains("Player 1's Player1 won 2 rounds."));
        assertTrue(displayOutput.contains("Player 2's Player2 won 0 rounds."));
        assertTrue(displayOutput.contains("There was 1 drawn round."));

        assertTrue(displayOutput.contains("Player 1's Player1 won 2 rounds."));
    }


    /**
     * Test Rock, Paper, Scissors 2
     */
    @Test
    public void testRockPaperScissors2() {

        IPlayer player1Mock = mock(BasicRandomPlayer.class);
        when(player1Mock.getNextPlayerAction())
                .thenReturn(PlayerActionFactory.getRock())
                .thenReturn(PlayerActionFactory.getPaper());
        when(player1Mock.getName()).thenReturn("P1");

        IPlayer player2Mock = mock(BasicRandomPlayer.class);
        when(player2Mock.getNextPlayerAction())
                .thenReturn(PlayerActionFactory.getRock())
                .thenReturn(PlayerActionFactory.getPaper());
        when(player2Mock.getName()).thenReturn("P2");

        IUserInput userInputMock = mock(IUserInput.class);

        //3 rounds
        when(userInputMock.getNextPositiveNumber())
                .thenReturn(2);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(baos);

        ByteArrayInputStream in = new ByteArrayInputStream(baos.toByteArray());

        IOutput output = new PrintStreamOutput(out);

        RockPaperScissors rps = new RockPaperScissors(userInputMock, output, player1Mock, player2Mock);
        rps.play();


        int n = in.available();
        byte[] bytes = baos.toByteArray();
        in.read(bytes, 0, n);
        String displayOutput  = new String(bytes, StandardCharsets.UTF_8);

        assertTrue(displayOutput.contains("P1's Rock drew with P2's Rock"));
        assertTrue(displayOutput.contains("P1's Paper drew with P2's Paper"));

        assertTrue(displayOutput.contains("Player 1's P1 won 0 rounds."));
        assertTrue(displayOutput.contains("Player 2's P2 won 0 rounds."));
        assertTrue(displayOutput.contains("There were 2 drawn rounds."));
    }
}
