package com.BrowsersTest;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestFlowTutBy {

	public static void testFlowSteps(WebDriver driver, Browsers browser) throws InterruptedException {

		driver.get("https://www.tut.by/");

		String mainWindowHandle = driver.getWindowHandle();

		if (browser == Browsers.Chrome) {

			driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe[1]")));

			WebElement closePush = (new WebDriverWait(driver, TutByAndGmailTest.WAITING))
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='welcomeClose']")));

			Actions builder = new Actions(driver);

			closePush.isDisplayed();

			builder.moveToElement(closePush).click().build().perform();

			driver.switchTo().defaultContent();

		}

		WebElement commercialLink = (new WebDriverWait(driver, TutByAndGmailTest.WAITING)).until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//a[contains(@href, 'https://tutby.com/advert/price/')]")));

		commercialLink.isDisplayed();

		commercialLink.click();

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(1));

		WebElement headerText = (new WebDriverWait(driver, TutByAndGmailTest.WAITING))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Размещение рекламы']")));

		headerText.isDisplayed();

		String actualTitle = driver.getTitle();

		String expectedTitle = "Стоимость рекламы TUT.BY";

		EqualTitle.assertEquals(actualTitle, expectedTitle);

		driver.close();

		driver.switchTo().window(mainWindowHandle);

		ElementPresence.isElementPresent(driver, By.id("search_from_str"));

	}
}
