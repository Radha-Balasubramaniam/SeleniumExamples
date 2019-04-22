import org.openqa.selenium.remote.server.SeleniumServer;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class RCExample1 {
	
	public static void main(String[] args){
	SeleniumServer server = new SeleniumServer(null);
	server.start();
	
	Selenium sc = new DefaultSelenium("localhost", 4444, "*firefox","http://gmail.com");
	
	sc.start();
	sc.open("/");
	
	}
	

}
