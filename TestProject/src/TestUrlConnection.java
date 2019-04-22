import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import org.apache.commons.codec.binary.Base64;


public class TestUrlConnection {
	
	public static void main ( String[] args) throws Exception {
		
	/*	URL url = new URL("https://docs-test.ca.com/user/login");
		String userPass = "docadmin : docadmin";
		//String basicAuth = "Basic " + Base64.encodeToString(userPass.getBytes(), Base64.DEFAULT);
		String basicAuth = "Basic " + Base64.
		//or
		//String basicAuth = "Basic " + new String(Base64.encode(userPass.getBytes(), Base64.No_WRAP));
		HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
		urlConnection.setRequestProperty("Authorization", basicAuth);
		urlConnection.connect();
		
		url = new URL("https://docs-test.ca.com/ca-agile-central/saas/home");
		URLConnection conn = url.openConnection();
		String HeaderFieldValue = conn.getHeaderField("cache-control");
		System.out.print(HeaderFieldValue); */
		
		URL url = new URL("https://docs-test.ca.com/user/login");
		String userPass = "docadmin : docadmin";
		//String basicAuth = "Basic " + Base64.encodeToString(userPass.getBytes(), Base64.DEFAULT);
		//String basicAuth = "Basic " + Base64.
		//or
		//String basicAuth = "Basic " + new String(Base64.encode(userPass.getBytes(), Base64.No_WRAP));
		byte[] authEncBytes = Base64.encodeBase64(userPass.getBytes());
		String authStringEnc = new String(authEncBytes);
		HttpsURLConnection urlConnection = (HttpsURLConnection)url.openConnection();
		
		urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
		
		urlConnection.connect();
		String HeaderFieldValue = urlConnection.getHeaderField("cache-control");
		System.out.print(HeaderFieldValue); 
		System.out.println("connection was successful");
	
		
	
		HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
		//String HeaderFieldValue = conn.getHeaderField("cache-control");
		//System.out.print(HeaderFieldValue); 
		
		/*	try {
			String webPage = "https://docs-test.ca.com/en-us/user";
			String name = "docadmin";
			String password = "docadmin";

			String authString = name + ":" + password;
			System.out.println("auth string: " + authString);
			byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
			String authStringEnc = new String(authEncBytes);
			System.out.println("Base64 encoded auth string: " + authStringEnc);

			URL url = new URL(webPage);
			HttpsURLConnection urlConnection = (HttpsURLConnection)url.openConnection();
			urlConnection.setRequestProperty("Authorization", "Basic " + authStringEnc);
			InputStream is = urlConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);

			int numCharsRead;
			char[] charArray = new char[1024];
			StringBuffer sb = new StringBuffer();
			while ((numCharsRead = isr.read(charArray)) > 0) {
				sb.append(charArray, 0, numCharsRead);
			}
			String result = sb.toString();

			System.out.println("*** BEGIN ***");
			System.out.println(result);
			System.out.println("*** END ***");
		/*	url = new URL("https://docs-test.ca.com/ca-agile-central/saas/home");
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			String HeaderFieldValue = conn.getHeaderField("cache-control");
			System.out.print(HeaderFieldValue);*/
			
	/*	} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	}
	
	}



