package com.imc.rockpapaerscissors.io;

import java.util.Collection;
import java.util.Scanner;

/**
 * Scanner based implementation for User Input.
 */
public class ScannerUserInput implements IUserInput {

    private Scanner inputScanner;

    /**
     * Constructor
     * @param inputScanner The input scanner to base this implementation upon.
     */
    public ScannerUserInput(Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    /**
     * Returns the next valid input String.
     * @param validInputs A collection of valid inputs chars which can be returned, if null, all input will be considered valid.
     * @return The next valid input.
     */
    @Override
    public String getNextValidInputString(Collection<String> validInputs) {

        String validInputChar;

        while(true) {

            validInputChar = inputScanner.nextLine();
            if(!validInputChar.isEmpty()) {
                if(validInputs == null || validInputs.contains(validInputChar.toLowerCase()) || validInputs.contains(validInputChar.toUpperCase())) {
                    break;
                }
            }
        }

        return validInputChar.toUpperCase();
    }


    /**
     * Returns a positive version of the last number entered.
     * @return The next supplied Integer.
     */
    @Override
    public int getNextPositiveNumber() {
        return Math.abs(inputScanner.nextInt());
    }
}
