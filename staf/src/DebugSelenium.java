import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DebugSelenium {

	public static void main(String[] args) {
		List<WebElement> elements = new ArrayList<WebElement>();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://enterprise.com");
		driver.manage().window().maximize();
		
//		WebElement element = driver.findElement(By.linkText("Modify an Existing Reservation"));
		driver.findElement(By.name("searchCriteria")).sendKeys(" 80110");
		driver.findElement(By.name("search")).click();
		elements = driver.findElements(By.tagName("table"));
		
		for(int i =0; i<elements.size();i++){
			WebElement element = elements.get(i);
			List<WebElement> rows = new ArrayList<WebElement>();
			rows = element.findElements(By.tagName("tr"));
			if(i==16){
				for(int j=0;j<rows.size();j++){
					if(j==6){
						List<WebElement> columns = rows.get(j).findElements(By.tagName("td"));
						for(int k =0;k<columns.size();k++){
							if(k==3){
								WebElement column = columns.get(k);
								System.out.println("Row number " + j + "Column number "+k );
								System.out.println(column.getText());
							}
						}
						
					}
					
				}
			}
		}
		
	}	
}


//driver.findElement(By.id("airportOnly")).click();
		
		//System.out.println(driver.findElement(By.id("airportOnly")).getAttribute("checked"));
		
/*		List <WebElement> elements = driver.findElements(By.tagName("checkbox"));
		//System.out.println(elements.size())*///;
		
		/*		for(WebElement element : elements){
			if(element.getAttribute("checked")!=null){
				System.out.println(element.getAttribute("value"));
				
			}
*/	//	}
		
//}	
		
		//driver.findElement(By.name("search")).click();
		
	/*	driver.findElement(By.xpath("//a[contains(@href,'changeAge')]")).click();
		
		List <WebElement> elements = driver.findElements(By.name("tagRadioGroup"));
		
		for(WebElement element : elements){
			if(element.getAttribute("checked")!=null){
				System.out.println(element.getAttribute("value"));
				
			}
		}*/
		
		/*List <WebElement> links  = driver.findElements(By.tagName("a"));and @name='searchCriteria'
		List <WebElement> ids = driver.findElements(By.id("searchLocation"));
		
		for(WebElement ele : links){
			
			System.out.println(ele.getAttribute("id"));
			
			
		}*/
		
		

/*		Boolean b = driver.findElement(By.partialLinkText("change")).isDisplayed();
		System.out.println(b);
		
		List <WebElement> links = driver.findElements(By.linkText("change"));
		
		int i = 0;
		for (WebElement myElement : links){
			if (i==0){
				myElement.click();
			}
			i=i+1;
		}
		
		System.out.println(i);
*/
	//}

//}
