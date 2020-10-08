package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
public class Login {

	Response r;
	@Given("Rates API for Latest Foreign Exchange rates")
	public void rates_API_for_Latest_Foreign_Exchange_rates() {
		System.out.println("API Launch");
	}

	@When("The API is available")
	public void the_API_is_available() {
		
		r=given().get("https://api.ratesapi.io/api/latest");
	}

	@Then("Validte the code")
	public void validte_the_code() { 
		Assert.assertEquals(200,r.getStatusCode());
		System.out.println("status code="+r.getStatusCode());
	}
	@Then("Validte the response")
	public void validte_the_response() {
		r.then().body("base", equalTo("EUR"));
		System.out.println("body validation");

	}
	@When("An incorrect or incomplete url is provided")
	public void an_incorrect_or_incomplete_url_is_provided() {
		r=given().get("https://api.ratesapi.io/api/");
	}

	@Then("Validte the correct response")
	public void validte_the_correct_response() {
		System.out.println("incorrect url");
		r.then().body("error",equalTo("time data 'api' does not match format '%Y-%m-%d'"));
		
	}
	

}
