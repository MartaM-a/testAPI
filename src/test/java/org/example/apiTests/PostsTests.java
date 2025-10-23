package org.example.apiTests;
import org.example.config.ApiConfig;
import org.example.models.Post;
import org.example.models.User;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.example.config.ApiConfig.POSTS_ENDPOINT;
import static org.example.config.ApiConfig.POST_BY_ID_ENDPOINT;
import static org.example.utils.ClientAPI.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PostsTests {
    @Test
    public void getAllPosts() {
        getAll(POSTS_ENDPOINT).then()
                .log().all()
                .statusCode(200).body(matchesJsonSchemaInClasspath("schemas/post_list_schema.json"));

    }

    @Test
    public void getPostByIdSuccessful() {
        getById(POST_BY_ID_ENDPOINT, "2").then()
                .log().all()
                .statusCode(200).body(matchesJsonSchemaInClasspath("schemas/post_schema.json"));
    }

    @Test
    public void getPostByIdUnSuccessful() {
        getById(POST_BY_ID_ENDPOINT, "7000").then()
                .log().all()
                .statusCode(404).body(equalTo("{}"));

    }

    @Test
    public void createNewPost() {

        Post post = new Post();

        post.userId = 1;
        post.id = 101;
        post.title = "New Post Title";
        post.body = "This is the body of the new post.";

        Post artykol = new Post();
        artykol = post(ApiConfig.POSTS_ENDPOINT, post).then().statusCode(201)
                .body("userId", equalTo(1))
                .body("id", equalTo(101))
                .body("title", equalTo("New Post Title"))
                .body("body", equalTo("This is the body of the new post.")).extract().as(Post.class);


    }


    @Test
    public void createRandomPostTest() {
        Post post = Post.createRandomPost();

        given()
                .contentType("application/json")
                .body(post)
                .when()
                .post(ApiConfig.POSTS_ENDPOINT)
                .then()
                .log().all()
                .statusCode(201)
                .body("id", notNullValue());

    }
@Test
    public void delete_post_by_id_successful() {
        deleteById(POST_BY_ID_ENDPOINT, "1").then()
                .statusCode(200)
                .body(equalTo("{}"));
    }
    @Test
    public void delete_post_by_id_NotSuccessful() {
        deleteById(POST_BY_ID_ENDPOINT, " ").then()
                .statusCode(404)
                .body(equalTo("{}"));
    }

    @Test
    public void patchPostWithObjectTest() {
        Post patchPost = new Post();
        patchPost.setTitle("Updated title");

        given()
                .contentType("application/json")
                .pathParam("id", 1)
                .body(patchPost)
                .when()
                .patch(ApiConfig.POST_BY_ID_ENDPOINT)
                .then()
                .log().all()
                .statusCode(200)
                .body("title", equalTo(patchPost.getTitle()));
    }
}