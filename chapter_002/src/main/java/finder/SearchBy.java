package finder;

/**
 * Type of search.
 */
public enum SearchBy {
    /**
     * Search by mask where the mask is a glob pattern using wildcards.
     */
    MASK("glob"),
    /**
     * Search by full name.
     */
    FULL("full"),
    /**
     * Search using regular expression.
     */
    REGEX("regex");
    /**
     * Syntax used in this type of search.
     */
    private final String syntax;

    SearchBy(String syntax) {
        this.syntax = syntax;
    }

    /**
     * @return syntax used in this type of search
     */
    public String getSyntax() {
        return syntax;
    }
}