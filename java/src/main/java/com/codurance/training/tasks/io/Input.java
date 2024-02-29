package com.codurance.training.tasks.io;

import java.io.BufferedReader;
import java.io.IOException;

public class Input {

    private final BufferedReader reader;

    public Input(BufferedReader bufferedReader) {
        this.reader = bufferedReader;
    }

    public String nextInput() throws IOException {
        return reader.readLine();
    }

}

