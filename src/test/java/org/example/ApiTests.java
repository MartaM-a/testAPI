package org.example;
import org.example.apiTests.PostsTests;
import org.example.apiTests.UserTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        UserTests.class,
        PostsTests.class
})
public class ApiTests {

}
