package com.codurance.training.tasks.io.console;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleInput {

    private final BufferedReader reader;

    public ConsoleInput(BufferedReader bufferedReader) {
        this.reader = bufferedReader;
    }

    public String nextInput() throws IOException {
        return reader.readLine();
    }

}

