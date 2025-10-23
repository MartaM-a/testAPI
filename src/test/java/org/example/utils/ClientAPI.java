package org.example.utils;

import io.restassured.response.Response;
import org.example.models.User;
import org.junit.runner.Request;

import static io.restassured.RestAssured.*;

public class ClientAPI {
    public static Response getAll(String endpoint) {
        return get(endpoint);
    }

    public static Response getById(String endpoint, String id) {
        return given().pathParam("id", id).when().get(endpoint);

    }

public static Response post(String endpoint, Object payload ) {
    return given()
            .contentType("application/json")
            .body(payload)
            .when()
            .post(endpoint);
}


    public static Response deleteById(String endpoint, String id) {
        return given()
                .pathParam("id", id)
                .when()
                .delete(endpoint);
    }


    public static Response patchById(String endpoint, String id, Object body) {
        return given()
                .contentType("application/json")
                .pathParam("id", id)
                .body(body)
                .when()
                .patch(endpoint);
    }



   
    }

