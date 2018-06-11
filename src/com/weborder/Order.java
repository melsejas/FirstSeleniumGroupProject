package com.weborder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"/Users/melisa/Documents/selenium dependencies/drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		//2 Go to website
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		
		//3 Login using username Tester and password test
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		
		//4 Click on Order link
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Process.aspx");
		
		//5 Enter a random quantity between 1 and 100
		Random random = new Random();
		int i = random.nextInt(99)+1;
		String f = "" + i;
		
		//6 Enter Customer Name: John <middle_name> Smith. 
		//Instead of <middle_name> your code should enter a random string every time.
		 int leftLimit = 97; // letter 'a'
		    int rightLimit = 122; // letter 'z'
		    int targetStringLength = 5;
		    Random random2 = new Random();
		    StringBuilder buffer = new StringBuilder(targetStringLength);
		    for (int z = 0; z < targetStringLength; z++) {
		        int randomLimitedInt = leftLimit + (int) 
		          (random2.nextFloat() * (rightLimit - leftLimit + 1));
		        buffer.append((char) randomLimitedInt);
		    }
		    String generatedString = buffer.toString();
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("John " + generatedString + " Smith");

		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(f);
		//7 Enter street: 123 Any st
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("123 Any st");
		//8 Enter City: Anytown
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Anytown");
		//9 Enter State: Virginia
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Virginia");
		//10
		Random random1 = new Random();
        int y = random1.nextInt(99999)+1;
        String z = "" + y;
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(z);
        //11 Select any card type. Every time your code should select a different type
        //12 Enter any card number. If you selected Visa, card number should start with 4. 
        //If you selected Master, card number should start with 5. If you selected American Express, card number should start with 3. 
        //New card number should be auto generated every time you run the test. Card numbers should be 16 digits for Visa and Master, 15 for American Express.
        int z1 = random.nextInt(3)+1;

		if(z1==1) {
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
			Random random3 = new Random();
			Random random4 = new Random();
			int a = random3.nextInt(9999999);
	        int b = random4.nextInt(99999999);
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(4 + "" + a + b);
		}else if(z1==2) {
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
			Random random3 = new Random();
			Random random4 = new Random();
			int a = random3.nextInt(9999999);
	        int b = random4.nextInt(99999999);
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(5 + "" + a + b );
		}else if (z1==3){
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
			Random random3 = new Random();
			Random random4 = new Random();
			int a = random3.nextInt(9999999);
	        int b = random4.nextInt(9999999);
			driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(3 + "" + a + b);
		}
        
        //13 Enter any valid expiration date 
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("08/21");
     
		//14 Click on Process
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
        
        //15 Verify than the page contains text New order has been successfully added
        String expected = "New order has been successfully added.";
		String text = driver.findElement(By.tagName("body")).getText();
		if (text.contains(expected)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
			System.out.println("Expected:\t" + expected);
		}
	
}
}