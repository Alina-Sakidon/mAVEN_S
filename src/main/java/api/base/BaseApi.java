package api.base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseApi {
    protected static RequestSpecification requestSpecification;

    public BaseApi() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2/store";
        requestSpecification = RestAssured.given()
                .contentType("application/json")
                .accept("application/json");
    }

}
