package org.augix.ue.util;

import org.augix.ue.model.Settings;
import org.augix.ue.model.SettingsProvider;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Majirefy on 4/24/15.
 */
public class DataChecker {
    private static Settings settings = SettingsProvider.getSettings();

    public static void checkData() {
        Path unitNamePath = Paths.get(settings.getUnitNameLocationString());
    }
}
