Feature:Syntax API HRMS Flow

  Background:
    Given a JWT is generated

  @api
  Scenario: Creating the employee using API
    Given a request is prepared for creating an employee
    When a post call is made to create an employee
    Then the status code for creating an employee is 201
    And the employee created contains key "Message" and value "Employee Created"
    And the employee id "Employee.employee_id" is stored as a global variable

    @api
    Scenario: Get the created employee
      Given a request is prepared for retrieving an employee
      When a GET cal is made to retrieve the employee
      Then the status code for this employee is 200
      And the employee id "employee.employee_id" must match globally stored employee id
      And this employee data at "employee" object matches with the data used to create the employee
      |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
      |Jacks        |Adama       |SMO            |Male      |1999-01-01  |Active    |Eginier      |

      @json
      Scenario: Creating employee using json body
        Given a request is prepared for creating an employee using json pay load
        When a post call is made to create an employee
        Then the status code for creating an employee is 201
        And the employee created contains key "Message" and value "Employee Created"
        And the employee id "Employee.employee_id" is stored as a global variable

        @dynamic
        Scenario: Creating an employee using highly dynamic scenario
          Given a request is prepared for creating an employee with data "Jacks","Adama","SMO","M","1999-01-01","confirmed the employee","Eginier"
          When a post call is made to create an employee
          Then the status code for creating an employee is 201
          And the employee created contains key "Message" and value "Employee Created"
          And the employee id "Employee.employee_id" is stored as a global variable


          @updateEMP
          Scenario: updating an employee using dynamic scenario
            Given a request is prepared for updating an employee with data "88351A","AMAMAMAM","MOMAM","QQ","M","1993-08-18","Active","Plubmer"
            When a put call is made to update an employee
            Then the status code is 200
            And the updated employee response body contains key "Message" and value "Employee record Updated"


