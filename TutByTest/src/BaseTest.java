import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	
	public void runBaseTest(Browsers browser) throws InterruptedException  {
		
		WebDriver driver;

		switch (browser) {

		case FireFox:

			System.setProperty("webdriver.gecko.driver", "./src/Recources/geckodriver.exe");

			driver = new FirefoxDriver();

			driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);

			TestFlowTutBy.testFlowSteps(driver, browser);
			
			TestFlowGmail.testFlowSteps(driver);

			
		case Chrome:

			System.setProperty("webdriver.chrome.driver", "./src/Recources/chromedriver.exe");

			driver = new ChromeDriver();

			driver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);

			TestFlowTutBy.testFlowSteps(driver, browser);
			
			TestFlowGmail.testFlowSteps(driver);
			
			break;
		}
	}
}
