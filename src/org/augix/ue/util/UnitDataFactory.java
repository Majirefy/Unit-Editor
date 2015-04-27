package org.augix.ue.util;

import org.augix.ue.model.SettingsProvider;
import org.augix.ue.model.Unit;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by Majirefy on 4/25/15.
 */
public class UnitDataFactory {
    private static final String UNIT_DATA_FILE_PREFIX = "/unit_";
    private static final String UNIT_DATA_FILE_SUFFIX = ".dat";

    private static final String UNIT_NAME_FILE = "/en.lang";

    /**
     * Read unit data from file by unit index.
     *
     * @param unitIndex The unit index.
     * @return The Unit object.
     */
    public static Unit readUnitData(int unitIndex) {
        String dataFilePath = SettingsProvider.getSettings().getUnitDataLocationString() +
                UNIT_DATA_FILE_PREFIX + unitIndex + UNIT_DATA_FILE_SUFFIX;
        File dataFile = new File(dataFilePath);
        if (dataFile.exists()) {
            Unit unit = new Unit();
            try {
                Scanner scanner = new Scanner(dataFile);
                unit.setUnitPrice(scanner.nextInt());
                unit.setMaxHealthPoints(scanner.nextInt());
                unit.setMovementPoints(scanner.nextInt());
                unit.setAttackPower(scanner.nextInt());
                unit.setPhysicalDefence(scanner.nextInt());
                unit.setMagicalDefence(scanner.nextInt());
                unit.setAttackType(scanner.nextInt());
                unit.setHealthPointsGrowth(scanner.nextInt());
                unit.setMovementGrowth(scanner.nextInt());
                unit.setAttackPowerGrowth(scanner.nextInt());
                unit.setPhysicalDefenceGrowth(scanner.nextInt());
                unit.setMagicalDefenceGrowth(scanner.nextInt());
                unit.setMaximumAttackRange(scanner.nextInt());
                unit.setMinimumAttackRange(scanner.nextInt());
                unit.setAbilityCount(scanner.nextInt());
                for (int i = 0; i < unit.getAbilityCount(); i++) {
                    unit.getAbilities().add(scanner.nextInt());
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return unit;
        } else {
            return null;
        }
    }

    /**
     * Read unit name by unit index.
     *
     * @param unitIndex The unit index.
     * @return The unit name.
     */
    public static String readUnitName(int unitIndex) {
        String nameFilePath = SettingsProvider.getSettings().getUnitNameLocationString() + UNIT_NAME_FILE;
        try {
            InputStream inputStream = new FileInputStream(nameFilePath);
            Properties properties = new Properties();
            properties.load(inputStream);
            return properties.getProperty("UNIT_NAME_" + unitIndex);
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    public static void saveUnitName(int unitIndex, String unitName) {
        String nameFilePath = SettingsProvider.getSettings().getUnitNameLocationString() + UNIT_NAME_FILE;
        Properties properties;

        File file = new File(nameFilePath);
        if (file.exists()) {
            try {
                InputStream inputStream = new FileInputStream(file);
                properties = new Properties();
                properties.load(inputStream);
                properties.setProperty("UNIT_NAME_" + unitIndex, unitName);
                OutputStream outputStream = new FileOutputStream(file);
                properties.store(outputStream, null);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                file.createNewFile();
                OutputStream outputStream = new FileOutputStream(file);
                properties = new Properties();
                properties.setProperty("UNIT_NAME_" + unitIndex, unitName);
                properties.store(outputStream, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveUnitData(int unitIndex, Unit unit) {
        String dataFilePath = SettingsProvider.getSettings().getUnitDataLocationString() +
                UNIT_DATA_FILE_PREFIX + unitIndex + UNIT_DATA_FILE_SUFFIX;
        File file = new File(dataFilePath);
        if (file.exists()) {
            try {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("");
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(unit.getUnitPrice() + "\r\n");
            bufferedWriter.write(unit.getMaxHealthPoints() + "\r\n");
            bufferedWriter.write(unit.getMovementPoints() + "\r\n");
            bufferedWriter.write(unit.getAttackPower() + "\r\n");
            bufferedWriter.write(unit.getPhysicalDefence() + "\r\n");
            bufferedWriter.write(unit.getMagicalDefence() + "\r\n");
            bufferedWriter.write(unit.getAttackType() + "\r\n");
            bufferedWriter.write(unit.getHealthPointsGrowth() + "\r\n");
            bufferedWriter.write(unit.getMovementGrowth() + "\r\n");
            bufferedWriter.write(unit.getAttackPowerGrowth() + "\r\n");
            bufferedWriter.write(unit.getPhysicalDefenceGrowth() + "\r\n");
            bufferedWriter.write(unit.getMagicalDefenceGrowth() + "\r\n");
            bufferedWriter.write(unit.getMaximumAttackRange() + "\r\n");
            bufferedWriter.write(unit.getMinimumAttackRange() + "\r\n");
            bufferedWriter.write(unit.getAbilityCount() + "\r\n");
            for (int i = 0; i < unit.getAbilityCount(); i++) {
                bufferedWriter.write(unit.getAbilities().get(i) + "\r\n");
            }
            bufferedWriter.write(0 + "\r\n");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
