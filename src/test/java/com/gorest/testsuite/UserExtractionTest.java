package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserExtractionTest {
    static ValidatableResponse response;
    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        response = given()
                .when()
                .get("/users")
                .then().statusCode(200);
    }

    //1. Extract the All Ids
    @Test
    public void test001() {
        List<Integer> totalId = response.extract().path("id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + totalId);
        System.out.println("------------------End of Test---------------------------");
    }
    //2. Extract the all Names
    @Test
    public void test002() {
        List<Integer> totalNames = response.extract().path("name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + totalNames);
        System.out.println("------------------End of Test---------------------------");
    }
    //3. Extract the name of 5th object
    @Test
    public void test003() {
        String fifthName = response.extract().path("name[5]");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The the name of 5th object : " + fifthName);
        System.out.println("------------------End of Test---------------------------");
    }
    //4. Extract the names of all object whose status = inactive
    @Test
    public void test004() {
        List<String> allNames = response.extract().path("findAll{it.status == 'inactive'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + allNames);
        System.out.println("------------------End of Test---------------------------");
    }
    //5. Extract the gender of all the object whose status = active
    @Test
    public void test005() {
        List<String> allGender = response.extract().path("findAll{it.status == 'active'}.gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the gender of all the object whose status is active : " + allGender);
        System.out.println("------------------End of Test---------------------------");
    }
    //6. Print the names of the object whose gender = female
    @Test
    public void test006() {
        List<String> allNames = response.extract().path("findAll{it.gender == 'female'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + allNames);
        System.out.println("------------------End of Test---------------------------");
    }
    //7. Get all the emails of the object where status = inactive
    @Test
    public void test007() {
        List<String> email = response.extract().path("findAll{it.status == 'inactive'}.email");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + email);
        System.out.println("------------------End of Test---------------------------");
    }
    //8. Get the ids of the object where gender = male
    @Test
    public void test008() {
        List<String> allIds = response.extract().path("findAll{it.gender == 'male'}.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + allIds);
        System.out.println("------------------End of Test---------------------------");
    }
    //9. Get all the status
    @Test
    public void test010() {
        List<String> status = response.extract().path("status");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + status);
        System.out.println("------------------End of Test---------------------------");
    }
    //10. Get email of the object where name = Karthik Dubashi IV
    @Test
    public void test011() {
        String email = response.extract().path("findAll{it.name == 'Raj Patil'}.email");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of email is : " + email);
        System.out.println("------------------End of Test---------------------------");
    }
    //11. Get gender of id = 5471
    @Test
    public void test012() {
        String gender = response.extract().path("find{it.id == 5309}.gender");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The gender is : " + gender);
        System.out.println("------------------End of Test---------------------------");
    }
}
