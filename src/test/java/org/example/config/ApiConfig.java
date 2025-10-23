package org.example.config;

import io.restassured.http.ContentType;

public class ApiConfig {
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    public static final String USERS_ENDPOINT = BASE_URL +"/users";
    public static final String POSTS_ENDPOINT = BASE_URL + "/posts";
    public static final String USER_BY_ID_ENDPOINT = BASE_URL + "/users/{id}";
    public static final ContentType CONTENT_TYPE = ContentType.JSON;
    public static final String POST_BY_ID_ENDPOINT=BASE_URL+"/posts/{id}";





}
