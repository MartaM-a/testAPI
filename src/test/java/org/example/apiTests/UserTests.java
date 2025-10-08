package org.example.apiTests;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.config.ApiConfig;
import org.example.models.Post;
import org.example.models.User;
import org.junit.Test;
import org.example.utils.ClientAPI;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.example.config.ApiConfig.*;
import static org.example.config.ApiConfig.USER_BY_ID_ENDPOINT;

import static org.example.utils.ClientAPI.*;

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

    @Test
    public void getAllUsers_shouldMatchSchema() {
        given()
                .baseUri(BASE_URL)
                .contentType(String.valueOf(CONTENT_TYPE))
                .when()
                .get(USERS_ENDPOINT)
                .then()
                .log().all()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/user_list_schema.json"));
    }




        @Test
        public void createUserTest () {

            User user = new User();
            user.id = 1L;
            user.username = "Marta";
            user.email = "marta@example.com";

            Response response = ClientAPI.post(ApiConfig.POSTS_ENDPOINT, user);

            response.then()
                    .statusCode(201)
                    .body("username", equalTo("Marta"))
                    .body("email", equalTo("marta@example.com"));
        }

    @Test
    public void createUserTest3() {
        User user = new User();
        user.id = 1L;
        user.username = "Marta";
        user.email = "marta@example.com";

        given()
                .contentType(ContentType.JSON)
                .log().body()
                .body(user)
                .when()
                .post(ApiConfig.POSTS_ENDPOINT)
                .then()
                .statusCode(201)
                .body("id", equalTo(101))
                .body("username", equalTo("Marta"))
                .body("email", equalTo("marta@example.com"));
    }


    @Test
    public void createRandomUserTest() {
        User user = User.createRandom();

        given()
                .contentType("application/json")
                .body(user)
                .when()
                .post(ApiConfig.POSTS_ENDPOINT)
                .then()
                .log().all()
                .statusCode(201)
                .body("username", equalTo(user.username))
                .body("email", equalTo(user.email));

    }


    }











