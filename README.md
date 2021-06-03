<div align="center">
  <h2>Employee performance review task - OOP class</h2>
</div>

## Jump to...

  - [Intro](#intro)
  - [Features](#features)
  - [Requirements](#req)
  - [Changelog](#changelog)
  
## <a name="Intro"></a>Intro

This is our team's take into Employee performance review task.

## <a name="Features"></a>Features

<ul>
  <li>Exception handling.</li>
  <li>Validation request models.</li>
  <li>Using libraries for Json serialization/deserialization.</li>
  <li>Using Postman collection to test API endpoints.</li>
  <li>Using Domain-Driven-Design for project structure.</li>
  <li>Using Trello for task-management.</li>
  <li>Following Google Java Code styling for our code base.</li>
</ul>

## <a name="req"></a>Requirements

Use Quarkus (https://quarkus.io/) for a simple employee performance review and bonus allocation application.

You need to implement CRUD (create/read/update/delete operations) for Employees and their performance and bonuses.

All operations have to be implemented through proper REST API.

Implement a reactive endpoint GET "/employees/:id/bonus" that returns a bonus for the current year, based on the following rules:

If an employee is an intern, they get no bonus.
If an employee was employed for less than 1 year, they get 50% of their salary as a bonus.
If an employee was employed between 1 and 3 years, they get 100% of their salary as a bonus. 
If an employee was employed for more than 3 years, they get 125% of their salary as a bonus.

If an employee is in the senior management team, their bonus is doubled.
If employees had an Exceptional performance rating during the last year, their bonus is increased by 50%.
Sum of all bonuses that employee received during any given 5 years IN A ROW cannot exceed their salary during the last year of the period multiplied by 6.

Employee information should be read from the file and saved to a file. 

## <a name="Changelog"></a>Changelog

<h3>CHANGELOG 3/4/2021</h3>
<ul>
  <li>Created a GitHub repository.</li>
  <li>Created a sample project from Quarkus template.</li>
  <li>Added a branch protection policy, now we can't push to master directly (except for administrators).</li>
</ul>

<h3>CHANGELOG 3/5/2021</h3>
<ul>
  <li>Onboarded Ivan and Simonas to the project.</li>
  <li>Created a Trello board for tasks.</li>
  <li>Created 9 tasks in Trello board, divided work between ourselves.</li>
</ul>

<h3>CHANGELOG 3/8/2021</h3>
<ul>
  <li>Simonas has created a PR with our initial employee entity, that will hold our data from a JSON file.</li>
</ul>

<h3>CHANGELOG 3/15/2021</h3>
<ul>
  <li>Searched for a better project structure and found https://github.com/diegocamara/realworld-api-quarkus. After carefull consideration, will start using this
  project for better structuring and best practises.</li>
</ul>

<h3>CHANGELOG 3/20/2021</h3>
<ul>
  <li>Applied https://github.com/diegocamara/realworld-api-quarkus project structure.</li>
  <li>Switched from Java 1.8 to Java 11 version.</li>
</ul>

<h3>CHANGELOG 3/22/2021</h3>
<ul>
  <li>Added 4 CRUD endpoints for employee.</li>
  <li>Cleaned up the project solution, deleted many files.</li>
  <li>Cleaned Postman tests.</li>
</ul>

<h3>CHANGELOG 3/23/2021</h3>
<ul>
  <li>Integrated working JSON reader, writer to hold our employee data.</li>
  <li>Now our request, response, entity, model classes hold full employee data.</li>
  <li>Added File IO.</li>
  <li>Added default values for some Postman collections.</li>
  <li>Added default values for some Postman endpoints</li>
</ul>

<h3>CHANGELOG 3/25/2021</h3>
<ul>
  <li>Added employee bonus id endpoint.</li>
  <li>Switched from having int for yearlySalary and yearlyBonuses to having BigDecimal, for precision.</li>
  <li>Fixed Postman endpoints.</li>
  <li>Fixed small bug regarding updating employee.</li>
  <li>Other smaller changes.</li>
</ul>
