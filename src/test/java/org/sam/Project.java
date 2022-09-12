package org.sam;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.record.ContinueRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Project {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException, IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://kyro.pages.dev/");
		driver.manage().window().maximize();
		WebElement login = driver.findElement(By.className("LoginButton_login_button__ehTMa"));
		login.click();
		WebElement username = driver.findElement(By.id("username"));
		username.click();
		username.sendKeys("kishor2805@gmail.com");
		WebElement password = driver.findElement(By.id("password"));
		password.click();
		password.sendKeys("Kkkishor28@");
		WebElement signin = driver.findElement(By.name("action"));
		signin.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		WebElement dashboard = driver.findElement(
				By.xpath("//*[@class='MuiListItemText-root css-1tsvksn']//*[text()='Dashboard']"));
		dashboard.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		WebElement viewAll = driver
				.findElement(By.xpath("//*[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-3 css-vgxgpa']//*[text()='View All']"));
		viewAll.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		WebElement createTask = driver.findElement(By.xpath("//*[@class='MuiGrid-root MuiGrid-item css-tb1mij']//*[@type='button']"));
		createTask.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		WebElement summary = driver.findElement(By.id(":rt:"));
		summary.click();
		summary.sendKeys("App Creation");

		WebElement Tasktype = driver.findElement(By.id(":ru:"));
		Tasktype.click();
		Tasktype.sendKeys("html creation ");

		WebElement description = driver.findElement(By.id(":rv:"));
		description.click();
		description.sendKeys("In this we create application  ");

		WebElement priority = driver.findElement(By.id(":r10:"));
		priority.click();
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

		WebElement location = driver.findElement(By.id(":r11:"));
		location.click();
		location.sendKeys("Namakkal");

		WebElement Startdate = driver.findElement(By.id(":r12:"));
		Startdate.click();
		Startdate.sendKeys("28-05-2022");

		WebElement duedate = driver.findElement(By.id(":r13:"));
		duedate.click();
		duedate.sendKeys("08-12-2033");
		Thread.sleep(3000);
		WebElement submit = driver.findElement(By.xpath("(//*[@type='button'])[13]"));
		submit.click();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File perm = new File("C:\\Users\\kisho\\eclipse-workspace\\KyroProj\\Screenshot\\image1.png");
		FileHandler.copy(temp, perm);

		driver.quit();
	}

}
