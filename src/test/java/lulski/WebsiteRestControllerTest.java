package lulski;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= WebEnvironment.RANDOM_PORT)
public class WebsiteRestControllerTest {

    @LocalServerPort
	private int port;

    @Test
    public void website_api_returns_navigation_menu_items(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;

        RestAssured.when().get("/api/website/getnavmenu").then().statusCode(200);

    }
}