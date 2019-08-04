package testNgtest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import keyword.Constants;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Keyword {
	private static String DateAndTime = new SimpleDateFormat("ss").format(new Date());

	/**
	 * launch the Browser
	 * 
	 * @param browsername
	 */
    
	public static void openBrowser(String browsername) {

		switch (browsername.toLowerCase()) {
		case "chrome":
				Constants.driver = new ChromeDriver();
				break;
		case "firefox":
			if (browsername.equalsIgnoreCase("FIREFOX")) {
				Constants.driver = new FirefoxDriver();

				break;
			}
		case "ie":
			if (browsername.equalsIgnoreCase("IE")) {
				Constants.driver = new InternetExplorerDriver();
				break;
			}
		case "opera":
			Constants.driver = new OperaDriver();
			break;
		default:
			System.out.println("No such broswer found or invalid broswer name");
			break;

		}
	}

	/**
	 * 
	 * @param locatorType it should be in lower Case .
	 * @param locator
	 * @return
	 */
	private static WebElement getData(String locatorType, String locator) {

		switch (locatorType) {
		case "xpath":
			Constants.element = Constants.driver.findElement(By.xpath(locator));

			break;
		case "name":
			Constants.element = Constants.driver.findElement(By.name(locator));

			break;
		case "id":
			Constants.element = Constants.driver.findElement(By.id(locator));

			break;
		case "linkText":
			Constants.element = Constants.driver.findElement(By.linkText(locator));

			break;
		case "partialLinkText":
			Constants.element = Constants.driver.findElement(By.partialLinkText(locator));

			break;
		case "cssSelector":
			Constants.element = Constants.driver.findElement(By.cssSelector(locator));

			break;
		case "tagName":
			Constants.element = Constants.driver.findElement(By.tagName(locator));

			break;
		case "className":
			Constants.element = Constants.driver.findElement(By.className(locator));

			break;
		default:
			System.out.println("Locator Type or Locator Value didn't find");

			break;
		}
		return Constants.element;
	}

	/**
	 * maximize your webPage
	 */
	public static void windowMaximize() {
		Constants.driver.manage().window().maximize();

	}
	
	/**
	 * Use to wait the WebPage or WebElement for particular seconds
	 * 
	 * @param timeInMiliSeconds
	 */
	public static void sleepTime(long timeInMiliSeconds) {
		try {
			Thread.sleep(timeInMiliSeconds);

		} catch (InterruptedException e) {
			System.out.println("Invalid TimeSecond" + e.getMessage());
		}
	}

	/**
	 * This Method to launch the webPage
	 * 
	 * @param url which you want to open
	 */
	public static void LaunchUrl(String url) {
		Constants.driver.get(url);

	}

	/**
	 * close your current HomePage
	 */
	public static void closeBrowser() {
		Constants.driver.close();

	}
/**
 * 
 * @return
 */
	public static Actions getActionObject() {
		Actions a = new Actions(Constants.driver);
		return a;
	}
      
	/**
	 * Close All WebBrowser Tab open in Browser
	 */
	public static void quiteBrowsers() {
		Constants.driver.quit();

	}

	/**
	 * 
	 * @param timeInSecond
	 * @param time_Unit    is the unit which is use for time duration
	 * 
	 */
	public static void implicitWaitTime(long timeInSecond, String time_Unit) {
		switch (time_Unit) {
		case "seconds":
			if (time_Unit.equalsIgnoreCase("SECONDS")) {
				Constants.driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.SECONDS);

				break;
			}
		case "hours":
			if (time_Unit.equalsIgnoreCase("HOURS")) {
				Constants.driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.HOURS);

				break;
			}
		case "days":
			if (time_Unit.equalsIgnoreCase("DAYS")) {
				Constants.driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.DAYS);

				break;
			}
		case "minutes":
			if (time_Unit.equalsIgnoreCase("MINUTES")) {
				Constants.driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.MINUTES);

				break;
			}
		}

	}

	/**
	 * 
	 * @param time
	 * @return
	 */
	public static FluentWait explicitWaitTime(long time) {
		FluentWait wait = new FluentWait(Constants.driver);
		wait.pollingEvery(100, TimeUnit.MILLISECONDS);
		wait.withTimeout(time, TimeUnit.SECONDS);
		wait.ignoring(TimeoutException.class);
		wait.ignoring(NoSuchElementException.class);
		return wait;
	}

	/**
	 * 
	 * @param time
	 */
	public static void waitForAlert(long time) {
		explicitWaitTime(time).until(ExpectedConditions.alertIsPresent());
	}

	/**
	 * 
	 */
	public static void takeScreen_Shot() {
		AShot shot = new AShot();
		Date date = new Date();
		// SimpleDateFormat Format = new SimpleDateFormat("E, dd MMM yyyy, HH_mm_ss");
		// String DateFormat = Format.format(date);
		Constants.screenshot = shot.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(Constants.driver);
		//Constants.screenshot = shot.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(Constants.driver);
		try {
			ImageIO.write(Constants.screenshot.getImage(), "PNG",
					new File("./Screenshots\\" + DateAndTime + ".png"));

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param driver
	 */
	public static void currentPageAshot() {
		AShot shot = new AShot();
		Screenshot a = shot.takeScreenshot(Constants.driver);
		// Screenshot a =
		// shot.shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		try {
			ImageIO.write(a.getImage(), "JPG", new File("./Screenshots\\"+DateAndTime+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param driver
	 */
	public static void defaultScreenShot() {
		/* TakesScreenShot is an interface 
		 * WebDriverException on failure.
		 * 
		 * @throws UnsupportedOperationException if the underlying implementation does
		 * not support screenshot capturing.
		 * File is a class 
		 */ 
		File screenshot = ((TakesScreenshot) Constants.driver).getScreenshotAs(OutputType.FILE);
		try { 
			// for new file == null it throws nullPointerException
			FileUtils.copyFile(screenshot, new File("./Screenshots\\"+DateAndTime+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * 
	 * @param locatorType
	 * @param locator
	 */
	public static void onClick(String locatorType, String locator) {
		getData(locatorType, locator).click();

	}
     
	public static Select performOnSelect(String locatorType ,String locator) {
		Select sc = new Select(getData(locatorType, locator));
		return sc;
		
	}
	/**
	 * 
	 * @param locatorType
	 * @param locator
	 * @param text_Value
	 */
	public static void sendValue(String locatorType, String locator, String text_Value) {
		getData(locatorType, locator).sendKeys(text_Value);

	}

	/**
	 * 
	 */
	public static void handleAlert() {
		Alert alert = Constants.driver.switchTo().alert();
		alert.dismiss();
		Constants.driver.switchTo().defaultContent();
	}

	/**
	 * Use to check String has digit or Not
	 * 
	 * @param str String which is digit or not
	 * @return boolean true or false
	 */
	private static boolean isNumeric(String str) {
		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}

	/**
	 * 
	 * @param locatorType
	 * @param locator
	 * @param nameOrIdOrInt_Index
	 */
	public static void handleFrame(String locatorType, String locator, String nameOrIdOrInt_Index) {
		if (isNumeric(nameOrIdOrInt_Index)) {
			Constants.driver.switchTo().frame(Integer.parseInt(nameOrIdOrInt_Index));
			getData(locatorType, locator).click();
			Constants.driver.switchTo().defaultContent();
		} else {
			Constants.driver.switchTo().frame(nameOrIdOrInt_Index);
			getData(locatorType, locator).click();
			Constants.driver.switchTo().defaultContent();
		}
	}

	/**
	 * 
	 * @param locatorType
	 * @param locator
	 * @param index
	 */
	public static void selectDropDown(String locatorType, String locator, int index) {

		Select sel = new Select(getData(locatorType, locator));
		sel.selectByIndex(index);
	}

	/**
	 * 
	 * @param locatorType
	 * @param locator
	 * @param by_Value
	 */
	public static void selectDropDown(String locatorType, String locator, String by_Value) {
		Select sel = new Select(getData(locatorType, locator));
		sel.selectByValue(by_Value);
	}

	/**
	 * 
	 * @param locatorType
	 * @param locator
	 */
	public static void handlePopUp(String locatorType, String locator) {
		getData(locatorType, locator).click();
	}

	/**
	 * 
	 * @param locatorType
	 * @param locator
	 * @param text
	 */
	public static void getDynamicText(String locatorType, String locator, String text) {
		Constants.element = getData(locatorType, locator);
		Constants.element.sendKeys(text);
		Constants.element.sendKeys(Keys.ARROW_DOWN);
		Constants.element.sendKeys(Keys.ENTER);
	}

	public static void certificateHandle() {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	}
    public static  void javaScriptExecution() {
    	JavascriptExecutor js = (JavascriptExecutor) Constants.driver;
    	js.executeScript("window.scrollBy(0,1000)");
    }
	/**
	 * 
	 */
	public static void switchToDefault() {
		Constants.driver.switchTo().defaultContent();
	}

	/**
	 * 
	 * @return
	 */
	public static Alert getAlert() {

		return Constants.driver.switchTo().alert();
	}

	/**
	 * 
	 */
	public static void AcceptAlert() {

		getAlert().accept();
	}

	/**
	 * 
	 */
	public static void DismissAlert() {

		getAlert().dismiss();
	}

	/**
	 * 
	 * @return
	 */
	public static String getAlertText() {
		String text = getAlert().getText();

		return text;
	}

	/**
	 * 
	 * @return
	 */
	public static boolean isAlertPresent() {
		try {
			Constants.driver.switchTo().alert();

			return true;
		} catch (NoAlertPresentException e) {

			return false;
		}
	}

	/**
	 * 
	 */
	public static void AcceptAlertIfPresent() {
		if (!isAlertPresent())
			AcceptAlert();

	}

	/**
	 * 
	 */
	public static void DismissAlertIfPresent() {

		if (!isAlertPresent())
			DismissAlert();

	}

	/**
	 * 
	 * @param text
	 */
	public void AcceptPrompt(String text) {
		Alert alert = getAlert();
		alert.sendKeys(text);
		alert.accept();

	}

	/**
	 * 
	 * @param locatorType
	 * @param locator
	 */
	@Deprecated
	public void elementScreenShot(String locatorType, String locator) {
		getData(locatorType, locator);
		Point point = Constants.element.getLocation();
		int ht = Constants.element.getSize().getHeight();
		int wt = Constants.element.getSize().getWidth();
		File src = ((TakesScreenshot) Constants.driver).getScreenshotAs(OutputType.FILE);
		try {
			BufferedImage fullimage = ImageIO.read(src);
			BufferedImage logo = fullimage.getSubimage(point.getX(), point.getY(), wt, ht);
			ImageIO.write(logo, "png", src);
			FileUtils.copyFile(src, new File("E:\\Newjava\\KDD\\AllScreenshot\\" + DateAndTime + ".png"));

		} catch (IOException e) {
			System.out.println("File Not found: ");
		}
	}

	/**
	 * It will get a WebElement screenshot on DOM
	 * 
	 * @param element
	 */
	public static void elementOnPageScreenShot(String locatorType, String locator) {
		getData(locatorType, locator);
		AShot shot = new AShot();
		Screenshot a = shot.coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(Constants.driver,
				Constants.element);
		try {
			ImageIO.write(a.getImage(), "PNG", new File("./Screenshots\\" + DateAndTime + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
/**
 * 
 */
	public static void elementOnPageScreenShot(String testName) {
		AShot shot = new AShot();
		Screenshot a = shot.coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(Constants.driver,
				Constants.element);
		try {
			ImageIO.write(a.getImage(), "PNG", new File("./Screenshots\\" + testName+DateAndTime + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * This method is used to get all cookies in the form of array .
	 * 
	 * @param driver
	 * @return it will return all cookies in arrays.
	 */
	public Set getCookies() {
		Set<Cookie> cookies = Constants.driver.manage().getCookies();
		return cookies;
	}

	/***
	 * 
	 * @param driver
	 * @return it will return {@code int} size of all cookies
	 */
	public int cookieSize() {
		Set<Cookie> cookies = Constants.driver.manage().getCookies();
		return cookies.size();
	}

	/***
	 * 
	 * @param driver
	 */
	public Cookie cookieName() {
//    	 Set<Cookie> cookies  = driver.manage().getCookies();
//    	 for (Cookie string : cookies) {
// 			System.out.println(string.getName());
// 		}
		// System.out.println(driver.manage().getCookieNamed("session-id-time"));
		return Constants.driver.manage().getCookieNamed("session-id-time");
	}

	public void addCookie(String name, String value) {
		Cookie cookies = new Cookie(name, value);
		Constants.driver.manage().addCookie(cookies);

	}

	/**
	 * 
	 * @return
	 */
	public String getCookieName() {
		String name = "";
		Set<Cookie> cookies = Constants.driver.manage().getCookies();
		for (Cookie string : cookies) {
			name = string.getName();
		}
		return name;
	}

	/**
	 * 
	 */
	public void deletcookies() {
		Constants.driver.manage().deleteAllCookies();
	}
}
