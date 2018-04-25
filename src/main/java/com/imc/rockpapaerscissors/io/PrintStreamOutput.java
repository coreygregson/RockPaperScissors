package com.imc.rockpapaerscissors.io;

import java.io.PrintStream;

/**
 * Output Display implementation for a PrintStream.
 */
public class PrintStreamOutput implements IOutput {

    private PrintStream printStream;

    /**
     * Constructor for an IOutputDisplay based on a PrintStream.
     * @param printStream The PrintStream to use for output.
     */
    public PrintStreamOutput(PrintStream printStream) {
        this.printStream = printStream;
    }

    /**
     * Display a single line to the output.
     * @param line The line to display
     */
    @Override
    public void output(String line) {
        this.printStream.println(line);
    }
}
