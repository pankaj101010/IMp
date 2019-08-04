package javaT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertTesting {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
    	driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
    	driver.findElement(By.xpath("(//button[@class='btn btn-default btn-lg'])[2]")).click();
    	Thread.sleep(1000);
    	driver.switchTo().alert().sendKeys("hsodi");
    	Thread.sleep(3000);
    	driver.switchTo().alert().accept();
	}

}
