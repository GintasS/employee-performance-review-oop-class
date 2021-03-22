package org.example.employee_performance_review_api.domain.model.employee.enums;

public enum PerformanceRating {

    EXCEPTIONAL("Exceptional"),
    GREAT("Great"),
    GOOD("Good"),
    ACCEPTABLE("Acceptable"),
    POOR("Poor"),
    UNACCEPTABLE("Unacceptable");

    private final String name;

    PerformanceRating(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

