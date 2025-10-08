
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


    public static User createRandom() {
        Faker faker = new Faker();
        User user = new User();
        user.id = faker.number().randomNumber();
        user.username = faker.name().username();
        user.email = faker.internet().emailAddress();
        return user;

    }

}