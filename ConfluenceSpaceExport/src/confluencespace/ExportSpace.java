package confluencespace;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExportSpace {
		
	public final static String loginURL = "https://docops-dev.ca.com/login.action";
	public final static String spacebaseURL = "https://docops-dev.ca.com/spaces/exportspacexml.action?key=";
	
	public static void main(String[] args) {
		BufferedReader br = null;
		String spaceUrl;
		WebDriver driver = null;
		String driverpath = args[0];
		String spaceUrlspath = args[1];
		
		try {			
			//Initializing the ChromeDriver by changing the default downloads path		
			System.setProperty("webdriver.chrome.driver",driverpath);		
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);
			driver = new ChromeDriver(options);
		
			//Login to the docops-dev using the credentials from config.properties file
			driver.get(loginURL);
			driver.manage().window().maximize();
			Properties p=new Properties();  
			InputStream inputStream = ExportSpace.class.getResourceAsStream("config.properties");
			p.load(inputStream);
			driver.findElement(By.id("os_username")).sendKeys(p.getProperty("username"));
			driver.findElement(By.id("os_password")).sendKeys(p.getProperty("password"));
			driver.findElement(By.id("loginButton")).click();   	
    	
			//Invoking the spaceUrl by reading from the spaceUrls file
			br = new BufferedReader(new FileReader(System.getProperty("user.dir")+spaceUrlspath));
			spaceUrl = br.readLine();
			while (spaceUrl!= null) {			
				driver.get(spacebaseURL+spaceUrl);
				driver.findElement(By.name("confirm")).click();	
				String originalHandle = driver.getWindowHandle();
				//opens 5 new tabs on chrome
				for(int i=1;i<=5;i++){
					((JavascriptExecutor)driver).executeScript("window.open()");
				}		
				//read the next 5 urls from spaceUrls file and invoke them
				ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
				spaceUrl = br.readLine();
				int j=1;
				while(spaceUrl!=null && j<=5) {	
						driver.switchTo().window(tabs.get(j));
						driver.get(spacebaseURL+spaceUrl);
						driver.findElement(By.name("confirm")).click();
						spaceUrl = br.readLine();
						j++;
				}	
									 
				//waiting for export complete and click file to download by switching to every tab invoked
				for(int k=1;k<=6;k++) {
					if(k<=5) {
						driver.switchTo().window(tabs.get(k));
						String currenturl = driver.getCurrentUrl();
						if(!currenturl.contains("about:blank")){
						WebDriverWait wait = new WebDriverWait(driver, 7200);
						wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.className("smalltext")), "Export complete. Download"));
						driver.findElement(By.className("space-export-download-path")).click();	
						System.out.println("Download initiated for space "+currenturl.split("=")[1]);
						}
						driver.close();
					}
					else {
						driver.switchTo().window(originalHandle);
						WebDriverWait wait2 = new WebDriverWait(driver, 7200);
						wait2.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.className("smalltext")), "Export complete. Download"));
						driver.findElement(By.className("space-export-download-path")).click();
						System.out.println("Download initiated for space "+driver.getCurrentUrl().split("=")[1]);
					}	
				} 
			} 
		}catch (IOException e) {
			e.printStackTrace();
		} finally{
				try {
					if (br != null)br.close();
					//driver.quit();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
		}
	}

}
