package com.imc.rockpapaerscissors;

import com.imc.rockpapaerscissors.exceptions.FatalErrorException;
import com.imc.rockpapaerscissors.io.IOutput;
import com.imc.rockpapaerscissors.io.IUserInput;
import com.imc.rockpapaerscissors.io.PrintStreamOutput;
import com.imc.rockpapaerscissors.io.ScannerUserInput;
import com.imc.rockpapaerscissors.players.HumanPlayer;
import com.imc.rockpapaerscissors.players.IPlayer;
import com.imc.rockpapaerscissors.players.PlayerFactory;

import java.util.Scanner;

/**
 * Class for Launching games.
 */
class GameLauncher {

    /**
     * Plays a game of Rock, Paper, Scissors.
     */
    void playRockPaperScissors() throws FatalErrorException {

        IUserInput userInput = new ScannerUserInput(new Scanner(System.in));
        IOutput output = new PrintStreamOutput(System.out);

        IPlayer player1 = PlayerFactory.getPlayer(userInput, output, 1, false);

        if(player1 instanceof  HumanPlayer) {
            ((HumanPlayer) player1).initialiseHumanPlayer(userInput, output);
        }

        IPlayer player2 = PlayerFactory.getPlayer(userInput, output, 2, player1 instanceof HumanPlayer);

        RockPaperScissors rockPaperScissors = new RockPaperScissors(userInput, output, player1, player2);

        rockPaperScissors.play();
    }
}