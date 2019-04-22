/* ---------------------------------------------------------------------- */
/*               Proprietary and Confidential Information                 */
/*                                                                        */
/* This software, associated documentation, and all information contained */
/* therein is confidential and proprietary and shall not be duplicated,   */
/* used, disclosed or disseminated in any way except as authorized by the */
/* applicable license agreement, without the express written permission   */
/* of CA.                                                                 */
/*                         Copyright 2016 CA Technologies                 */
/*                          All rights reserved                           */
/*                                                                        */
/* ---------------------------------------------------------------------- */
package com.ca.tools.docops.utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Class to read the inputdata
 * @author Team - Tools - Development <Team-Tools-Development@ca.com>
 * @since docops2-automation
 * @version 1.0
 * 
 */
public class InputData {

	private static final Logger LOGGER = Logger.getLogger(InputData.class);
    private static Properties props;
    static {
        if (props == null) {
            props = new Properties();
            ConfigReader configReader = new ConfigReader();
            String locale = configReader.getLocale();
            try {
                if (locale == null || locale.trim().length() == 0
                        || locale.trim().equalsIgnoreCase("en"))
                    props.load(new FileInputStream("target/test-classes/data/input_data.properties"));
                else
                    props.load(new FileInputStream("target/data/input_data_" + locale
                            + ".properties"));
            } catch (Exception e) {
                try {
                    props.load(new FileInputStream("target/test-classes/data/input_data.properties"));
                } catch (Exception e1) {
                	LOGGER.error("Failed to load to properties:",e1);
                }
            }
        }
    }

    public String getUniqueValue(String attributeName) {
        return props.getProperty(attributeName) + System.currentTimeMillis();
    }

    public String getValue(String attributeName) {
        return props.getProperty(attributeName);
    }
}