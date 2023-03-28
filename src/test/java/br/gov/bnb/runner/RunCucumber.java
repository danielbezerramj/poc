package br.gov.bnb.runner;

import br.gov.bnb.pages.HomePage;
import br.gov.bnb.pages.LoginPage;
import br.gov.bnb.wrapper.BaseWeb;
import br.support.ReadProperties;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "br.gov.bnb.cucumber")
public class RunCucumber extends BaseWeb {

}
