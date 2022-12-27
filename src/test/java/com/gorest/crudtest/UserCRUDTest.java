package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static com.gorest.utils.TestUtils.getRandomValue;
import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {

    //1. verifyUserCreatedSuccessfully()
    @Test
    public void verifyUserCreatedSuccessfully() {
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Joe Jhones");
        userPojo.setEmail(getRandomValue() + "joe123@example.com");
        userPojo.setGender("Male");
        userPojo.setStatus("Active");
        Response response =
                given().log().all()
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Bearer a58049a1423e7d9a9d0f744f34e6a883d3f4228d9f8e198bd163aa265bbf5906")
                        .header("Connection", "keep-alive")
                        .body(userPojo)
                        .when()
                        .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();
    }

    //2. verifyUserUpdateSuccessfully()
    @Test
    public void verifyUserUpdateSuccessfully() {
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Jo Sharma");
        userPojo.setEmail(getRandomValue() + "jo13@example.com");
        userPojo.setGender("Male");
        userPojo.setStatus("Active");
        Response response =
                given().log().all()
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Bearer 7b1d7b341121699ba0943bed04e9190c049b1988bf29891567ea8ac6cec0406e")
                        .body(userPojo)
                        .when()
                        .put("/users/11422");
        response.then().statusCode(200);
        response.prettyPrint();
    }
    //3. VerifyUserDeleteSuccessfully()
    @Test
    public void verifyUserDeleteSuccessfully(){

        UserPojo userPojo = new UserPojo();
        userPojo.setName("Jo Sharma");
        userPojo.setEmail(getRandomValue() + "jo13@example.com");
        userPojo.setGender("Male");
        userPojo.setStatus("Active");
        Response response =
                given().log().all()
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Bearer 7b1d7b341121699ba0943bed04e9190c049b1988bf29891567ea8ac6cec0406e")
                        .body(userPojo)
                        .when()
                        .delete("/users/11422");
        response.then().statusCode(204);
        response.prettyPrint();
    }


}
