package api.endpoints;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static api.builders.SpecBuilder.requestSpec;
import static io.restassured.RestAssured.given;

public class UserEndPoints {
    static Response response;
    public static Response createUser(User payload){
        response = given().spec(requestSpec()).body(payload).when().post(Routes.postUrl);
        return response;
    }
    public static Response getUser(String userName){
        response = given().spec(requestSpec()).pathParam("username",userName).when().get(Routes.getUrl);
        return response;
    }
    public static Response updateUser(User payload,String userName){
        response = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("username",userName).body(payload).when().put(Routes.updateUrl);
        return response;
    }
    public static Response deleteUser(String userName){
        response = given().spec(requestSpec()).pathParam("username",userName).when().delete(Routes.deleteUrl);
        return response;
    }
}
