package Academy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Pricing;
import resources.base;

public class MonthlySubscriptionTest extends base {
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(base.class.getName());
	WebDriverWait wait;
	Pricing p;

	public static String splitFun1(String a) {
		String b[] = a.split("/");
		String bi = b[0];
		String d = bi.substring(1);
		return d;
	}

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();

	}

	@Test(priority = 0)

	public void SetupMethod() throws IOException, InterruptedException {
		wait = new WebDriverWait(driver, 10);
		driver.get(prop.getProperty("url"));

		log.info("Pricing page opened");
		p = new Pricing(driver);
	}

	@Test(priority = 1)
	public void monthlySubscriptionTest() throws InterruptedException {
		Thread.sleep(3000);
		p.monthlySub().click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(p.business));
		String s1 = p.payAsYouGoAmount().getText();
		log.info("Monthly - pay as you go price fetched:-{}", s1);
		String s2 = p.businessAmount().getText();
		log.info("Monthly - Business price fetched:-${}/mo", splitFun1(s2));
		String s3 = p.premiumAmount().getText();
		log.info("Monthly - premium price fetched:-${}/mo", splitFun1(s3));
	}

	@AfterTest
	public void teardown() {

		driver.close();

	}
}
