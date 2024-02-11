package api;

import io.restassured.response.Response;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;


public class ApiTest {
    @Rule
    public WireMockRule wireMockRule = new WireMockRule();

    @Test
    public void basicApiTest() {

        //create the mock of a random url
        stubFor(get(urlEqualTo("/some/thing"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "text/plain")
                        .withBody("Hello world!")));

        //Hit the mocked endpoint with RestAssured Request Spec and get a response
        Response response = given().
                baseUri("http://localhost").
                when().
                get("/some/thing").
                then().extract().response();

        Assert.assertEquals(200, response.statusCode());

        System.out.println(response.getBody().prettyPrint());
    }

    @Test
    public void testFullResponse() {
        String requestPath = "testResponse.json";
        stubFor(get(urlEqualTo("/body-file"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBodyFile(requestPath)));

        Response response = given().
                baseUri("http://localhost").
                when().
                get("/body-file").
                then().extract().response();

        Assert.assertEquals(200, response.statusCode());

        System.out.println(response.getBody().prettyPrint());
    }

}
