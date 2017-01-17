import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestFlowTutBy {

	public static void testFlowSteps(WebDriver driver) throws InterruptedException {

		driver.get("https://www.tut.by/");

		String mainWindowHandle = driver.getWindowHandle();

		WebElement commercialLink = (new WebDriverWait(driver, 10)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//a[contains(@href, 'https://tutby.com/advert/price/')]")));

		commercialLink.click();

		Thread.sleep(1000);

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(1));

		String actualTitle = driver.getTitle();

		String expectedTitle = "Стоимость рекламы TUT.BY";

		EqualTitle.assertEquals(actualTitle, expectedTitle);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		ElementPresence.isElementPresent(driver, By.id("search_from_str") );

		driver.quit();
	}
}
