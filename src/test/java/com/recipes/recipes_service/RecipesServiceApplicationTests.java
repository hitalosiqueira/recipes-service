package com.recipes.recipes_service;

import io.restassured.RestAssured;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

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

        get("/receitas").then().log().all().and()
                .statusCode(200)
                .assertThat().body("_embedded.recipes[0].name", equalTo("Brigadeiro"))
                .assertThat().body("_embedded.recipes[1].name", equalTo("Ovo frito"));
    }

    @Test
    public void shouldReturnARecipeById() {

        get("/receitas/1").then().log().all().and()
                .statusCode(200)
                .assertThat().body("name", equalTo("Brigadeiro"))
                .assertThat().body("portions", equalTo(4))
                .assertThat().body("calories", equalTo(500));
    }

    @Test
    public void shouldReturnARecipeIngredients() {

        get("/receitas/1/ingredientes").then().log().all().and()
                .statusCode(200)
                .assertThat().body("_embedded.ingredients[0].amount", equalTo("quatro colheres de sopa"))
                .assertThat().body("_embedded.ingredients[0]._links.ingredient.href", equalTo("http://localhost:"+ port +"/api/ingredientes/4"))
                .assertThat().body("_embedded.ingredients[1].amount", equalTo("uma colher de sopa"))
                .assertThat().body("_embedded.ingredients[1]._links.ingredient.href", equalTo("http://localhost:"+ port +"/api/ingredientes/9"))
                .assertThat().body("_embedded.ingredients[2].amount", equalTo("uma lata"))
                .assertThat().body("_embedded.ingredients[2]._links.ingredient.href", equalTo("http://localhost:"+ port +"/api/ingredientes/10"));
    }

    @Test
    public void shouldReturnAllRecipesWithAnIngredientById() {

        get("/receitas/-/ingredientes/10").then().log().all().and()
                .statusCode(200)
                .assertThat().body("_embedded.recipes[0].name", equalTo("Brigadeiro"))
                .assertThat().body("_embedded.recipes[0].portions", equalTo(4))
                .assertThat().body("_embedded.recipes[0].calories", equalTo(500));
    }

    @Test
    public void shouldReturnAllRecipesWithAnIngredientByName() {

        get("/receitas/leite condensado").then().log().all().and()
                .statusCode(200)
                .assertThat().body("_embedded.recipes[0].name", equalTo("Brigadeiro"))
                .assertThat().body("_embedded.recipes[0].portions", equalTo(4))
                .assertThat().body("_embedded.recipes[0].calories", equalTo(500));
    }

    @Test
    public void shouldReturnAllIngredients() {

        get("/ingredientes").then().log().all().and()
                .statusCode(200)
                .assertThat().body("_embedded.ingredients[0].name", equalTo("açucar"))
                .assertThat().body("_embedded.ingredients[1].name", equalTo("chocolate em pó"))
                .assertThat().body("_embedded.ingredients[2].name", equalTo("farinha"));
    }

    @Test
    public void shouldReturnAIngredient() {

        get("/ingredientes/1").then().log().all().and()
                .statusCode(200)
                .assertThat().body("name", equalTo("sal"));

    }

    @Test
    public void shouldCreateRecipe() throws Exception {
        JSONObject recipe = new JSONObject();
        JSONArray ingredients = new JSONArray();
        JSONObject ingredient1 = new JSONObject();
        JSONObject ingredient2 = new JSONObject();

        recipe.put("name", "mistureba");
        recipe.put("portions", 1);
        recipe.put("calories", 1000);
        recipe.put("instructions", "misture tudo e seja feliz");

        ingredient1.put("ingredient", "leite");
        ingredient1.put("amount", "meio litro");

        ingredient2.put("ingredient", "leite condensado");
        ingredient2.put("amount", "uma caixa");

        ingredients.put(ingredient1);
        ingredients.put(ingredient2);

        recipe.put("recipeIngredients", ingredients);

        given().contentType("application/json").body(recipe.toString()).when()
                .post("/receita").then().log().all().and()
                .statusCode(201)
                .assertThat().body("name", equalTo("mistureba"))
                .assertThat().body("portions", equalTo(1))
                .assertThat().body("calories", equalTo(1000))
                .assertThat().body("instructions", equalTo("misture tudo e seja feliz"));
    }

}
