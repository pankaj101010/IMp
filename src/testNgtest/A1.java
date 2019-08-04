package testNgtest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class A1 {
	@Test(groups="Ab")
 public void test_01() {
	 System.out.println("this is test_01");
	 Assert.assertFalse(false);
 }
	@Test(dependsOnGroups= {"Ab"})
	 public void test_02() {
		 System.out.println("this is test_02");
	 }
	@Test(groups= {"Ab"})
	 public void test_03() {
		 System.out.println("this is test_03");
	 }
	@Test(dependsOnMethods={"test_01"})
	 public void test_04() {
		 System.out.println("this is test_04");
	 }
	@Test(groups= {"Ab"})
	 public void test_05() {
		 System.out.println("this is test_05");
	 }
}
