package com.ca.tools.docops.tests;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ca.tools.docops.utils.DataProviderClass;

public class GetHeaderForLoggedInUser extends BaseTest {

	private HttpsURLConnection conn;
	public static Map<String, String> map = new HashMap<>();

	public static String getCacheControlHeaderForLoggedInUsers(String LoginURL, String HomePageURL) {

		GetHeaderForLoggedInUser responseHeader = new GetHeaderForLoggedInUser();
		CookieHandler.setDefault(new CookieManager());
		try {
			String page = responseHeader.GetPageContent(LoginURL);
			String postParams = responseHeader.getFormParams(page);
			responseHeader.sendPost(LoginURL, postParams);
			responseHeader.GetPageContent(HomePageURL);

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map.get(HomePageURL).toString();
	}

	private void sendPost(String LoginURL, String postParams) throws IOException {

		URL obj = new URL(LoginURL);
		conn = (HttpsURLConnection) obj.openConnection();

		// Acts like a browser
		conn.setUseCaches(false);
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);

		// Send post request
		DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.writeBytes(postParams);
		wr.flush();
		wr.close();

		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
	}

	private String GetPageContent(String url) throws IOException, InterruptedException {

		URL obj = new URL(url);
		conn = (HttpsURLConnection) obj.openConnection();

		// default is GET
		conn.setRequestMethod("GET");
		conn.setUseCaches(false);

		map.put(url, conn.getHeaderField("cache-control"));
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// Get the response cookies
		return response.toString();

	}

	private String getFormParams(String html) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

		Document doc = Jsoup.parse(html);
		Element loginform = doc.getElementById("user-login-form");
		Elements inputElements = loginform.getElementsByTag("input");

		List<String> paramList = new ArrayList<String>();
		for (Element inputElement : inputElements) {
			String key = inputElement.attr("name");
			String value = inputElement.attr("value");

			if (key.equals("name"))
				value = DataProviderClass.getDocAdminUserDetails().getUser();
			else if (key.equals("pass"))
				value = DataProviderClass.getDocAdminUserDetails().getPw();
			paramList.add(key + "=" + URLEncoder.encode(value, "UTF-8"));

		}

		// build parameters list
		StringBuilder result = new StringBuilder();
		for (String param : paramList) {
			if (result.length() == 0) {
				result.append(param);
			} else {
				result.append("&" + param);
			}
		}

		return result.toString();
	}

}
