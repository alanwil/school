public enum SubjectName {
    MATH("Math"),
    PHYSICS("Physics"),
    COMPSCIENCE("Computer science"),
    CHEMISTRY("Chemistry"),
    HISTORY("History"),
    DEFAULT("Default");

    private final String name;

    SubjectName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
