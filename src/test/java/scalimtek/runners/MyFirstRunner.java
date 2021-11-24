package scalimtek.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * Runner de ejemplo
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty"
                , "html:reportes/html/index.html"
                , "json:reportes/json/reporteCucumber.json"
                , "de.monochromata.cucumber.report.PrettyReports:reportes"
        }
        , features = {"src/test/java/scalimtek/features"}
        , glue = {"scalimtek/stepdefs"}
        , snippets = CucumberOptions.SnippetType.CAMELCASE
        , monochrome = false
        , tags = "@regressionTest and @otraetiqueta"
)
public class MyFirstRunner {
}