package com.imc.rockpapaerscissors;

import com.imc.rockpapaerscissors.io.IOutput;
import com.imc.rockpapaerscissors.io.IUserInput;
import com.imc.rockpapaerscissors.playeractions.IPlayerAction;
import com.imc.rockpapaerscissors.players.ILearningPlayer;
import com.imc.rockpapaerscissors.players.IPlayer;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * Implementation of the Game of Rock, Paper, Scissors.
 */
class RockPaperScissors  {

    private static final String NAME = "Rock, Paper, Scissors";
    private static final String DREW_WITH = "drew with";

    private IPlayer player1;
    private IPlayer player2;
    private IOutput output;
    private IUserInput userInput;
    private int numberOfRounds;
    private RoundResult[] roundResults;

    /**
     * Constructor
     * @param userInput The class to provide user inputs.
     * @param output The class to display outputs to the user.
     */
    RockPaperScissors(IUserInput userInput, IOutput output, IPlayer player1, IPlayer player2) {
        this.userInput = userInput;
        this.output = output;
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Play the game.
     */
    void play() {
        displayIntroductionScreen();
        initialiseNumberOfRounds();
        playRounds();
        displayResultsOfGame();
    }

    /**
     * Display the introduction Screen.
     */
    private void displayIntroductionScreen() {

        String outputLine = String.format("* Welcome, '%s' and '%s' to %s. *", player1.getName(), player2.getName(), NAME);
        String starRepeated = IntStream.range(0, outputLine.length()).mapToObj(i -> "*").collect(Collectors.joining(""));
        output.output(starRepeated);
        output.output(outputLine);
        output.output(starRepeated);
    }

    /**
     * Set the number of rounds to be played for the game.
     */
    private void initialiseNumberOfRounds() {

        output.output("Please enter the number of Rounds to play:");

        this.numberOfRounds = userInput.getNextPositiveNumber();
        this.roundResults = new RoundResult[numberOfRounds];
    }

    /**
     * Play each round of the game.
     */
    private void playRounds() {
        IntStream.range(0, numberOfRounds).forEach(this::playRound);
    }

    /**
     * Play the specific round.
     * @param roundNumber The round number to play.
     */
    private void playRound(int roundNumber) {
        IPlayerAction playerAction1 = player1.getNextPlayerAction();
        IPlayerAction playerAction2 = player2.getNextPlayerAction();

        RoundResult roundResult = getRoundResult(playerAction1, playerAction2);
        roundResults[roundNumber] = roundResult;

        displayRoundResults(roundResult, playerAction1, playerAction2, roundNumber + 1);

        updateLearningPlayers(playerAction1, playerAction2);
    }

    /**
     * Display the results from the round.
     * @param roundResult The result of the round from the point of view of player 1.
     * @param playerAction1 The action of player 1 for this round.
     * @param playerAction2 The action of player 2 for this round.
     */
    private void displayRoundResults(RoundResult roundResult, IPlayerAction playerAction1, IPlayerAction playerAction2, int roundNumber) {

        if(roundResult == RoundResult.DRAW) {
            output.output(String.format("Round %s: %s's %s %s %s's %s", roundNumber, player1.getName(), playerAction1.getName(), DREW_WITH, player2.getName(), playerAction2.getName()));
        } else if (roundResult == RoundResult.WIN){
            output.output(String.format("Round %s: %s's %s %s %s's %s", roundNumber, player1.getName(), playerAction1.getName(), playerAction1.getWinningVerb(), player2.getName(), playerAction2.getName()));
        } else {
            output.output(String.format("Round %s: %s's %s %s %s's %s", roundNumber, player2.getName(), playerAction2.getName(), playerAction2.getWinningVerb(), player1.getName(), playerAction1.getName()));
        }
    }

    /**
     * Update any learning players with information fro the last move played.  This is the same as the players
     * remembering the last moves played.
     * @param player1LastAction The last Action Player 1 made
     * @param player2LastAction The last Action Player 2 made
     */
    private void updateLearningPlayers(IPlayerAction player1LastAction, IPlayerAction player2LastAction) {
        if(player1 instanceof ILearningPlayer) {
            ((ILearningPlayer) player1).setOpponentsLastAction(player2LastAction);
        }

        if(player2 instanceof ILearningPlayer) {
            ((ILearningPlayer) player2).setOpponentsLastAction(player1LastAction);
        }
    }

    /**
     * Get the result from this round by looking at the players actions.
     * @param playerAction1 Player 1's action.
     * @param playerAction2 Player 2's action.
     * @return Results from the point of view of Player 1
     */
    private RoundResult getRoundResult(IPlayerAction playerAction1, IPlayerAction playerAction2) {
        if (playerAction1.beats(playerAction2)) {
            return RoundResult.WIN;
        } else if (playerAction2.beats(playerAction1)) {
            return  RoundResult.LOSS;
        } else {
            return RoundResult.DRAW;
        }
    }

    /**
     * Displays the results from the game.
     */
    private void displayResultsOfGame() {

        long player1Score = Arrays.stream(roundResults)
                .filter(playerAction -> playerAction.equals(RoundResult.WIN))
                .count();

        long player2Score = Arrays.stream(roundResults)
                .filter(playerAction -> playerAction.equals(RoundResult.LOSS))
                .count();

        long numDraws = numberOfRounds - player1Score - player2Score;
        String starRepeated = IntStream.range(0, 30).mapToObj(i -> "*").collect(Collectors.joining(""));
        output.output("\n\n");
        output.output(starRepeated);
        output.output(starRepeated);
        output.output(String.format("Player 1's %s won %s rounds.", player1.getName(), player1Score));
        output.output(String.format("Player 2's %s won %s rounds.", player2.getName(), player2Score));

        if(numDraws == 1) {
            output.output(String.format("There was %s drawn round.", numDraws));
        } else {
            output.output(String.format("There were %s drawn rounds.", numDraws));
        }

        if(player1Score > player2Score) {
            output.output(String.format("Congratulations to the winner, Player 1's, %s!!!.", player1.getName()));
        } else if(player2Score > player1Score) {
            output.output(String.format("Congratulations to the winner, Player 2's, %s!!!.", player2.getName()));
        } else  {
            output.output("Wow, the game was a draw!");
        }
        output.output(starRepeated);
        output.output(starRepeated);
    }
}
