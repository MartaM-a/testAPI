package org.example.apiTests;
import org.junit.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.example.config.ApiConfig.POSTS_ENDPOINT;
import static org.example.utils.ClientAPI.getAll;
public class PostsTests {
    @Test
    public void getAllPosts () {
        getAll(POSTS_ENDPOINT).then().log().all().statusCode(200).body(matchesJsonSchemaInClasspath("schemas/posts_list_schema.json"));
    }
}
