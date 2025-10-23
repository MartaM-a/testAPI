
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
    public Integer id;
    public String name;
    public String username;
    public String email;
    public String street;
    public String suite;
    public String city;
    public String zipcode;
    public String lat;
    public String lng;
    public String phone;
    public String website;
    public String companyName;
    public String catchPhrase;
    public String bs;



            public static User createRandomUser() {
                Faker faker = new Faker();
                User user = new User();

                user.id = faker.number().numberBetween(1, 10000);
                user.name = faker.name().fullName();
                user.username = faker.name().username();
                user.email = faker.internet().emailAddress();

                user.street = faker.address().streetName();
                user.suite = "Apt. " + faker.number().numberBetween(1, 999);
                user.city = faker.address().city();
                user.zipcode = faker.address().zipCode();
                user.lat = faker.address().latitude();
                user.lng = faker.address().longitude();

                user.phone = faker.phoneNumber().phoneNumber();
                user.website = faker.internet().domainName();

                user.companyName = faker.company().name();
                user.catchPhrase = faker.company().catchPhrase();
                user.bs = faker.company().bs();

                return user;
            }
        }


//    public static User createRandom() {
//        Faker faker = new Faker();
//        User user = new User();
//        user.id = faker.number().numberBetween(1, Integer.MAX_VALUE);
//        user.username = faker.friends().character();
//        user.email = faker.internet().emailAddress();
//        user.title = faker.funnyName().name();
//        return user;





