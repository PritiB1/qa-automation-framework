package StepDefinitions;

import java.awt.Window;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GreenCartStepDef {

public WebDriver driver;
public String productName;
public String OfferProductName;
@Given("user is on GreenKart Home page")
public void user_is_on_green_kart_home_page() {
	
	System.setProperty("webdriver.chrome.driver","C://Users//pborhade//Downloads//chromedriver-win64//chromedriver-win64//chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
}

@When("user search with inital letters {string} on homepage and extracted Product")
public void user_search_with_inital_letters_on_homepage_and_extracted_product(String shortName) {
	driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	productName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
	System.out.println("Productname extracted from home page is "+ productName);
}

@Then("user searched same letters {string} on offers page")
public void user_searched_same_letters_on_offers_page(String shortName) {
   
	driver.findElement(By.xpath("//a[contains(text(),'Top Deals')]")).click();
	Set<String> allWindows = driver.getWindowHandles();
	Iterator<String> I1 = allWindows.iterator();
	String parentWin = I1.next();
	String childWin = I1.next();
	
	driver.switchTo().window(childWin);
	driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	OfferProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	
}

@Then("verify the product name on both pages")
public void verify_the_product_name_on_both_pages() {
	Assert.assertEquals(productName, OfferProductName);
}

	
}
