package testNgtest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Keyword.takeScreen_Shot();
		Keyword.elementOnPageScreenShot(result.getName());
		System.out.println("passed"+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
	Keyword.elementOnPageScreenShot(result.getName());
	System.out.println("failed"+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		Keyword.openBrowser("chrome");
		System.out.println("browser is open :"+ context.getName());
		Keyword.LaunchUrl("http://fb.com");
	}

	@Override
	public void onFinish(ITestContext context) {
			Keyword.closeBrowser();
	}

}
