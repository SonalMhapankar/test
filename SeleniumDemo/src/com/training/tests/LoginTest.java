package com.training.tests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String args[]) throws InterruptedException
	{
		System.out.println("Login Test Class");
		//chrome driver path
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\lenovo\\Desktop\\IDE Test Cases\\sw\\chromedriver.exe");
		
		//firefox
	//	System.setProperty("webdriver.gecko.driver", 
			//	"C:\\Users\\lenovo\\Desktop\\IDE Test Cases\\sw\\geckodriver.exe");
		
		
		WebDriver driver= new ChromeDriver();//webdriver object
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS); //implicit wait
		WebDriverWait driverwait=new WebDriverWait(driver,10); //explicit wait
		driverwait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("email"))); //explicit wait
		
		driver.get("http://www.facebook.com");
		
		WebElement emailElement = driver.findElement(By.id("emailss"));
		emailElement.sendKeys("mmmusername");
		
		WebElement passElement=driver.findElement(By.name("pass"));
		passElement.sendKeys("mypassword");
		WebElement loginElement=driver.findElement(By.cssSelector("input[data-testid=royal_login_button][value='Log In']"));
		//loginElement.click();
		
		WebElement dobday=driver.findElement(By.id("day"));
		WebElement dobmonth=driver.findElement(By.id("month"));
		WebElement dobyear=driver.findElement(By.id("year"));
		WebElement sex=driver.findElement(By.xpath(".//*[@name='sex' and @value='1']"));
		
		Select selectday = new Select(dobday);
		Select selectmonth = new Select(dobmonth);
		Select selectyear = new Select(dobyear);
		
		
		selectday.selectByVisibleText("26");
		selectmonth.selectByIndex(3);
		selectyear.selectByValue("1992");
		sex.click();
		
		Thread.sleep(1000);
		
		driver.close();
		driver.quit(); // to close all the browser windows opened due to automation
	}
	

}
