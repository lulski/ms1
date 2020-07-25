package lulski;

import org.apache.http.HttpStatus;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.web.server.LocalServerPort;


import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;


public class WebsiteRestControllerTest extends AbstractTest{

    @LocalServerPort
    private int port;




    @Test
    public void website_api_returns_navigation_menu_items(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;


        RestAssured.when().get("/api/website/getNavigationMenuItems").then()
        .statusCode(HttpStatus.SC_OK)
        .body(matchesJsonSchemaInClasspath("getnavmenu.json"));


    }
}