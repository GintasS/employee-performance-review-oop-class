package org.acme;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    int id; //REST endpoint

    String firstName; //Employee's first name
    String lastName; //Employee's last name

    enum team //What team the employee belongs to - Senior Management receives double bonus.
    {
        SENMANAGE("Senior Management"),
        QUALASSUR("Quality Assurance"),
        PUBLICREL("Public Relationships"),
        MIDMANAGE("Middle Management"),
        TECHSUPPT("Technical Support"),
        SALESFLOR("Sales Floor");

        private final String name;

        private team(String name){
            this.name = name;
        }

        @Override public String toString(){
            return name;
        }
        /*
        One option to maintain the naming convention of an enum while being able to call it out easily without it being in allcaps.
         */
    };

    enum performanceRating //What the employee's performance review was - Exceptional performance increases the bonus by 50%
    {
        EXCEPTIONAL("Exceptional"),
        GREAT("Great"),
        GOOD("Good"),
        ACCEPTABLE("Acceptable"),
        POOR("Poor"),
        UNACCEPTABLE("Unacceptable");

        private final String name;

        private performanceRating(String name)
        {
            this.name = name;
        }

        @Override public String toString(){
            return name;
        }
    }

    enum employeeType //Whether the employee is an intern - interns get no bonuses.
    {
        FULLTIME("full time"),
        INTERN("intern"),
        HALFTIME("half time"),
        ONCALL("on-call"),
        SUSPENDED("suspended"),
        TERMINATED("terminated");

        private final String name;

        private employeeType(String name){
            this.name = name;
        }

        @Override public String toString(){
            return name;
        }

    };

    int yearlySalary; //What the employee's current yearly salary is - 5 year bonuses cannot exceed current yearly salary x6
    int employmentTime; //How long (in years) the employee has worked in the company - time defines the percentage of yearly salary for the bonus
    List<Integer> yearlyBonuses = new ArrayList<Integer>(); //The list of previous bonuses that are relevant to the bonus calculation.
}
