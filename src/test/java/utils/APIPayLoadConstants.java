package utils;

import org.json.JSONObject;

public class APIPayLoadConstants {
    public static String createEmployeePayload(){
        String createEmployeePayLoad="{\n" +
                "  \"emp_firstname\": \"Jacks\",\n" +
                "  \"emp_lastname\": \"Adama\",\n" +
                "  \"emp_middle_name\": \"SMO\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1999-01-01\",\n" +
                "  \"emp_status\": \"Active\",\n" +
                "  \"emp_job_title\": \"Eginier\"\n" +
                "}";
        return createEmployeePayLoad;
    }

    public static String createEmployeeJsonPayLoad(){

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","Jacks");
        obj.put("emp_lastname","Adama");
        obj.put("emp_middle_name","SMO");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","1999-01-01");
        obj.put("emp_status","Active");
        obj.put("emp_job_title","Eginier");

        return obj.toString();
    }
    public static String createEmployeeJsonPayLoadDynamic (String fn,String ln,String mn,String gender,String dob,String status,String jobTile){

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname",fn);
        obj.put("emp_lastname",ln);
        obj.put("emp_middle_name",mn);
        obj.put("emp_gender",gender);
        obj.put("emp_birthday",dob);
        obj.put("emp_status",status);
        obj.put("emp_job_title",jobTile);

        return obj.toString();
    }
    public static String updateEmployeePayLoad(){

        String updateEmployee = "{\n" +
                "  \"employee_id\": \"88351A\",\n" +
                "  \"emp_firstname\": \"AMAMAMAM\",\n" +
                "  \"emp_lastname\": \"MOMAM\",\n" +
                "  \"emp_middle_name\": \"QQ\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1993-08-18\",\n" +
                "  \"emp_status\": \"Active\",\n" +
                "  \"emp_job_title\": \"Plubmer\"\n" +
                "}";

        return updateEmployee;
    }

    public static String updateEmployeeJsonPayLoadDynamic(String empID,String fn,String ln,String mn,String gender,String dob,String status, String jobTitle){
        JSONObject obj = new JSONObject();
        obj.put("employee_id",empID);
        obj.put("emp_firstname",fn);
        obj.put("emp_lastname",ln);
        obj.put("emp_middle_name",mn);
        obj.put("emp_gender",gender);
        obj.put("emp_birthday",dob);
        obj.put("emp_status",status);
        obj.put("emp_job_title",jobTitle);

        return obj.toString();
    }
}
