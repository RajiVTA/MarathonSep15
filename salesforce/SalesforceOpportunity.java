package marathon1.sep15.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceOpportunity {

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
				//driver.findElement(By.xpath("//button[text()='View All']")).click();
				driver.findElement(By.xpath("//button[text()='View All']/parent::lightning-button")).click();
				
				//12. click Sales from App Launcher
				driver.findElement(By.xpath("(//p[@class='slds-truncate'])[6]")).click();
				Thread.sleep(5000);
				
				// 13. Click on Opportunity tab 
						
				WebElement opp = driver.findElement(By.xpath("(//a[@class='slds-context-bar__label-action dndItem'])[2]"));
				driver.executeScript("arguments[0].click()", opp);
				Thread.sleep(5000);
				
				// 14. Click on New button
				driver.findElement(By.xpath("//div[text()='New']")).click();
				
				// 15. Enter 'your name' as account name
				driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("QA");
				
				// 16. choose close date
				//driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[1")).click();
				
				WebElement closeDate = driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-input-has-icon slds-input-has-icon_right']"));
				closeDate.click();
				closeDate.sendKeys("09/29/2022");
						
				// 17. click stage
								
				driver.findElement(By.xpath("//button[contains(@class,'slds-input_faux')]")).click();
				//driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input-value')]")).click();
				Thread.sleep(3000);
				
				WebElement stageEle = driver.findElement(By.xpath("(//lightning-icon[@class='slds-input__icon slds-input__icon_right slds-icon-utility-down slds-icon_container'])[1]"));
				driver.executeScript("arguments[0].click()", stageEle);
				WebElement findElement2 = driver.findElement(By.xpath("(//span[@class='slds-media__body'])[2]/span"));
				driver.executeScript("arguments[0].click();", findElement2);
				Thread.sleep(9000);
														
				// 18. click save
				
				driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
				String nameVerify = driver.findElement(By.xpath("(//a[@class='forceActionLink'])[2]")).getAttribute("title");
				System.out.println("Opportunity name is "+nameVerify);
				if(nameVerify.contains("QA"))
				{
					System.out.println("Opportunity name is verified");
				}
				else
				{
					System.out.println("Opportunity name is not verified");
				}
				
				// 20. Close the browser
				//driver.close();
	}

}
