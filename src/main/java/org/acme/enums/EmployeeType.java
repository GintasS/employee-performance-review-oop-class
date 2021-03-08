package org.acme.enums;

public enum EmployeeType //Whether the employee is an intern - interns get no bonuses.
{
    FULLTIME("Full time"),
    INTERN("Intern"),
    HALFTIME("Half time"),
    ONCALL("On-call"),
    SUSPENDED("Suspended"),
    TERMINATED("Terminated");

    private final String name;

    private EmployeeType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}