package com.ca.tools.docops.dtos;

/**
 * 
 * @author karbh03
 *
 */
public class ArticleData {
    private String title;
    private String integrationDescription;
    private String hid;
    private String videoPath;
    private String attachmentPath;
    private String language;
    private String title2;
    private String body;
    private String screenshotPath;
    private String[] videoEmbeddedEntry;
    private String videoLinkUrl;
    private String videoUrlLinkText;
    private String dataSheetPath;
    private String partnerUrl;
    private String partnerUrlLinkText;
    private String supportedVersion;
    private String Cost;
    private String headsUpFieldInCAAgileCentralHelpTopic;
    private String forDevelopersFieldInCAAgileCentralHelpTopic;
    private String imagePathInCAAgileCentralHelpTopic;
    private String videoPathInCAAgileCentralHelpTopic;
    private String attachmentPathInCAAgileCentralHelpTopic;
    private String downloadCodeFilePathInCAAgileCentralHelpTopic;
    private String downloadSamplesFilePathInCAAgileCentralHelpTopic;
    private String keywordSearchTermsInCAAgileCentralHelpTopic;
    private String articleType;
    private String menuLinkTitle;
    private String menuLinkDescription;
    private String menuLinkParentItem;
    private String menuLinkWeight;
    private String urlAlias;
    private boolean menuLinkCheckboxEnabled;
    private String contentType;
    private String ScheduleModerationState;
    
    

    public String getModerationStateToSchedule() {
		return ScheduleModerationState;
	}

	public void setScheduleModerationState(String scheduleModerationState) {
		ScheduleModerationState = scheduleModerationState;
	}

	public String getIntegrationDescription() {
        return integrationDescription;
    }

