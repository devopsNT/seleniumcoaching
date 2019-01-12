package webDriverDay6.jsexecutor;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class AWikiWDTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeMethod
public void setUp() throws Exception {
  
	System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver-64bit.exe");
  //	driver = new ChromeDriver();
  	
 //   System.setProperty("webdriver.ie.driver", "test\\resources\\IEDriverServer.exe");
  //	driver = new InternetExplorerDriver();
	  
	  
	  driver = new FirefoxDriver();
    baseUrl = "http://www.wikipedia.org/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTCWikiKetan() {
    	  driver.get(baseUrl);
//    driver.findElement(By.cssSelector("strong")).click();
    
    WebElement englishLink= driver.findElement(By.id("js-link-box-en"));
 //   WebElementExtender.highlightElement(englishLink);
    englishLink.click();
    try {
		Thread.sleep(2000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
//    WebElementExtender.highlightElement(driver.findElement(By.id("searchInput")));
    driver.findElement(By.id("searchInput")).clear();
    driver.findElement(By.id("searchInput")).sendKeys("Selenium");
    try {
		Thread.sleep(2000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
 //   WebElementExtender.highlightElement(driver.findElement(By.id("searchButton")));
    driver.findElement(By.id("searchButton")).click();
    try {
		Thread.sleep(2000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    try {
      AssertJUnit.assertEquals("Selenium", driver.findElement(By.cssSelector("span")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      AssertJUnit.assertEquals("Selenium - Wikipedia, the free encyclopedia", driver.getTitle());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }

  @AfterMethod
public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
     // fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}