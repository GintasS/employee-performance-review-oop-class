package org.acme.enums;

public enum PerformanceRating {

    EXCEPTIONAL("Exceptional"),
    GREAT("Great"),
    GOOD("Good"),
    ACCEPTABLE("Acceptable"),
    POOR("Poor"),
    UNACCEPTABLE("Unacceptable");

    private final String name;

    private PerformanceRating(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

