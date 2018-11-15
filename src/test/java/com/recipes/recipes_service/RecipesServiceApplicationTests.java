package com.recipes.recipes_service;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.get;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RecipesServiceApplicationTests {

    @LocalServerPort
    private int port;

    @Before
    public void setup()  {
        RestAssured.port = port;
        RestAssured.basePath = "/api";
    }

    @Test
    public void shouldReturnAllRecipes() {

        get("/receitas")
            .then()
                .log()
                .all()
                .and()
                .statusCode(200);
    }
}
