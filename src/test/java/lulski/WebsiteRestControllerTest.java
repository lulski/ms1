package lulski;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= WebEnvironment.RANDOM_PORT)
public class WebsiteRestControllerTest {

    @LocalServerPort
    private int port;



    @Test
    public void website_api_returns_navigation_menu_items(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;


        RestAssured.when().get("/api/website/getnavmenu").then()
        .statusCode(HttpStatus.SC_OK)
        .body(matchesJsonSchemaInClasspath("getnavmenu.json"));


    }
}