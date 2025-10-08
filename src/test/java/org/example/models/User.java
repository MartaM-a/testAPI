
package org.example.models;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor


public class User {
    public Long id;
    public String username;
    public String email;
    public String title;



    public static User createRandom() {
        Faker faker = new Faker();
        User user = new User();
        user.id = faker.number().randomNumber();
        user.username = faker.friends().character();
        user.email = faker.internet().emailAddress();
        user.title = faker.funnyName().name();
        return user;

    }

}