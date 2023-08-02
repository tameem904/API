package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamples {
    String baseURI=RestAssured.baseURI="http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2OTEwMTE2NDUsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTY5MTA1NDg0NSwidXNlcklkIjoiNTY0OCJ9.3GalAt4HEClSepOGC78FFadiRmvjqAILa0IrsZBSrz8";
    static String employee_id;
    @Test
    public void acreateEmployee(){
       RequestSpecification request = given().header("Content-Type","application/json").header("Authorization",token).
                body("{\n" +
                        "  \"emp_firstname\": \"Jacks\",\n" +
                        "  \"emp_lastname\": \"Adama\",\n" +
                        "  \"emp_middle_name\": \"SMO\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1999-01-01\",\n" +
                        "  \"emp_status\": \"Active\",\n" +
                        "  \"emp_job_title\": \"Eginier\"\n" +
                        "}");

        Response response =  request.when().post("/createEmployee.php");

        response.then().assertThat().statusCode(201);
        //System.out.println(response);
        response.prettyPrint();

        response.then().assertThat().body("Employee.emp_firstname",equalTo("Jacks"));
        response.then().assertThat().body("Employee.emp_middle_name",equalTo("SMO"));
        response.then().assertThat().header("X-Powered-By","PHP/7.2.18");

        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

    }

    @Test
    public void bgetCreatedEmployee(){
        RequestSpecification request=given().header("Authorization",token).queryParam("employee_id",employee_id);

        Response response=request.when().get("/getOneEmployee.php");
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
        String tempEmpId = response.jsonPath().getString("employee.employee_id");
        Assert.assertEquals(tempEmpId,employee_id);
    }
    @Test
    public void cUpdateEmployee(){
        RequestSpecification request = given().header("Content-Type","application/json").header("Authorization",token).
                body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_firstname\": \"AMAMAMAM\",\n" +
                        "  \"emp_lastname\": \"MOMAM\",\n" +
                        "  \"emp_middle_name\": \"QQ\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"1993-08-18\",\n" +
                        "  \"emp_status\": \"Active\",\n" +
                        "  \"emp_job_title\": \"Plubmer\"\n" +
                        "}");

        Response response = request.when().put("/updateEmployee.php");
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("Message",equalTo("Employee record Updated"));
    }
    @Test
    public void dgetCreatedEmployee(){
        RequestSpecification request=given().header("Authorization",token).queryParam("employee_id",employee_id);

        Response response=request.when().get("/getOneEmployee.php");
        response.then().assertThat().statusCode(200);
        response.prettyPrint();
        //String tempEmpId = response.jsonPath().getString("employee.employee_id");
       // Assert.assertEquals(tempEmpId,employee_id);
    }

    @Test
    public void ePartiallyUpdateEmployee(){
        RequestSpecification request = given().header("Content-Type","application/json").header("Authorization",token).
                body("{\n" +
                        "  \"employee_id\": \""+employee_id+"\",\n" +
                        "  \"emp_middle_name\": \"MOESES\"\n" +
                        "\n" +
                        "}");

        Response response = request.when().patch("/updatePartialEmplyeesDetails.php");
        response.then().assertThat().statusCode(201);
        response.then().assertThat().body("Message",equalTo("Employee record updated successfully"));
        response.prettyPrint();
    }
    @Test
    public void fGetPartiallyUpdatedEmployee(){
        RequestSpecification request = given().header("Authorization",token).queryParam("employee_id",employee_id);
        Response response = request.when().get("/getOneEmployee.php");
         response.then().assertThat().statusCode(200);
         response.prettyPrint();
    }
}
