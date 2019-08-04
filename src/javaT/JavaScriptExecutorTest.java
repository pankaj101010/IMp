package javaT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import keyword.Keyword;

public class JavaScriptExecutorTest {
	
	@Test
	public void test_01() {
		Keyword.openBrowser("chrome");
		Keyword.LaunchUrl("http://fb.com");
		Keyword.ScrollPageVertically(1200);
		
		
		//Keyword.javaScriptExecution().executeScript(script, args);
	}

}
