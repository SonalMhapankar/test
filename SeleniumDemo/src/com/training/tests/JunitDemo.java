package com.training.tests;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JunitDemo extends BaseTest {
	WebDriver driver = new ChromeDriver();// webdriver object

	@Test
	public void test() {
		System.out.println("menthod - test");
		driver.findElement(By.xpath(".//*[@id='treemenu']/.//*[contains(text(),'List Box')]")).click();
		driver.findElement(By.xpath(".//*[@id='treemenu']/.//*[contains(text(),'JQuery List Box')]")).click();

		WebElement selectJListBox = driver.findElement(By.cssSelector(".form-control.pickListSelect.pickData"));
		Select nameSelect = new Select(selectJListBox);
		nameSelect.selectByVisibleText("Alice");
		nameSelect.selectByVisibleText("Isabella");
		nameSelect.selectByVisibleText("Luiza");
		driver.findElement(By.xpath(".//*[@id='pickList']/.//*[contains(text(),'Add')]")).click();
	}

	@Test
	public void newTest() {
		driver.findElement(By.xpath(".//*[@id='treemenu']/.//*[contains(text(),'Date pickers')]")).click();
		driver.findElement(By.xpath(".//*[@id='treemenu']/.//*[contains(text(),'Bootstrap Date Picker')]")).click();
		driver.findElement(By.cssSelector(".glyphicon.glyphicon-th")).click();
		driver.findElement(By.xpath(".//*[@class='datepicker-switch' and contains(text(),'October 2017')]")).click();
		driver.findElement(By.xpath(".//*[@class='month' and contains(text(),'Sep')]")).click();
		driver.findElement(By.xpath(".//*[@class='day' and contains(text(),'9')]")).click();

	}

	@Test
	public void alert() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='treemenu']/.//*[contains(text(),'Alerts & Modals')]")).click();
		driver.findElement(By.xpath(".//*[@id='treemenu']/.//*[contains(text(),'Javascript Alerts')]")).click();
		driver.findElement(By.xpath(".//*[@onclick='myPromptFunction()']")).click();

		Alert alert = driver.switchTo().alert();
		alert.sendKeys("test");
		Thread.sleep(2000);
		alert.accept();

	}

	@Test
	public void modalDemo() {
		driver.findElement(By.xpath(".//*[@id='treemenu']/.//*[contains(text(),'Alerts & Modals')]")).click();
		driver.findElement(By.xpath(".//*[@id='treemenu']/.//*[contains(text(),'Window Popup Modal')]")).click();
		driver.findElement(By.xpath(".//*[contains(text(),'Follow On Twitter')]")).click();

		String mainWindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		ArrayList<String> allwindowList = new ArrayList<String>(allwindows);
		driver.switchTo().window(allwindowList.get(1));
		driver.manage().window().maximize();

	}

	@Test
	public void frameExample() throws InterruptedException {
		System.out.println("inside frameExample method");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.navigate().to("https://developer.mozilla.org/en-US/docs/Web/HTML/Element/iframe");
		WebDriver element = wait
				.until(ExpectedConditions.
						frameToBeAvailableAndSwitchToIt(By.xpath(".//*[@id='main']/div[3]/iframe")));
		String name=element.findElement(By.xpath(".//*[@id='mapDiv']/.//a[contains(text(),'Ampliar el mapa')]")).getText();
		System.out.println(name);
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void actionExample()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		boolean isPopupPresent=driver.findElement(By.xpath(".//*[@class='_2AkmmA _29YdH8']")).isDisplayed();
		if (isPopupPresent)
		{
			driver.findElement(By.xpath(".//*[@class='_2AkmmA _29YdH8']")).click();
		}
		else
		{
		Actions builder=new Actions(driver);
		WebElement findElectronics=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@title='Electronics']")));
		Action mouseOverMenu=builder.moveToElement(findElectronics).build();
		mouseOverMenu.perform();
		//WebElement findApple=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@title='Apple']")));
		driver.findElement(By.xpath(".//*[@title='Apple']"));
		
	}
	}

	@Before
	public void beforeTest() {
		System.out.println("menthod - before");

		WebDriverWait driverwait = new WebDriverWait(driver, 10); // explicit wait
		//driver.get("http://www.seleniumeasy.com/test/");
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
	}

	@After
	public void afterTest() throws InterruptedException {
		System.out.println("menthod - after");
		Thread.sleep(10000);
		driver.close();
		driver.quit();
	}

}
