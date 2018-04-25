package com.imc.rockpapaerscissors.players;

import com.imc.rockpapaerscissors.playeractions.*;

import java.util.Random;

/**
 * Helper class for generating Player Actions.
 */
class PlayerActionHelper {

    private static Random random = new Random();

    /**
     * Returns A random {@link IPlayerAction}
     * @return A random player action.
     */
    static IPlayerAction getRandomPlayerAction() {
        int value = random.nextInt(100);

        if (value < 33) {
            return PlayerActionFactory.getRock();
        } else if (value < 66) {
            return PlayerActionFactory.getPaper();
        } else {
            return PlayerActionFactory.getScissors();
        }
    }

    /**
     * Get a Player Action which will beat the supplied action.
     * @param actionToBeat The Player Action to beat.
     * @return The Player Action which will be the actionToBeat
     */
    static IPlayerAction getPlayerActionWhichBeats(final IPlayerAction actionToBeat) {
        if(PlayerActionFactory.getRock().beats(actionToBeat)) {
            return PlayerActionFactory.getRock();
        } else if(PlayerActionFactory.getPaper().beats(actionToBeat)) {
            return PlayerActionFactory.getPaper();
        } else  {
            return PlayerActionFactory.getScissors();
        }
    }
}
