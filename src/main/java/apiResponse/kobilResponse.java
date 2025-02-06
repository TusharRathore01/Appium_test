package apiResponse;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public interface  kobilResponse {
    final String generateKobilTokenUrl = "https://idp.amplifi.cloud.test.kobil.com/auth/realms/amplifi/protocol/openid-connect/token";
    final String getUserDataUrl = "https://idp.amplifi.cloud.test.kobil.com/auth/realms/amplifi/v3_user/search";
    default String generatekobilToken()
    {
        Response response = given()
            .contentType("application/x-www-form-urlencoded")
            .header("Cookie","IDPROUTING=\"68c7f38e257910fe")
            .formParam("username","backend-user")
            .formParam("password","IiCOCIhuYXFNYzX5FUoM")
            .formParam("client_id","backend-client")
            .formParam("client_secret","MtkCPsY8HPPa7jZQVezqwCPRhZ2YJunT")
            .formParam("grant_type","password")
            .formParam("scope","openid")
            .when()
            .post(generateKobilTokenUrl)
            .then()
            .statusCode(200)
            .extract()
            .response();
          
        return response.jsonPath().getString("access_token");
    }

    default Response getUserData(String username){
        String token = generatekobilToken();
        Response response = given()
            .header("Authorization", "Bearer " + token)
            .queryParam("key", username)
            .when()
            .get(getUserDataUrl)
            .then()
            .statusCode(200)
            .extract()
            .response();
        
        return response;
    }

}
