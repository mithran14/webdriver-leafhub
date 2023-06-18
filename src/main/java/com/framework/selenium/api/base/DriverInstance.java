package com.framework.selenium.api.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.testng.AbstractTestNGCucumberTests;

public class DriverInstance  extends AbstractTestNGCucumberTests{

	private static final ThreadLocal<RemoteWebDriver> remoteWebdriver = new ThreadLocal<RemoteWebDriver>();
	private static final ThreadLocal<WebDriverWait> wait = new  ThreadLocal<WebDriverWait>();

	public void setWait() throws MalformedURLException, InterruptedException {
		wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(30)));
	}

	public WebDriverWait getWait() {
		return wait.get();
	}
	

	public void setDriver(String browser, boolean headless) {	
		DesiredCapabilities capabilities = new DesiredCapabilities();
       
        // Set the URL of the Selenium Grid Hub
        String seleniumGridUrl = "http://4.240.82.63:4444/wd/hub";
		switch (browser) {
		case "chrome":
			ChromeOptions chrome_options = new ChromeOptions();
			chrome_options.addArguments("--start-maximized"); 
			chrome_options.addArguments("--disable-notifications"); 
			 capabilities.setBrowserName("chrome");
		        capabilities.setVersion("114.0");
			try {
				remoteWebdriver.set(new RemoteWebDriver(new URL(seleniumGridUrl),
				        capabilities));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "firefox":
			FirefoxOptions firefox_options = new FirefoxOptions();
			firefox_options.addArguments("--no-sandbox");
			firefox_options.addArguments("--disable-dev-shm-usage"); 
			capabilities.setBrowserName("firefox");
	        capabilities.setVersion("114.0");
			try {
				remoteWebdriver.set(new RemoteWebDriver(new URL(seleniumGridUrl),
				        capabilities));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "msedge":
			capabilities.setBrowserName("MicrosoftEdge");
	        capabilities.setVersion("114.0");
			try {
				remoteWebdriver.set(new RemoteWebDriver(new URL(seleniumGridUrl),
				        capabilities));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		default:
			break;
		}
	}
	public RemoteWebDriver getDriver() {
		return remoteWebdriver.get();
		
	}
}
