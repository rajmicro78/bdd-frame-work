package testrunners;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

@RunWith(Cucumber.class)
//@RunWith(SerenityRunner.class)
@CucumberOptions(features = { "./src/test/resources/AppFeatures" }, glue = { "stepdefination", "AppHooks" }, plugin = {
		"pretty", "html:test-output", "json:target/cucumberjson/bdd.json", "junit:target/cucumberxml/bdd.xml",
		 }, monochrome = true, dryRun = false,
		 tags= "@Run"
		 // "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/test.html","json:target/cucumber-report.json"}
//"de.monochromata.cucumber.report.PrettyReports:target/maven-cucumber-report"
)
public class MyTestRunner {
	//@SuppressWarnings("unchecked")
	
	@AfterClass
	public static void tearDown() {
		File reportOutputDirectory = new File("target/maven-cucumber-report");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add("target/cucumberjson/bdd.json");
		// jsonFiles.add("cucumber-report-2.json");

		String buildNumber = "2011Release";
		String projectName = "BON Automation Report";

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		// optional configuration - check javadoc for details
//	configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
		// do not make scenario failed when step has status SKIPPED
//		configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
		configuration.setBuildNumber(buildNumber);
		// addidtional metadata presented on main page
		configuration.addClassifications("Platform", "Windows");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Branch", "release/2021.0.1.760");

		// optionally add metadata presented on main page via properties file
//		List<String> classificationFiles = new ArrayList<>();
//		classificationFiles.add("properties-1.properties");
//		classificationFiles.add("properties-2.properties");
//		configuration.addClassificationFiles(classificationFiles);

		// optionally specify qualifiers for each of the report json files
//		configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);
//		configuration.setQualifier("cucumber-report-1", "First report");
//		configuration.setQualifier("cucumber-report-2", "Second report");

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		Reportable result = reportBuilder.generateReports();
		// and here validate 'result' to decide what to do if report has failed
	}

}
