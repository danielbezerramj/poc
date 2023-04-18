package br.gov.bnb.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@ RunWith(Cucumber.class)
<<<<<<< HEAD
@CucumberOptions(features = "src/test/resources/features", glue = "br.gov.bnb.cucumber", monochrome = true, plugin = {"pretty", "html:target/cucumber-reports.html"})
=======
@CucumberOptions(features = "src/test/resources/features", glue = "br.gov.bnb.cucumber", monochrome = true, plugin = {"pretty", "html:target/cucumber"})
>>>>>>> 03c743a44b36841961e53e14ce8de1709273f809
public class RunCucumberTest {

}
