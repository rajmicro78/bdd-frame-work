package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;
import io.cucumber.java.*;

public class ApplicationHooks {

	private DriverFactory driverfactory;
	private WebDriver driver;
	private ConfigReader configreader;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		configreader = new ConfigReader();
		prop = configreader.init_prop();
	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver = driverfactory.init_driver(browserName);

	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}

	@After(order = 1)
	public void teardown(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotname = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotname);
		}

	}
}
