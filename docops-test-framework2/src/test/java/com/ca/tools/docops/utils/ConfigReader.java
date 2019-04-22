package com.ca.tools.docops.utils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Class to read configuration parameters
 * 
 * @author Team - Tools - Development <Team-Tools-Development@ca.com>
 *
 */
public class ConfigReader {
    private static Properties props;
    private static String CONFIG_FILE_NAME = "docops.properties";
    CryptoUtil cp = new CryptoUtil();

    /**
     * @throws Exception
     *             if failed to read/locate the configuration file.
     */
    public ConfigReader() {
        if (props == null) {
            props = new Properties();
            try {
                props.load(new FileInputStream("target/test-classes/conf/" + CONFIG_FILE_NAME));
            } catch (Exception e) {
                throw new Error("Failed to read the configuration file docops.properties", e);
            }
        }
    }

    /**
     * Return the corresponding value of the given key.
     * 
     * @param key
     * @return value or null( if key is not exist )
     */
    public String getValue(String key) {
        return (String) props.get(key);
    }

    /**
     * Returns docops username exist in the configuration file.
     * 
     * @return
     */
    public String getUserName() {
        return getValue("username");
    }

    public String getDocOpsUserName(String userName) {
        return getValue(userName);
    }

    public String getDocOpsPassword(String pw) {
        return getValue(pw);
    }

    /**
     * Returns docops user's password exist in the configuration file.
     * 
     * @return
     */
    public String getPassword() {
        return cp.decrypt(getValue("password"));
    }

    /**
     * Returns docops server exist in the configuration file.
     * 
     * @return
     */
    public String getServer() {
        return getValue("server");
    }

    /**
     * Returns docops server port exist in the configuration file.
     * 
     * @return
     */
    public String getPort() {
        return getValue("port");
    }

    /**
     * Returns docops context/webapp name exist in the configuration file.
     * 
     * @return
     */
    public String getWebAppName() {
        return getValue("webappname");
    }

    /**
     * Returns locale exist in the configuration file.
     * 
     * @return
     */
    public String getLocale() {
        return getValue("locale");
    }

    /**
     * Returns http/https protocol exist in the configuration file.
     * 
     * @return
     */
    public String getProtocol() {
        return getValue("protocol");
    }
    
    /**
     * Returns agile central base_url exist in the configuration file.
     * 
     * @return
     */
    public String getBaseUrl() {
        return getValue("base_url");
    }

    /**
     * Returns docops URL
     * 
     * @return
     */
    public String getDrupalBaseURL() {
        return getProtocol() + "://" + getServer();
    }

    
    public String getDrupalAgileCentralURL() {
    	return getDrupalBaseURL()+"/"+getLocale()+getValue("base_url");
    }
    
    public String getAdminURL() {
        return getDrupalBaseURL()+"/"+getLocale()+"/"+StringConstants.ADMIN;
    }
    /**
     * Returns docops URL
     * 
     * @return
     */
    public String getDrupalURL() {
        return getProtocol() + "://" + getServer();
    }

    /**
     * Returns browser
     * 
     * @return
     */
    public String getBrowser() {
        return getValue("browser");
    }

    public String getGridUrl() {
        return getValue("gridUrl");
    }

    public String getDrupalLoginURL() {
       return getDrupalBaseURL() + "/"+ getLocale()+ getValue(StringConstants.USERLOGIN);
    }

    public String getDrupalLogoutURL() {
        return getDrupalBaseURL() + getValue(StringConstants.USERLOGOUT);
    }
    public String getAgileCentralHome() {
        return getProtocol() + "://" + getServer()+"/"+getLocale()+getValue("ac_home");
    }

    public String getUploadFilesPath() {
        return getValue("upload_files_folder");
    }
}
