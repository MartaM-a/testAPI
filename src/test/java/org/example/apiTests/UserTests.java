package org.example.apiTests;


import org.junit.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.example.config.ApiConfig.*;
import static org.example.config.ApiConfig.USER_BY_ID_ENDPOINT;
import static org.example.utils.ClientAPI.getAll;
import static org.example.utils.ClientAPI.getById;
import static org.hamcrest.Matchers.equalTo;

public class UserTests {
    @Test
    public void getAllUsers () {
        getAll(USERS_ENDPOINT).then().log().all().statusCode(200).body(matchesJsonSchemaInClasspath("schemas/users_list_schema.json"));
    }

    @Test
    public void getUserByIdSuccessful() {
        getById(USER_BY_ID_ENDPOINT, "1").then().log().all().statusCode(200).body(matchesJsonSchemaInClasspath("schemas/user_schema.json"));
    }

    @Test
    public void getUserByIdUnSuccessful() {
        getById(USER_BY_ID_ENDPOINT,"9999").then().log().all().statusCode(404).body(equalTo("{}"));
    }

    @Test
    public void userWithId1ShouldExist() {
        getById(USER_BY_ID_ENDPOINT, "1")
                .then()
                .log().all()
                .statusCode(200)
                .body("id", equalTo(1));
    }
    @Test
    public void userWithId8ShouldExist() {
        getById(USER_BY_ID_ENDPOINT, "8")
                .then()
                .log().all()
                .statusCode(200)
                .body("id", equalTo(8));
    }

}
