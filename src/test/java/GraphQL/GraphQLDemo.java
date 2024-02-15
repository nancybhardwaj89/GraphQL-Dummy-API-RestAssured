package GraphQL;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GraphQLDemo {
    @Test
    public void testDummyAPI() {
        RestAssured.baseURI = "https://rickandmortyapi.com/graphql";
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{\"query\":\"query character($id: ID!) { character(id: $id) { origin { id } location { id } created }}\",\"variables\":{\"id\":\"1\"}}")
                .when()
                .post()
                .then()
                .extract()
                .response();
        response.prettyPrint();
    }
}
