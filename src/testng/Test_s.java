package testng;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_s {

public class firsttest {
public WebDriver driver;

@BeforeTest()

public void login() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	
	driver.findElement(By.id("login-button")).click();
	
}
@Test(groups = "titel")
public void sore_item_low_to_high() { 
	driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")).click();
	driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[3]")).click();
	List<WebElement> thePriceList = driver.findElements(By.className("inventory_item_price"));
	List <Double> myNewEditList= new ArrayList <> ();
	for(int i = 0 ; i< thePriceList .size();i++ ) {
		
		String price = thePriceList.get(i).getText();
	//	price.trim();
		String editedprice =  price.replace("$"," ");
//		System.out.println("********************Befour***********************");
//		System.out.println(price);
//		System.out.println("--------------------------------------------------");
//		System.out.println(editedprice.trim());
		//System.out.println("********************Aftare***********************");
		Double val = Double.parseDouble(editedprice.trim());
		myNewEditList.add(val);
		
	}
	System.out.println(	myNewEditList);
//	System.out.println(myNewEditLis);
	for(int k = 0;k<myNewEditList.size();k++) {
	boolean checkProcess =  myNewEditList.get(0) < myNewEditList.get(myNewEditList.size()-1);
		Assert.assertEquals(checkProcess,true);
	}}
	
	@Test(groups = "titel")
	public void sore_item__high_to_low() {
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")).click();
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]")).click();
		List<WebElement> thePriceList2= driver.findElements(By.className("inventory_item_price"));
		List<Double>myNewEditListlow = new ArrayList<>();
	
		for(int i = 0 ; i< thePriceList2.size();i++ ) {
			
			String price = thePriceList2.get(i).getText();
			String editedprice2 =  price .replace("$"," ");
			Double vall= Double.parseDouble(editedprice2.trim());
			myNewEditListlow.add(vall);}
	System.out.println(myNewEditListlow);
			for(int k = 0;k<myNewEditListlow.size();k++) {
			boolean checkProcess2= myNewEditListlow.get(0)>myNewEditListlow.get(myNewEditListlow.size()-1);
				Assert.assertEquals(checkProcess2,true);
				}
//				
	}
			@Test(groups = "print")
			public void print_out() {
				
				System.out.println("logged out");
			}
//	String ActualTitel = driver.getTitle();
//	String ExpectedTitel = "github";
//	
//	Assert.assertEquals(ActualTitel,ExpectedTitel);

//

//}
}

}