package io.archive;

import java.nio.file.Paths;

public class Args {
    private String[] args;

    public Args(String[] args) {
        this.args = args;
    }

    public String directory() {
        if (!testArgs(this.args)) {
            throw new IllegalArgumentException("wrong args");
        }
        return Paths.get(this.args[1]).toString();
    }

    public String excuse() {
        if (!testArgs(this.args)) {
            throw new IllegalArgumentException("wrong args");
        }
        return Paths.get(this.args[3]).toString().replace("*", "");
    }

    public String output() {
        if (!testArgs(this.args)) {
            throw new IllegalArgumentException("wrong args");
        }
        return Paths.get(this.args[5]).toString();
    }

    private boolean testArgs(String[] args) {
        return (args[0].equals("-d") && args[2].equals("-e") && args[4].contains("-o"));
    }
}
