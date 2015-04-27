package org.augix.ue.model;

import java.io.*;
import java.util.Properties;

/**
 * Created by Majirefy on 4/24/15.
 */
public class SettingsProvider {
    private static Settings settings = new Settings();
    private static Properties settingsProperties = new Properties();

    public static Settings getSettings() {
        final InputStream inputStream;
        try {
            inputStream = new FileInputStream("conf/settings.properties");
            settingsProperties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        settings.setUnitNameLocationString(settingsProperties.getProperty("unitNameLocation"));
        settings.setUnitImageLocationString(settingsProperties.getProperty("unitImageLocation"));
        settings.setUnitDataLocationString(settingsProperties.getProperty("unitDataLocation"));
        return settings;
    }

    public static void setSettings(Settings settings) {
        String unitNameLocationString = settings.getUnitNameLocationString();
        String unitImageLocation = settings.getUnitImageLocationString();
        String unitDataLocation = settings.getUnitDataLocationString();

        settingsProperties.setProperty("unitNameLocation", unitNameLocationString);
        settingsProperties.setProperty("unitImageLocation", unitImageLocation);
        settingsProperties.setProperty("unitDataLocation", unitDataLocation);

        try {
            final OutputStream outputStream = new FileOutputStream("conf/settings.properties");
            settingsProperties.store(outputStream,"Save Settings");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
