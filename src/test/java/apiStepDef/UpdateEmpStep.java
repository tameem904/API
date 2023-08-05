package apiStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.APIConstants;
import utils.APIPayLoadConstants;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class UpdateEmpStep {

    RequestSpecification request;
    Response response;
    @Given("a request is prepared for updating an employee with data {string},{string},{string},{string},{string},{string},{string},{string}")
    public void a_request_is_prepared_for_updating_an_employee_with_data(String empID,String fn,String ln,String mn,String gender,String dob,String status, String jobTitle) {
        request = given().header(APIConstants.HEADER_CONTENT_TYPE_KEY,APIConstants.HEADER_CONTENT_TYPE_VALUE).
                header(APIConstants.HEADER_AUTHORIZATION_KEY,GenerateTokenStep.token).
                body(APIPayLoadConstants.updateEmployeeJsonPayLoadDynamic(empID,fn,ln,mn,gender,dob,status,jobTitle));
    }
    @When("a put call is made to update an employee")
    public void a_put_call_is_made_to_update_an_employee() {
       response = request.when().put(APIConstants.UPDATE_EMPLOYEE_URI);
    }
    @Then("the status code is {int}")
    public void the_status_code_is(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }
    @Then("the updated employee response body contains key {string} and value {string}")
    public void the_updated_employee_response_body_contains_key_and_value(String key, String value) {

        response.then().assertThat().body(key,equalTo(value));
    }
}
