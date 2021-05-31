package Testrunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)				
@CucumberOptions(
		  features = { "Features" },
		  glue = {"stepdefinations","Defination" },plugin = {"html:target/cucumber-html-report",
			        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
			        "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml"},
		  monochrome = true)
public class Testrunner {

	

}
