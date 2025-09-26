package org.example.utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ClientAPI {
    public static Response getAll(String endpoint) {
        return get(endpoint);
    }

    public static Response getById(String endpoint, String id) {
        return// get(endpoint.replace("{id}", id));


                given().pathParam("id", id).when().get(endpoint);



    }

}
