package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Pricing;
import resources.base;

public class QuaterlySubscriptionTest extends base {
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

	public static String splitFun2(String a) {
		String b[] = a.split("<!");
		String bi = b[0];
		String d = bi.substring(14);
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
	public void quarterlySubscriptionTest() throws InterruptedException {

		Thread.sleep(3000);
		p.quarterlySub().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(p.business));
		String s4 = p.payAsYouGoAmount().getText();
		log.info("Quarterly - pay as you go price fetched:-{}", s4);
		String s5 = p.businessAmount().getText();
		log.info("Quarterly  - Business price fetched:-${}/mo", splitFun1(s5));
		Thread.sleep(2000);
		String s6 = p.businessBilledAmount().getAttribute("innerHTML");
		log.info("Quarterly  - Business billed price fetched:-${}/qa", splitFun2(s6));
		String s7 = p.premiumAmount().getText();
		log.info("Quarterly  - premium  price fetched:-${}/mo", splitFun1(s7));
		Thread.sleep(2000);
		String s8 = p.premiumBilledAmount().getAttribute("innerHTML");
		log.info("Quarterly  - premium billed price fetched:-${}/qa", splitFun2(s8));
		String s9 = p.businessAmountsave().getAttribute("innerHTML").substring(14);

		log.info("Quarterly  - Business Saved amount fetched:-${}", s9);
		String s10 = p.premiumAmountsave().getAttribute("innerHTML").substring(14);
		log.info("Quarterly  - Premium Saved amount fetched:-${}", s10);
		String s11 = p.businessBilledWithoutSave().getAttribute("innerHTML");

		log.info("Quarterly  - Business Billed amount without saving fetched:-${}", s11);
		String s12 = p.premiumBilledWithoutSave().getAttribute("innerHTML");
		log.info("Quarterly  - Premium Billed amount without saving fetched:-${}", s12);
		

		String t1 = splitFun1(s5);
		float f1 = Math.round(Float.parseFloat(t1));
		String t2 = splitFun2(s6);
		float f2 = Math.round(Float.parseFloat(t2));
		if (f1 * 3 == f2) {
			log.info("Quarterly ----Test Passed-- Business billed Price  of   ${}",t2);
			Assert.assertTrue(true);

		} else {
			log.error("Quarterly -----Test failed -----Business billed Price for value ${} on place of ${}", f1 * 3, f2);
			Assert.assertTrue(false);
		}
		String t3 = splitFun1(s7);
		float f3 = Math.round(Float.parseFloat(t3));
		String t4 = splitFun2(s8);
		float f4 = Math.round(Float.parseFloat(t4));
		if (f3 * 3 == f4) {
			log.info("Quarterly ----Test Passed----Premium billed Price  of amount ${}",t4);
			Assert.assertTrue(true);

		} else {
			log.error("Quarterly -----Test failed---Premium billed Price for value ${} on place of ${}", f3 * 3, f4);
			Assert.assertTrue(false);
		}
		float k1=Float.parseFloat(s11);
		
		if (k1-Float.parseFloat(t2) == Float.parseFloat(s9)) {
			log.info("Quarterly -----Test Passed---Business billed Saving ${}  ",s9);
			Assert.assertTrue(true);

		} else {
			log.error("Quarterly -----Test Failed---Business billed Saving ${}  ",s9);
			Assert.assertTrue(false);
		}
		float k2=Float.parseFloat(s12);
		if (Math.round(k2-Float.parseFloat(t4)) == Math.round(Float.parseFloat(s10))) {
			log.info("Quarterly ----Test Passed---Premium billed Saving ${}  ",s10);
			Assert.assertTrue(true);

		} else {
			log.error("Quarterly ----Test failed-----Premium  billed Saving ${} ",s10);
			Assert.assertTrue(false);
		}
		

	}

	@AfterTest
	public void teardown() {

		driver.close();

	}

}
