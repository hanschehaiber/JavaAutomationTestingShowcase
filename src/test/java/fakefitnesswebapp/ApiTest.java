package fakefitnesswebapp;

import com.fakefitnesswebapp.domain.Exercise;
import com.fakefitnesswebapp.domain.Workout;
import io.restassured.response.Response;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
import org.assertj.core.api.SoftAssertions;

import com.github.tomakehurst.wiremock.junit.WireMockRule;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;


public class ApiTest {
    @Rule
    public WireMockRule wireMockRule = new WireMockRule();

    @Test
    public void testFitnessAppApi() {
        SoftAssertions softly = new SoftAssertions();

        String requestPath = "workout.json";
        String baseUrl = "http://localhost";
        String endpointUrl = "/exercises";

        stubFor(get(urlEqualTo(endpointUrl))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "text/json")
                        .withBodyFile(requestPath)));

        Response response = given().
                baseUri(baseUrl).
                when().
                get(endpointUrl).
                then().extract().response();

        Workout workout = response.getBody().as(Workout.class);
        List<Exercise> exerciseList = workout.getExercises();
        for(Exercise exercise: exerciseList) {
            if(exercise.getName().equals("Squats")) {
                softly.assertThat(exercise.getReps())
                        .as("Squat Reps")
                        .isEqualTo(12);
            }
        }

        softly.assertAll();
    }

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
