package com.imc.rockpapaerscissors.io;

import java.util.Collection;

/**
 * Basic interface for an input.
 */
public interface IUserInput {

    /**
     * Returns the next String which is input from the user.
     * @param validInputs A collection of valid inputs chars which can be returned, if null, all input will be considered valid.
     * @return The next valid String which the user entered.
     */
    String getNextValidInputString(Collection<String> validInputs);

    /**
     * Returns the next positive number entered by the user.
     * @return The next positive number entered by the user.
     */
    int getNextPositiveNumber();
}
