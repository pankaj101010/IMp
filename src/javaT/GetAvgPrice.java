package javaT;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAvgPrice {
public static void main(String[] args) throws InterruptedException {
	 WebDriver driver = new ChromeDriver();
	  driver.get("https://www.flipkart.com/");
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ' and //*[@type='text']]")).sendKeys("pankajdevgade10@gmail.com");
	  driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ' and //*[@type='password']]")).sendKeys("1234");
	  driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//input[@name='q']")).sendKeys("iphone");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
	  Thread.sleep(1000);
	  List<WebElement>iphone = driver.findElements(By.xpath("//div[@class='_1uv9Cb']/div[@class='_1vC4OE _2rQ-NK']"));
	  System.out.println(iphone.size());
	  int sum=0;
	  for (int i = 0; i <iphone.size(); i++) {
		     String iphoneprice = iphone.get(i).getText().replaceAll("[^0-9]", "");
		      sum += Integer.parseInt(iphoneprice);
	}
	  System.out.println(sum/iphone.size());
 }
}
