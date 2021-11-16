package testrunners;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberOptions;

import io.cucumber.testng.TestNGCucumberRunner;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

@CucumberOptions(
		features =  "./resources/AppFeatures" , 
		glue = { "stepdefination", "AppHooks" },
		tags=  "@Runt",
		plugin = {
		"pretty", "html:test-output", "json:target/cucumberjson/bdd.json", "junit:target/cucumberxml/bdd.xml",
		 }
		
		 
)
public class MyTestRunner {

	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass(alwaysRun=true)
	public void setUpClass()throws Exception{
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	@Test(groups="cucumber", description="Run Cucumber Feature",dataProvider="features")
	public void feature(PickleWrapper pickleEvent, FeatureWrapper 
		    cucumberFeature) {
		testNGCucumberRunner.runScenario(pickleEvent.getPickle());
			//	getCucumberFeature());
		
	//	testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
	}
	
	@DataProvider
	public Object[][] features(){
		return testNGCucumberRunner.provideScenarios();
	}
	
	
	@AfterClass
	public static void tearDown() {
		File reportOutputDirectory = new File("target/maven-cucumber-report");
		List<String> jsonFiles = new ArrayList<String>();
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
