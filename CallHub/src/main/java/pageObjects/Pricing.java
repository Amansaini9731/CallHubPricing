package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Pricing {

	
	public WebDriver driver;
	public By monthly=By.xpath("//h6[text()='Monthly']/ancestor::li");
	By quarterly=By.xpath("//h6[text()='Quarterly']/ancestor::li");
	By halfYearly=By.xpath("//h6[text()='Half-yearly']/ancestor::li");
	By yearly=By.xpath("//h6[text()='Yearly']/ancestor::li");
	public By payAsYouGo=By.xpath("//h5[text()='Pay as you go']/parent::div/div//h3");
	public By business=By.xpath("//h5[text()='Business']/parent::div/div//h3");
	public By businessSaveAmount=By.xpath("(//h5[text()='Business']/ancestor::div[1]//tr/td[3]//span)[1]");
	public By businessBilled=By.xpath("//h5[text()='Business']/ancestor::div[1]//tr/td[3]/div[2]//small/span[3]");
	public By premium=By.xpath("//h5[text()='Premium']/parent::div/div//h3");
	public By premiumSaveAmount=By.xpath("(//h5[text()='Premium']/ancestor::div[1]//tr/td[4]//span)[1]");
	public By premiumBilled=By.xpath("//h5[text()='Premium']/ancestor::div[1]//tr/td[4]/div[2]//small/span[3]");
	public By businessBilledwihtoutDiscount=By.xpath("//h5[text()='Business']/ancestor::div[1]//tr/td[3]/div[2]//small/span[2]/del");
	public By premiumBilledwihtoutDiscount=By.xpath("//h5[text()='Premium']/ancestor::div[1]//tr/td[4]/div[2]//small/span[2]/del");
	public Pricing(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement monthlySub()
	{
		return driver.findElement(monthly);
	}
	public WebElement quarterlySub()
	{
		return driver.findElement(quarterly);
	}public WebElement halfYearlySub()
	{
		return driver.findElement(halfYearly);
	}public WebElement yearlySub()
	{
		return driver.findElement(yearly);
	}
	public WebElement payAsYouGoAmount()
	{
		return driver.findElement(payAsYouGo);
	}
	public WebElement businessAmount()
	{
		return driver.findElement(business);
	}
	public WebElement premiumAmount()
	{
		return driver.findElement(premium);
	}
	public WebElement businessBilledAmount()
	{
		return driver.findElement(businessBilled);
	}
	public WebElement premiumBilledAmount()
	{
		return driver.findElement(premiumBilled);
	}
	public WebElement businessAmountsave()
	{
		return driver.findElement(businessSaveAmount);
	}
	public WebElement premiumAmountsave()
	{
		return driver.findElement(premiumSaveAmount);
	}
	public WebElement businessBilledWithoutSave()
	{
		return driver.findElement(businessBilledwihtoutDiscount);
	}
	public WebElement premiumBilledWithoutSave()
	{
		return driver.findElement(premiumBilledwihtoutDiscount);
	}
}
