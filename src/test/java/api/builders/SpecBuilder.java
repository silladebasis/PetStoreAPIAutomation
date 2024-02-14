package api.builders;

import api.utils.PropertyReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class SpecBuilder {
    static RequestSpecification requestSpecification;
    public static RequestSpecification requestSpec(){
        requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON).setAccept(ContentType.JSON).
                                                    addFilter(new RequestLoggingFilter(LogDetail.ALL)).addFilter(new ResponseLoggingFilter(LogDetail.ALL)).build();
        return requestSpecification;
    }
    public static RequestSpecification requestSpec2(){
        //String base_uri = PropertyReader.readProperty().getProperty("baseURI");
        String base_uri = PropertyReader.readValue().getString("baseURI");
        requestSpecification = new RequestSpecBuilder().setBaseUri(base_uri).setContentType(ContentType.JSON).setAccept(ContentType.JSON).
                addFilter(new RequestLoggingFilter(LogDetail.ALL)).addFilter(new ResponseLoggingFilter(LogDetail.ALL)).build();
        return requestSpecification;
    }
}
