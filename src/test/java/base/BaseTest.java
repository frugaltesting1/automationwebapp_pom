package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utility.Config;

import java.util.concurrent.TimeUnit;

public class BaseTest {
	public WebDriver driver;
	public String baseURL;
	Config config = new Config();
	
	
	protected String userEmail="sumanth@frugaltesting.com";
	protected String userPassword="Tesla@2021";

	public String userFirstName = "Ashwin";
	public String userLastName = "R";
	public String userMiddleName = "";

	public String city = "Chennai";
	public String state = "Tamil Nadu";
	public String country = "India";

	public void setup() {
		System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		
		options.setHeadless(true);
		options.addArguments("--start-maximized");
		options.addArguments("--lang=en_US");

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		baseURL=config.getBaseUrl();
		driver.get(baseURL);
	}

}
