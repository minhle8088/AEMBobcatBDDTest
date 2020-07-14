package com.citi.aem.bobcatbddtest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/features/login", plugin = { "pretty",
		"html:target/cucumber-login-html-report", "json:target/cucumber-login-report.json" })
public class RunLoginTest {
	// empty
}
