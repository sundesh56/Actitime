package generic;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public WebDriver driver;
	public WebDriverWait wait;

	@BeforeMethod
	public void openApp() throws Exception {

		String useGrid = Utility.getPropertyValue("./Config.properties", "USEGRID");
		Reporter.log("use Grid" + useGrid, true);

		String gridURL = Utility.getPropertyValue("./Config.properties", "GRIDURL");
		Reporter.log("Grid URL" + gridURL, true);

		String appURL = Utility.getPropertyValue("./Config.properties", "URL");

		String strITO = Utility.getPropertyValue("./Config.properties", "ITO");
		int intITO = Integer.parseInt(strITO);

		String strETO = Utility.getPropertyValue("./Config.properties", "ETO");
		int intETO = Integer.parseInt(strETO);

		String browser = Utility.getPropertyValue("./Config.properties", "Browser");

		if (useGrid.equalsIgnoreCase("YES")) {
			URL url = new URL(gridURL);

			if (browser.equalsIgnoreCase("Chrome")) {
				ChromeOptions options = new ChromeOptions();
				driver = new RemoteWebDriver(url, options);

			} else if (browser.equalsIgnoreCase("edge")) {

				EdgeOptions options = new EdgeOptions();
				driver = new RemoteWebDriver(url, options);

			} else {

				Reporter.log("Invalid browser", true);
			}

		} else {

			if (browser.equals("Chrome")) {
				driver = new ChromeDriver();

			} else {
				driver = new EdgeDriver();

			}
			
		}

			driver.manage().window().maximize();
			driver.get(appURL);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(intITO));
			wait = new WebDriverWait(driver, Duration.ofSeconds(intETO));

		

	}

	@AfterMethod
	public void close() {

		driver.quit();
	}

}
