/* ---------------------------------------------------------------------- */
/*              Proprietary and Confidential Information                  */
/*                                                                        */
/* This software, associated documentation, and all information contained */
/* therein is confidential and proprietary and shall not be duplicated,   */
/* used, disclosed or disseminated in any way except as authorized by the */
/* applicable license agreement, without the express written permission   */
/* of CA.                                                                 */
/*                    Copyright 2016 CA Technologies                      */
/*                          All rights reserved                           */
/*                                                                        */
/* ---------------------------------------------------------------------- */
package com.ca.tools.docops.rally;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.ca.tools.docops.utils.CryptoUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.rallydev.rest.RallyRestApi;
import com.rallydev.rest.request.CreateRequest;
import com.rallydev.rest.request.QueryRequest;
import com.rallydev.rest.response.CreateResponse;
import com.rallydev.rest.response.QueryResponse;
import com.rallydev.rest.util.Fetch;
import com.rallydev.rest.util.QueryFilter;

/**
 * This class performs the rally operations like updating test case results and
 * creating defects when test case fails for automation suite
 * 
 * @author Team - Tools - Development Team-Tools-Development@ca.com
 * @version 1.0
 * @since docops2-automation
 * 
 */
public class RallyOpeartions {
	private static final Logger LOGGER = Logger.getLogger(RallyOpeartions.class);

	private static final String FORMATTEDID = "FormattedID";

	private static String rallyHost;
	private static String rallyApiKey;
	private static String workSpaceRef;
	private static String defectSuite;
	private CryptoUtil cryptoUtil = new CryptoUtil();
	/**
	 * This static method calls the load properties method to read the properties
	 */
	static {
		loadPropertyFile();
	}

	/**
	 * This method calls the test case update and created defect methods to
	 * update rally
	 * 
	 * @param automationTestResults
	 *            An list object containing test results
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public void updateTestResults(String id, String status) throws URISyntaxException {
		RallyRestApi restApi = null;
		restApi = new RallyRestApi(new URI(rallyHost), cryptoUtil.decrypt(rallyApiKey));
		restApi.setApplicationVersion("v2.0");
		restApi.setApplicationName("Tools Snova");

		String testcaseObjectID = null;
		try {
			testcaseObjectID = getTestcaseObjectID(restApi, id);
		} catch (Exception e) {
			LOGGER.error("An exception has been encountered while updating the test results", e);
		}
		try {
			updateTestcase(restApi, testcaseObjectID, status);
		} catch (IOException e) {
			LOGGER.error("An IOException has been encountered while updating test cases ", e);
		}

		try {
			restApi.close();
		} catch (IOException e) {
			LOGGER.error("An IOException encountered while trying to close the rally", e);
		}
	}

	/**
	 * This methods loads the properties file and reads all the rally properties
	 */
	private static void loadPropertyFile() {
		Properties prop = new Properties();
		try (InputStream input = new FileInputStream("target/test-classes/conf/rallyapi.properties")) {
			prop.load(input);
			rallyHost = prop.getProperty("url");
			rallyApiKey = prop.getProperty("key");
			workSpaceRef = prop.getProperty("workspace");
			defectSuite = prop.getProperty("suite");
		} catch (IOException ex) {
			LOGGER.error("Exception while loading properties", ex);
		}
	}



	/**
	 * This method updated the test case with the result obtained from
	 * automation suite
	 * 
	 * @param restApi
	 *            An object of type RallyRestApi
	 * @param testcaseObjectID
	 *            A variable of type String
	 * @param docOpsTestResult
	 * @return A variable of type boolean
	 * @throws IOException
	 */
	private static void updateTestcase(RallyRestApi restApi, String testcaseObjectID, String status)
			throws IOException {
		JsonObject newTestCaseResult = new JsonObject();

		newTestCaseResult.addProperty("Verdict", status);
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		String timestamp = sdf.format(date);
		String userRef = getdocOpsUserName(restApi);

		newTestCaseResult.addProperty("Date", timestamp);
		newTestCaseResult.addProperty("Build", "1.0");

		newTestCaseResult.addProperty("Tester", userRef);
		newTestCaseResult.addProperty("TestCase", testcaseObjectID);


		CreateRequest createRequest = new CreateRequest("testcaseresult", newTestCaseResult);
		CreateResponse createResponse = restApi.create(createRequest);

		LOGGER.info("Updated testcase successfully :" + createResponse.wasSuccessful());

	}

	/**
	 * 
	 * @param restApi
	 *            An object of type RallyRestApi
	 * @return A variable of type String
	 * @throws IOException
	 */
	private static String getdocOpsUserName(RallyRestApi restApi) throws IOException {
		QueryRequest userRequest = new QueryRequest("User");
		userRequest.setFetch(new Fetch("UserName", "Subscription", "DisplayName", "SubscriptionAdmin"));
		userRequest.setQueryFilter(new QueryFilter("UserName", "=", "p360user1@ca.com"));
		QueryResponse userQueryResponse = restApi.query(userRequest);
		JsonArray userQueryResults = userQueryResponse.getResults();
		JsonElement userQueryElement = userQueryResults.get(0);
		JsonObject userQueryObject = userQueryElement.getAsJsonObject();
		String userRef = userQueryObject.get("_ref").getAsString();
		return userRef;
	}

	/**
	 * This method returns objectId of the test case to be used for further
	 * operations
	 * 
	 * @param restApi
	 *            An object of type RallyRestApi
	 * @param testcaseId
	 *            A variable of type String
	 * @return A variable of type String
	 * @throws IOException
	 */
	private static String getTestcaseObjectID(RallyRestApi restApi, String testcaseId) throws IOException {
		QueryRequest testCaseQueryRequest = new com.rallydev.rest.request.QueryRequest("testcase");

		testCaseQueryRequest.setWorkspace(workSpaceRef);
		testCaseQueryRequest.setQueryFilter(new QueryFilter(FORMATTEDID, "=", testcaseId));
		String returnstat;

		QueryResponse tagResponse = restApi.query(testCaseQueryRequest);
		tagResponse.getTotalResultCount();

		JsonObject defectObject = tagResponse.getResults().get(0).getAsJsonObject();
		JsonElement objectId = defectObject.get("ObjectID");
		returnstat = objectId.getAsString();
		return returnstat;
	}

}
