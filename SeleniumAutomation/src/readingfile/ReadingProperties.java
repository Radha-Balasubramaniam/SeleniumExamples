package readingfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/config/object.properties");
		//FileReader fis = new FileReader("/Users/balra06/Documents/workspace/SeleniumAutomation/src/config/object.properties");
		prop.load(fis);
		
		System.out.println(prop.getProperty("name"));
	}

}
