package commerce.taf.cuc.runners;

import commerce.taf.tests.TestBase;
import cucumber.api.CucumberOptions;

@CucumberOptions(features = "src\\test\\java\\commerce\\taf\\cuc\\features"
,glue = {"commerce\\taf\\cuc\\steps"}
,plugin = {"pretty","html:target/cucumber-html-report"})
public class TestRunner extends TestBase{

}
