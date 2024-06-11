package com.demoblaze.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {
            "json:target/cucumber.json",
            "html:target/html-reports.html",
            "rerun:target/rerun.txt"
    },
    features = "src/test/resources",
        glue = "com/demoblaze/step_definitions",
        dryRun = true,
        tags = ""



)
public class Demoblaze_Runner {
}
