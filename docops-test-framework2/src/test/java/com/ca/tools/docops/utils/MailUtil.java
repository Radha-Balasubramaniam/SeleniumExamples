package com.ca.tools.docops.utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import static com.ca.tools.docops.utils.StringConstants.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Util class to handle mails
 * 
 * @author Team - Tools - Development <Team-Tools-Development@ca.com>
 *
 */
public class MailUtil {
    public static void sendMail(String suiteName, String SuiteResult, List<String> FailName, String EnvironmentName){
        ConfigReader configReader = new ConfigReader();
        MultiPartEmail mail = new MultiPartEmail();
        mail.setHostName(configReader.getValue(MAIL_HOST));
        mail.setAuthenticator(
                new DefaultAuthenticator(configReader.getValue(MAIL_USERNAME), configReader.getValue(MAIL_PASSWORD)));
        mail.setSSLCheckServerIdentity(Boolean.valueOf(configReader.getValue(SSLENABLE)));
        mail.setSSLOnConnect(Boolean.valueOf(configReader.getValue(SSLENABLE)));
        mail.setSmtpPort(25);
        mail.setSslSmtpPort("25");
        EmailAttachment attachment = new EmailAttachment();
        attachment.setPath("target/surefire-reports/DocOps2.0-"+suiteName+"-report.html");
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setDescription(EnvironmentName);
        attachment.setName("DocOps2.0 "+suiteName+" Report.html");
        try {
            StringTokenizer toAddresses = new StringTokenizer(configReader.getValue(TO), ";");
            while (toAddresses.hasMoreTokens()) {
                String toEmailAddress = toAddresses.nextToken();
                mail.addTo(toEmailAddress);
            }
            StringTokenizer ccAddresses = new StringTokenizer(configReader.getValue(CC), ";");
            while (ccAddresses.hasMoreTokens()) {
                mail.addCc(ccAddresses.nextToken());
            }
            mail.setFrom(configReader.getValue(FROM));
            mail.attach(attachment);
            mail.setSubject("DocOps2.0 "+suiteName+" Report "+SuiteResult);
            mail.setMsg(FailName.toString().replace(",", "\n"));
            mail.send();
        } catch (EmailException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}