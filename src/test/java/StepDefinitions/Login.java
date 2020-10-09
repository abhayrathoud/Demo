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
	Response re;
	@Given("Rates API for Specific date Foreign Exchange rates")
	public void rates_API_for_Specific_date_Foreign_Exchange_rates() {
	    System.out.println("API launch for foreign rates");
	}

	@When("The API is available for foreign")
	public void the_API_is_available_for_foreign() {
	    re=given().get("https://api.ratesapi.io/api/2020-09-10");
	}

	@Then("success status")
	public void success_status() {
	    System.out.println("status code"+ re.getStatusCode());
	    Assert.assertEquals(200,re.getStatusCode());
	}
	@Then("response assertion")
	public void response_assertion() {
	    re.then().body("base",equalTo("EUR") );
	    System.out.println("assertion for response");
	    
	}
	@When("A future date is provided in the url")
	public void a_future_date_is_provided_in_the_url() {
	    re=given().get("https://api.ratesapi.io/api/2020-12-10");
	}

	@Then("future validation")
	public void future_validation() {
	    re.then().body("date", equalTo("2020-10-08"));
	    System.out.println("future data validation");
	}
	


}
