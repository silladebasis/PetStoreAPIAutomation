package api.tests;

import api.endpoints.UserEndPoints2;
import api.payloads.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UserTests2 {
    Faker faker = new Faker();
    User userPayload = new User();
    Response response;
    @BeforeClass
    public void setUp(){
        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().emailAddress());
        userPayload.setPassword(faker.internet().password());
        userPayload.setPhone(faker.phoneNumber().cellPhone());
    }
    @Test(priority = 1)
    public void testCreateUser(){
        response = UserEndPoints2.createUser(userPayload);
        assertThat(response.statusCode(),equalTo(200));
    }
    @Test(priority = 2)
    public void testGetUserByName(){
        response = UserEndPoints2.getUser(userPayload.getUsername());
        assertThat(response.statusCode(),equalTo(200));
    }
    @Test(priority = 3)
    public void testDeleteUser(){
        response = UserEndPoints2.deleteUser(userPayload.getUsername());
        assertThat(response.getStatusCode(),equalTo(200));
    }
}
