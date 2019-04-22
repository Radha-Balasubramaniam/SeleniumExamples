package com.ca.tools.docops.tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.testng.Assert;

public class TestIDE {
	
	/*
	public static List<WebElement> FindAllLinks(WebDriver driver){
		
		
		List<WebElement> AnchorLinks = driver.findElements(By.tagName("a"));
		List<WebElement> ImageLinks = driver.findElements(By.tagName("img"));
		List<WebElement> FinalLinks = new ArrayList<WebElement>();
		AnchorLinks.addAll(ImageLinks);
		Iterator<WebElement> it = AnchorLinks.iterator();
	
		for(WebElement e: AnchorLinks){
		
			if(e.getAttribute("href") != null){
				FinalLinks.add(e);
			}else{
				System.out.println(e.getAttribute("href"));
			}
		}
		return FinalLinks;
	}*/
	
//	public static int isLinkBroken(URL url) throws Exception{
//		
//		String response="";
//		
//		HttpsURLConnection connection= (HttpsURLConnection)url.openConnection();
//		
//		try{
//			
//			connection.connect();
//			response =connection.getResponseMessage();
//			responsecode= connection.getResponseCode();
//			connection.disconnect();
//			
//			
//		}catch(Exception e){
//			
//			 e.getMessage();
//		}
//		return responsecode;
//	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*System.setProperty("webdriver.chrome.driver", "/Users/jaian07/Downloads/chromedriver");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://docs-dev.ca.com/en-us/ca-agile-central/saas/home");
		int responsecode=0;
		
		List<WebElement> links = FindAllLinks(driver);
		System.out.println("Total number of elements found " + links.size());
		
		for(WebElement elem: links){
			
			try{
				
				String url =elem.getAttribute("href");
				
				
				HttpsURLConnection connection= (HttpsURLConnection)(new URL(url).openConnection());
				
				connection.setRequestMethod("HEAD");
					connection.connect();
					
					responsecode= connection.getResponseCode();
					connection.disconnect();
					if(responsecode>=400){
						System.out.println(url+" is a BROKEN Link with response code : "+responsecode);
					}else{
						System.out.println(url+" is a VALID Link with response code : "+responsecode);
					}
				//System.out.println("URL: " +elem.getAttribute("href")+ " is returned : "+isLinkBroken(new URL(elem.getAttribute("href"))));
				
			}catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
			
			
			
		}
		
		*/
		
		
		
		
/*		String s="Page 1 of 1; showing 1 - 1 of 1 results";
		String[] sp = s.split(";");
		StringBuffer sr = new StringBuffer(sp[1]);
		String NeStr = new String(sr.reverse());
		StringBuffer sr1 = new StringBuffer(NeStr.replaceAll(" ", "_").split("_")[1]);
		String FiStr = new String(sr1.reverse());
		int cou = Integer.parseInt(FiStr);
		System.out.println(cou+1);
*/		
	
//	
//		String s="Page 1 of 8; showing 1 - 10 of 78 results";
//		String[] sp = s.split("-");
//		sp[1].replaceAll(" ","_");
//		String str2= sp[1].split("of")[0].trim();
//		String str1= sp[0].split("showing")[1].trim();
//		int i2= Integer.parseInt(str2);
//		int i1= Integer.parseInt(str1);
//		int ReultPerPage = (i2-i1)+1;
//	
//		System.out.println(ReultPerPage);
	
		
	   /* String s="Page 1 of 12; showing 1 - 10 of 119 results";

		String[] sp = s.split(";");	
		
		String newstr= sp[1].split("of")[1].trim();
		System.out.println(newstr);
		String fin = newstr.split("results")[0].trim();
		int cou = Integer.parseInt(fin);
		System.out.println(cou+1);*/

//		StringBuffer sr = new StringBuffer(sp[1].split("of")[1]);	
//		String NeStr = new String(sr.reverse());
//
//		StringBuffer sr1 = new StringBuffer(NeStr.replaceAll(" ", "_").split("_")[1]);
//		
//		String FiStr = new String(sr1.reverse());
//		
//		int cou = Integer.parseInt(FiStr);
	
		
		String ClassAttribute="jstree-anchor jstree-clicked is-active current";
		Assert.assertTrue(ClassAttribute.contains("is-active current"), "Article should be highlighted while accessing.");
		System.out.println("done");
		
	}

}
