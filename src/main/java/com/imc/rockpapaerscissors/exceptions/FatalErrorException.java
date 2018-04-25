package com.imc.rockpapaerscissors.exceptions;

/**
 * Class for returning fatal exception information.
 */
public class FatalErrorException extends Exception {

    /**
     * Create a new FatalErrorException
     * @param message Error Message
     * @param ex Underlying Exception
     */
    public FatalErrorException(String message, Exception ex) {
        super(message, ex);
    }
}
