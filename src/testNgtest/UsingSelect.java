package testNgtest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(MyListener.class)
public class UsingSelect {
  @Test
  public void test_01() {
	  //Keyword.takeScreen_Shot();
	 System.out.println(Keyword.performOnSelect("id", "year")); 
	 //Keyword.takeScreen_Shot();
	  System.out.println("hi");
  }
  @Test
  public void test_02(){
	  Keyword.performOnSelect("id", "month").deselectAll();
  }
}
