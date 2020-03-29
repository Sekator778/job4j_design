package io.test;

public enum SearchBy {
    MASK("glob"),
    FULL("full"),
    REGEX("regex");

    private final String syntax;

    SearchBy(String syntax) {
        this.syntax = syntax;
    }

    public String getSyntax() {
        return syntax;
    }
}