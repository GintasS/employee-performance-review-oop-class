package org.acme;

import java.util.ArrayList;
import java.util.List;
import org.acme.enums.EmployeeType;
import org.acme.enums.PerformanceRating;
import org.acme.enums.Team;

public class Employee {
    int id; //REST endpoint

    String firstName; //Employee's first name
    String lastName; //Employee's last name

    Team team; //What team the employee belongs to - Senior Management receives double bonus.
    PerformanceRating rating;//What the employee's performance review was - Exceptional performance increases the bonus by 50%
    EmployeeType type; //Interns get no bonuses.

    int yearlySalary; //What the employee's current yearly salary is - 5 year bonuses cannot exceed current yearly salary x6
    int employmentTime; //How long (in years) the employee has worked in the company - time defines the percentage of yearly salary for the bonus
    List<Integer> yearlyBonuses = new ArrayList<Integer>(); //The list of previous bonuses that are relevant to the bonus calculation.
}
