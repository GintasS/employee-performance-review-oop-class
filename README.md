<div align="center">
  <h2>Employee performance review task - OOP class</h2>
</div>

## Jump to...

  - [Intro](#intro)
  - [Features](#features)
  - [Requirements](#req)
  - [Usage](#usage)
  - [Media](#media)
  - [Changelog](#changelog)
  
## <a name="Intro"></a>Intro

Enter intro here

## <a name="Features"></a>Features

Enter Features Here

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

## <a name="Usage"></a>Usage

Enter Usage Here

## <a name="Media"></a>Media

<!---
<a target="_blank" href="ENTER IMAGE ">
  <img src="https://github.com/GintasS/JobAds/blob/master/JobAds/Images/image1.JPG" height="350" style="max-width:100%;">
</a>
<blockquote>Default app view(taken in 2/13/2020)</blockquote>
-->

## <a name="Changelog"></a>Changelog

<h3>CHANGELOG 3/4/2021</h3>
<ul>
  <li>Created a GitHub repository.</li>
  <li>Created a sample project from Quarkus template.</li>
  <li>Added a branch protection policy, now we can't push to master directly (except for administrators).</li>
</ul>
