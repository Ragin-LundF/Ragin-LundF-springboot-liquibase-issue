package io.github.sbliquibase.bdd

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    features = [
        "classpath:/cucumber/features",
    ],
    glue = [
        "classpath:com/ragin/bdd",
        "classpath:io/github"
    ],
    plugin = [
        "pretty",
        "html:build/reports/cucumber/cucumber.html",
        "json:build/reports/cucumber/cucumber.json",
        "junit:build/reports/cucumber/cucumber.xml"
    ],
    tags = "not @ignore and @burpScan"
)
class CucumberBurpRunner 
