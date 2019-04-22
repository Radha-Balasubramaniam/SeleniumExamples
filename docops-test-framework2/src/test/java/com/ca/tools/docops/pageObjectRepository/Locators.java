package com.ca.tools.docops.pageObjectRepository;

public interface Locators {


	interface Generic {
		public static final String LOGIN_LINK_TEXT = "Log in";

		public static final String PF_SPAN_TITLE = "//span[@title='Plan:']";
	}

	interface Button {
		
		public static final String CONTENT_BUTTON = "toolbar-link-system-admin_content";
		public static final String BASIC_PAGE_SOURCE_BUTTON = "//a[@class='cke_button cke_button__source cke_button_off']";
		public static final String BASIC_PAGE_SAVE_BUTTON = "//div[@class='dropbutton-widget']";
		public static final String BASIC_PAGE_CREATE_BUTTON = "//span[contains(text(),'Basic page')]";
		public static final String EDIT_ACTIONS_BUTTON="edit-actions";
		public static final String CONTENT_FILTER_BUTTON="edit-submit-content";
		public static final String DELETE_CONTENT_BUTTON="//a[contains(text(),'Delete')]";
		public static final String DELETE_CONTENT_CONFIRM_BUTTON="edit-submit";
		
		public static final String LANDING_PAGE_CREATE_BUTTON = "//span[contains(text(),'Landing page')]";
	}

	interface Image {
		public static final String EXPANDFILTER_IMG_ID = "page_projmgr.projectList_odf_collapseFilter_action_img";
		public static final String PORTLET_LAYOUT_MOVERIGHT2 = "//td[@column='2' and text()='Move Content']/a/img[@title='Move Right']";
	}

	interface TextField {

		public static final String NAME_FIELD = "edit-name";
		public static final String PASSWORD_FIELD = "edit-pass";
		public static final String SUBMIT_FIELD = "edit-submit";
		public static final String EDIT_PAGE = "edit-title-0-value";
		public static final String EDIT_TITLE="edit-title";
		
		public static final String BASIC_PAGE_TEXT_AREA="//div[@class='cke_contents cke_reset']/textarea";
		
		public static final String COLUMN_LAYOUT_TEXT = "//h2[@title='Column Layout']";
	}

	interface CheckBox {
		public static final String KEY_TASK_CB_NAME = "priskey";
		public static final String PR_IS_FIXED = "prisfixed";
	}

	interface Link {
		public static final String LOGIN_LINK_TEXT = "Log in";
		public static final String LOGOUT_LINK_TEXT="Log out";
		public static final String ADD_CONTENT_LINK= "Add content";
		public static final String RESOURCE_FINDER_LNK_TEXT = "Resource Finder";
	}

	interface Combobox {
		public static final String EDIT_DROP_DOWN = "//span[@class='dropbutton-arrow']";
		public static final String UITHEME_CMB_NAME = "uiThemeCode";

	}

	interface ListBox {

		public static final String AVAILABLE_LB_NAME = "availableColumns";
		public static final String MAPPING_FIELD = "mappingField";

	}

	interface RadioButton {
		public static final String OBJECTINSTANCE_RB_ID = "objectInstanceId";
		public static final String RECURRENCE_TYPE_RB_NAME = "recurrence_type";
	}

}
