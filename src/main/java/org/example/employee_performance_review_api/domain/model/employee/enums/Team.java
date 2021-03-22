package org.example.employee_performance_review_api.domain.model.employee.enums;

public enum Team {

    MIDMANAGE("Middle Management"),
    PUBLICREL("Public Relationships"),
    QUALASSUR("Quality Assurance"),
    SALESFLOR("Sales Floor"),
    SENMANAGE("Senior Management"),
    TECHSUPPT("Technical Support");

    private final String name;

    Team(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

