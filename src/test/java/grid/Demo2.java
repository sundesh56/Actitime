package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Demo2 {
	
	public static void main(String[]args) throws MalformedURLException, InterruptedException {
		
	    URL url = new URL("https://oauth-sundesh56-aa7e8:ac2f07dc-5f1a-46e0-9b2c-e7dc92d07aff@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
	    ChromeOptions options = new ChromeOptions();
		WebDriver driver = new RemoteWebDriver(url, options);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		
		for (int i = 1; i <= 10; i++) {
			
		driver.findElement(By.name("q")).sendKeys("Selenium");
		Thread.sleep(500);
		driver.findElement(By.name("q")).clear();
		Thread.sleep(500);
		}
		driver.quit();
	}

}
