package marathon1.sep15.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		
		
		// 1	Launch the browser
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// 2. Type "Chennai" in the FROM text box
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']/li[@data-id='123']")).click();
		
		// 3. Type "Bangalore" in the TO text box
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//ul[@class='autoFill homeSearch']/li[@data-id='122']")).click();
		
		// 4. Select tomorrow's date in the Date field
		driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
		//driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		driver.findElement(By.xpath("//td[text()='25']")).click();
		
		// 5. Click Search Buses
		driver.findElement(By.xpath("//div[@class='clearfix search-wrap']/button[@id='search_btn']")).click();
		Thread.sleep(6000);
		
		// 6. Print the number of buses shown as results (104 Buses found)
		String totalBuses = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("Total number of matching buses found is  " + totalBuses);
		
		// 7 . Close the redbus primo notification
        driver.findElement(By.xpath("//i[@class='icon icon-close']")).click();
        
        // 8. Choose SLEEPER in the left menu
        driver.findElement(By.xpath("(//label[@class='custom-checkbox'])[6]")).click();
        Thread.sleep(5000);
        
        // 9 . Click on view seats
       driver.findElement(By.xpath("(//div[@class='clearfix m-top-16']/div[text()='View Seats'])[1]")).click();
      // Thread.sleep(5000);
       
       // 10 . print the starting price
       String startPrice = driver.findElement(By.xpath("(//div[@class='fare d-block'])[1]")).getText();
       System.out.println("Starting price is   " +startPrice  + "  " );
       
           
       // 11. Print the available seats
       String seat = driver.findElement(By.xpath("(//div[@class='seat-left m-top-30'])[1]")).getText();
       System.out.println(seat);
          
      

	}

}
