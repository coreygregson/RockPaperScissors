package com.imc.rockpapaerscissors;

import com.imc.rockpapaerscissors.exceptions.FatalErrorException;

/**
 * App entry point.  Starts a new game of Rock, Paper, Scissors.
 *
 */
public class App 
{
    private static final int SUCCESS = 0;
    private static final int FAILURE = 1;

    /**
     * Run the application.
     * @param args Not used.
     */
    public static void main( String[] args )
    {
        GameLauncher gameLauncher = new GameLauncher();

        try {
            gameLauncher.playRockPaperScissors();
            System.exit(SUCCESS);
        } catch (FatalErrorException e) {
            System.out.println(e.getMessage());
            System.exit(FAILURE);
        }
    }
}
