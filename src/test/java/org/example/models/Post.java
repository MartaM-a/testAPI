
package org.example.models;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor


    public class Post {
        public Integer userId;
        public Integer id;
        public String title;
        public String body;


        public static Post createRandomPost() {
            Faker faker = new Faker();
            Post post = new Post();
            post.id = faker.number().numberBetween(1, Integer.MAX_VALUE);
            post.userId = faker.number().numberBetween(1,Integer.MAX_VALUE);
            post.title = faker.book().title();
            post.body = faker.lorem().paragraph();

            return post;
        }
    }