

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAnnotation {
	@BeforeSuite
	public void BeforeSuiteMethod() {
		System.out.println("Inside Before Suite");
	}
	@BeforeTest
	public void BeforeTestMethod() {
		System.out.println("Inside Before Test");
	}
	@BeforeClass
	public void BeforeClassMethod() {
		System.out.println("Inside Before Class");
	}
	@BeforeMethod
	public void BeforeMethodTest() {
		System.out.println("Inside Before Method");
	}
	@Test
	public void Test01() {
		System.out.println("Inside Test01");	
	}
	@Test
	public void Test02() {
		System.out.println("Inside Test02");	
	}
	@Test(groups = {"Smoke","Regression"})
	public void Test03() {
		System.out.println("Inside Test03");	
	}
	@AfterSuite
	public void AfterSuiteMethod() {
		System.out.println("Inside After Suite");
	}
	@AfterTest
	public void AfterTestMethod() {
		System.out.println("Inside After Test Method");
	}
	@AfterClass
	public void AfterClassMethod() {
		System.out.println("Inside after Class");
	}
	@AfterMethod
	public void AfterMethodTest() {
		System.out.println("Inside after Method");
	}

}