    public void setIntegrationDescription(String integrationDescription) {
        this.integrationDescription = integrationDescription;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getScreenshotPath() {
        return screenshotPath;
    }

    public void setScreenshotPath(String screenshotPath) {
        this.screenshotPath = screenshotPath;
    }

    public String[] getVideoEmbeddedEntry() {
        return videoEmbeddedEntry;
    }

    public void setVideoEmbeddedEntry(String[] videoEmbeddedEntry) {
        this.videoEmbeddedEntry = videoEmbeddedEntry;
    }

    public String getVideoLinkUrl() {
        return videoLinkUrl;
    }

    public void setVideoLinkUrl(String videoLinkUrl) {
        this.videoLinkUrl = videoLinkUrl;
    }

    public String getVideoUrlLinkText() {
        return videoUrlLinkText;
    }

    public void setVideoUrlLinkText(String videoUrlLinkText) {
        this.videoUrlLinkText = videoUrlLinkText;
    }

    public String getDataSheetPath() {
        return dataSheetPath;
    }

    public void setDataSheetPath(String dataSheetPath) {
        this.dataSheetPath = dataSheetPath;
    }

    public String getPartnerUrl() {
        return partnerUrl;
    }

    public void setPartnerUrl(String partnerUrl) {
        this.partnerUrl = partnerUrl;
    }

    public String getPartnerUrlLinkText() {
        return partnerUrlLinkText;
    }

    public void setPartnerUrlLinkText(String partnerUrlLinkText) {
        this.partnerUrlLinkText = partnerUrlLinkText;
    }

    public String getSupportedVersion() {
        return supportedVersion;
    }

    public void setSupportedVersion(String supportedVersion) {
        this.supportedVersion = supportedVersion;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    public void setHeadsUpFieldInCAAgileCentralHelpTopic(String headsUpFieldInCAAgileCentralHelpTopic) {
        this.headsUpFieldInCAAgileCentralHelpTopic = headsUpFieldInCAAgileCentralHelpTopic;
    }

    public String getForDevelopersFieldInCAAgileCentralHelpTopic() {
        return forDevelopersFieldInCAAgileCentralHelpTopic;
    }

    public void setForDevelopersFieldInCAAgileCentralHelpTopic(String forDevelopersFieldInCAAgileCentralHelpTopic) {
        this.forDevelopersFieldInCAAgileCentralHelpTopic = forDevelopersFieldInCAAgileCentralHelpTopic;
    }

    public String getImagePath() {
        return imagePathInCAAgileCentralHelpTopic;
    }

    public void setImagePath(String imagePathInCAAgileCentralHelpTopic) {
        this.imagePathInCAAgileCentralHelpTopic = imagePathInCAAgileCentralHelpTopic;
    }

    public String getVideoPathInCAAgileCentralHelpTopic() {
        return videoPathInCAAgileCentralHelpTopic;
    }

    public void setVideoPathInCAAgileCentralHelpTopic(String videoPathInCAAgileCentralHelpTopic) {
        this.videoPathInCAAgileCentralHelpTopic = videoPathInCAAgileCentralHelpTopic;
    }

    public String getAttachmentPathInCAAgileCentralHelpTopic() {
        return attachmentPathInCAAgileCentralHelpTopic;
    }

    public void setAttachmentPathInCAAgileCentralHelpTopic(String attachmentPathInCAAgileCentralHelpTopic) {
        this.attachmentPathInCAAgileCentralHelpTopic = attachmentPathInCAAgileCentralHelpTopic;
    }

    public String getDownloadCodeFilePathInCAAgileCentralHelpTopic() {
        return downloadCodeFilePathInCAAgileCentralHelpTopic;
    }

    public void setDownloadCodeFilePathInCAAgileCentralHelpTopic(String downloadCodeFilePathInCAAgileCentralHelpTopic) {
        this.downloadCodeFilePathInCAAgileCentralHelpTopic = downloadCodeFilePathInCAAgileCentralHelpTopic;
    }

    public String getDownloadSamplesFilePathInCAAgileCentralHelpTopic() {
        return downloadSamplesFilePathInCAAgileCentralHelpTopic;
    }

    public void setDownloadSamplesFilePathInCAAgileCentralHelpTopic(
            String downloadSamplesFilePathInCAAgileCentralHelpTopic) {
        this.downloadSamplesFilePathInCAAgileCentralHelpTopic = downloadSamplesFilePathInCAAgileCentralHelpTopic;
    }

    public String getKeywordSearchTermsInCAAgileCentralHelpTopic() {
        return keywordSearchTermsInCAAgileCentralHelpTopic;
    }

    public void setKeywordSearchTermsInCAAgileCentralHelpTopic(String keywordSearchTermsInCAAgileCentralHelpTopic) {
        this.keywordSearchTermsInCAAgileCentralHelpTopic = keywordSearchTermsInCAAgileCentralHelpTopic;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public String getImagePathInCAAgileCentralHelpTopic() {
        return imagePathInCAAgileCentralHelpTopic;
    }

    public void setImagePathInCAAgileCentralHelpTopic(String imagePathInCAAgileCentralHelpTopic) {
        this.imagePathInCAAgileCentralHelpTopic = imagePathInCAAgileCentralHelpTopic;
    }

    public String getMenuLinkTitle() {
        return menuLinkTitle;
    }

    public void setMenuLinkTitle(String menuLinkTitle) {
        this.menuLinkTitle = menuLinkTitle;
    }

    public String getMenuLinkDescription() {
        return menuLinkDescription;
    }

    public void setMenuLinkDescription(String menuLinkDescription) {
        this.menuLinkDescription = menuLinkDescription;
    }

    public String getMenuLinkParentItem() {
        return menuLinkParentItem;
    }

    public void setMenuLinkParentItem(String menuLinkParentItem) {
        this.menuLinkParentItem = menuLinkParentItem;
    }

    public String getMenuLinkWeight() {
        return menuLinkWeight;
    }

    public void setMenuLinkWeight(String menuLinkWeight) {
        this.menuLinkWeight = menuLinkWeight;
    }

    public String getUrlAlias() {
        return urlAlias;
    }

    public void setUrlAlias(String urlAlias) {
        this.urlAlias = urlAlias;
    }

    public String getHeadsUpFieldInCAAgileCentralHelpTopic() {
        return headsUpFieldInCAAgileCentralHelpTopic;
    }

    public boolean isMenuLinkCheckboxEnabled() {
        return menuLinkCheckboxEnabled;
    }

    public void setMenuLinkCheckboxEnabled(boolean menuLinkCheckboxEnabled) {
        this.menuLinkCheckboxEnabled = menuLinkCheckboxEnabled;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
