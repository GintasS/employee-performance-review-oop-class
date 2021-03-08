package org.acme;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    String fullName; //Employee's full name
    String team; //What team the employee belongs to - Senior Management receives double bonus.
    String performanceRating; //What the employee's performance review was - Exceptional performance increases the bonus by 50%
    boolean isIntern; //Whether the employee is an intern - interns get no bonuses.
    int yearlySalary; //What the employee's current yearly salary is - 5 year bonuses cannot exceed current yearly salary x6
    int employmentTime; //How long the employee has worked in the company - time defines the percentage of yearly salary for the bonus
    List<Integer> yearlyBonuses = new ArrayList<Integer>(); //The list of previous bonuses that are relevant to the bonus calculation.
}
