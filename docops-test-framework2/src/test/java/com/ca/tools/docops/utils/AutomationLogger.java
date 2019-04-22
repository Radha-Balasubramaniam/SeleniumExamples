package com.ca.tools.docops.utils;

import org.apache.log4j.PropertyConfigurator;

public class AutomationLogger {
    public static void configure() {
        PropertyConfigurator.configure("target/test-classes/conf/log4j.properties");
    }
}
