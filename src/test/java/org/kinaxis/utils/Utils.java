package org.kinaxis.utils;

import java.io.InputStream;
import java.util.Properties;

public class Utils {

    public static String readProperty(String propertyName) {
        try (InputStream input = Utils.class.getClassLoader().getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return null;
            }
            prop.load(input);
            return prop.getProperty(propertyName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
