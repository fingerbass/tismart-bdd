package automationpractice.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Runner de compras en automationpractice.com
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty"
                , "html:reportes/html/index.html"
                , "json:reportes/json/reporteCucumber.json"
                , "de.monochromata.cucumber.report.PrettyReports:reportes"
        }
        , features = {"src/test/java/automationpractice/features"}
        , glue = {"automationpractice/stepdefs"}
        , snippets = CucumberOptions.SnippetType.CAMELCASE
        , monochrome = false
        // , tags = ""
)
public class runnerCompras {
}