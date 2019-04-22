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

package    com.ca.tools.docops.rally;

/**
 * This class stores the automation test result object for updating results in
 * rally
 * 
 * @author Team - Tools - Development Team-Tools-Development@ca.com
 * @version 1.0
 * @since docops2-automation
 * 
 */
public class DocOpsTestResult {

	private String testcaseId;
	private String testcaseStatus;
	private String testcaseErrorMessage;
	private String testcaseName;

	public String getTestcaseName() {
		return testcaseName;
	}

	public void setTestcaseName(String testcaseName) {
		this.testcaseName = testcaseName;
	}

	public String getTestcaseId() {
		return testcaseId;
	}

	public void setTestcaseId(String testcaseId) {
		this.testcaseId = testcaseId;
	}

	public String getTestcaseStatus() {
		return testcaseStatus;
	}

	public void setTestcaseStatus(String testcaseStatus) {
		this.testcaseStatus = testcaseStatus;
	}

	public String getTestcaseErrorMessage() {
		return testcaseErrorMessage;
	}

	public void setTestcaseErrorMessage(String testcaseErrorMessage) {
		this.testcaseErrorMessage = testcaseErrorMessage;
	}

}
