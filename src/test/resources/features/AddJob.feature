Feature: Adding new jobs in HRMS
  Background:
    When user enter valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application

     @addJob
    Scenario:  User adds a new job
      * user clicks on the admin button
      * user click on the job
      * user clicks on Job title
      * user clicks on add button
      * user enters job "Java Instructor" title
      * user enters job description "Teaches java"
      * user click on save button
      * verify data is stored properly in database



