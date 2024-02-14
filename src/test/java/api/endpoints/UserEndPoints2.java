package api.endpoints;

import api.enums.APIResources;
import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static api.builders.SpecBuilder.requestSpec;
import static api.builders.SpecBuilder.requestSpec2;
import static io.restassured.RestAssured.given;

public class UserEndPoints2 {
    static Response response;
    public static Response createUser(User payload){
        response = given().spec(requestSpec2()).body(payload).when().post(APIResources.createUser.getResource());
        return response;
    }
    public static Response getUser(String userName){
        response = given().spec(requestSpec2()).when().get(APIResources.getUser.getResource()+"/"+userName);
        return response;
    }
    public static Response updateUser(User payload,String userName){
        response = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("username",userName).body(payload).when().put(Routes.updateUrl);
        return response;
    }
    public static Response deleteUser(String userName){
        response = given().spec(requestSpec2()).when().delete(APIResources.deleteUser.getResource()+"/"+userName);
        return response;
    }
}
