package seleniumcoaching;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.*;
public class MavenTest {
  @Test
  public void f() {
	  System.out.println("Inside Test");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Inside BeforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Inside AfterMethod");
	//  fail("Test Case Failed");
  }

}
