package com.mobilepurchase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MobilePurchaseSteps {
	static WebDriver driver;

	@Given("Go to flipcart page")
	public void go_to_flipcart_page() {
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
driver.get("https://www.flipkart.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@Given("skip the login bar")
	public void skip_the_login_bar() {
		try {WebElement w=driver.findElement(By.xpath("//button[text()='✕']"));
		w.isDisplayed();
		w.click();
	}catch(Exception e) {
		System.out.println("not required");
	}}
	
	@When("User search for mobile")
	public void user_search_for_mobile() {
	WebElement w=	driver.findElement(By.name("q"));
	phone1="iphone";
	
	w.sendKeys("iphone",Keys.ENTER);
		WebElement search=driver.findElement(By.xpath("(//div[contains(text(),'"+phone1+"')])[2]"));
	  String s=search.getText();
	System.out.println("mobile name is:"+s);
	search.click();
	}

	@When("user enter the mobile name and click")
	public void user_enter_the_mobile_name_and_click() {
String parent=driver.getWindowHandle();
		
		Set<String> child=driver.getWindowHandles();
		
		for(String x:child) {
			if(!x.equals(parent)) {
				driver.switchTo().window(x);
				System.out.println("windows");
			}
		}
	}
	

	@Then("User click the buy now option")
	public void user_click_the_buy_now_option() {
		WebElement buy=	driver.findElement(By.xpath("//button[text()='BUY NOW']"));// TODO Auto-generated method stub
		Assert.assertTrue(buy.isDisplayed());
		WebElement search=driver.findElement(By.xpath("//span[contains(text(),'"+phone1+"')]"));
		String ssss=search.getText();
		System.out.println("mobile name is:"+ssss);

	}

	@When("User search for mobile by one dim list")
	public void user_search_for_mobile_by_one_dim_list(io.cucumber.datatable.DataTable dataTable) {
	List<String> datas=dataTable.asList(String.class);
	
	phone1=datas.get(2);
	
	WebElement w=driver.findElement(By.name("q"));
	w.sendKeys(datas.get(2),Keys.ENTER);
	
	
	}
	static String phone1;
	@When("User search for mobile by one dim map")
	public void user_search_for_mobile_by_one_dim_map(io.cucumber.datatable.DataTable dataTable) {
	   Map<String,String> datas= dataTable.asMap(String.class,String.class);
	   phone1=datas.get("sam");
	   WebElement w=driver.findElement(By.name("q"));
		w.sendKeys(datas.get("sam"),Keys.ENTER);
		
	}   

}