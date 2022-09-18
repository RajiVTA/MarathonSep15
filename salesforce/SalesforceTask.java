package marathon1.sep15.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceTask {

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
		Thread.sleep(8000);
		
		// 10. Click on Global Actions SVG icon
	
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		Thread.sleep(2000);
		
		//11. click View All
		//driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//button[text()='View All']/parent::lightning-button")).click();
		
		//12.Type Task and select Task
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Task");
		WebElement findElement = driver.findElement(By.xpath("//a[@class='al-tab-item']"));
		driver.executeScript("arguments[0].click()", findElement);
		
		//13. Click New Task under drop down icon
		driver.findElement(By.xpath("//a[contains(@class,'slds-button--icon-border-filled')]")).click();
	
		driver.findElement(By.xpath("//a[@title='New Task']")).click();
		Thread.sleep(3000);
		
		//14. Enter subject as Bootcamp
		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).sendKeys("Bootcamp");
		
		//15.Select status as 'Waiting on someone else'
		driver.findElement(By.xpath("(//a[@class='select'])[1]")).click();
		Thread.sleep(3000);
		WebElement stat = driver.findElement(By.xpath("(//li[contains(@class,'uiRadioMenuItem')])[5]"));
		driver.executeScript("arguments[0].click()", stat);
		
		WebElement stat1 = driver.findElement(By.xpath("(//li[contains(@class,'uiRadioMenuItem')])[5]/a"));
		driver.executeScript("arguments[0].click()", stat1);
		
		//16. Save and create a Task verified message
		
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		
		String taskVerify = driver.findElement(By.xpath("(//a[@class='forceActionLink'])[4]")).getAttribute("title");
		System.out.println("Task name is "+taskVerify);
		if(taskVerify.contains("Bootcamp"))
		{
			System.out.println("Task name is verified");
		}
		else
		{
			System.out.println("Task name is not verified");
		}
		
		// 20. Close the browser
		//driver.close();*/
		

	}

}
