package org.acme.enums;

public enum Team {

    MIDMANAGE("Middle Management"),
    PUBLICREL("Public Relationships"),
    QUALASSUR("Quality Assurance"),
    SALESFLOR("Sales Floor"),
    SENMANAGE("Senior Management"),
    TECHSUPPT("Technical Support");

    private final String name;

    private Team(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

