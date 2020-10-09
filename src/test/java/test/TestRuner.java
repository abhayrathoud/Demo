package test;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
	@CucumberOptions(
	 features = "D:\\abhay.rathoud\\workspace\\cucumber\\cucumber\\src\\test\\resources\\Features"
	 ,glue={"StepDefinitions"}
	 )
	 
	public class TestRuner {
	 
	}

