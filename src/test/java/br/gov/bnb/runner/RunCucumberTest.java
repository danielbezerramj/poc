package br.gov.bnb.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@ RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "br.gov.bnb.cucumber", monochrome = true, plugin = {"pretty", "html:target/cucumber-reports.html"})
public class RunCucumberTest {

}
