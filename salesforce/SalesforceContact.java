package marathon1.sep15.salesforce;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceContact {

	public static void main(String[] args) throws InterruptedException {
		
		// 1.  setup the path
		WebDriverManager.chromedriver().setup();
		//ChromeDriver driver=new ChromeDriver();
		
		// 2. disable notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		
		// 3. create instance
		ChromeDriver driver=new ChromeDriver(options);
				
		// 4	Launch the browser
		driver.get("https://login.salesforce.com");
		
		// 5. manage ur window
		driver.manage().window().maximize();
		
		// 6. add wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// 7. enter username
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
		
		// 8. Enter password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password#123");
		
		// 9. Click login button
		driver.findElement(By.xpath("//input[@name='Login']")).click();
		
		// 10. Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		//11. click View All
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		//12. click Sales from App Launcher
		driver.findElement(By.xpath("(//p[@class='slds-truncate'])[6]")).click();
		
		// 13. Click on Opportunity tab 
				
		WebElement opp = driver.findElement(By.xpath("(//a[@class='slds-context-bar__label-action dndItem'])[2]"));
		driver.executeScript("arguments[0].click()", opp);
		Thread.sleep(5000);
		
		// 14. Click on Accounts tab
		WebElement acc = driver.findElement(By.xpath("(//a[@class='slds-context-bar__label-action dndItem'])[6]"));
		driver.executeScript("arguments[0].click()", acc);
		Thread.sleep(5000);
		
		// 15. Click on New button
		driver.findElement(By.xpath("//div[text()='New']")).click();
		Thread.sleep(4000);
		
		//16. Enter 'your name' as account name
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Eswari");
		
		//17. Select Ownership as Public
		
	
		driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]")).click();
	
		WebElement drop = driver.findElement(By.xpath("(//div[@class='slds-input__icon-group slds-input__icon-group_right']/lightning-icon)[4]"));
	
		driver.executeScript("arguments[0].click()", drop);
		driver.findElement(By.xpath("//span[text()='Public']")).click();
		Thread.sleep(6000);
		
		// 18. click save
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		//Thread.sleep(8000);
		
		// 19. verify message
		String nameVerify = driver.findElement(By.xpath("(//a[@class='forceActionLink'])[6]")).getAttribute("title");
		System.out.println("Account name is "+nameVerify);
		if(nameVerify.contains("Eswari"))
		{
			System.out.println("Account name is verified");
		}
		else
		{
			System.out.println("Account name is not verified");
		}
				
		

	}

}
