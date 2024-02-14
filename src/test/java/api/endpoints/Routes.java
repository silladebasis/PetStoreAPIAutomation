package api.endpoints;
/*
PetStore API's Endpoints
Create User - https://petstore.swagger.io/v2/user
Get User - https://petstore.swagger.io/v2/user/123
Delete User - https://petstore.swagger.io/v2/user/123
Update User - https://petstore.swagger.io/v2/user/123
 */
public class Routes {
    private static String baseURI = "https://petstore.swagger.io/";
    private static String basePath = "v2";
    public static String postUrl = baseURI + basePath + "/user";
    public static String getUrl = baseURI + basePath + "/user/{username}";
    public static String updateUrl = baseURI + basePath + "/user/{username}";
    public static String deleteUrl = baseURI + basePath + "/user/{username}";

}
