package org.augix.ue.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by toyknight on 4/3/2015.
 */
public class Ability {
    public static final int CONQUEROR = 0;
    public static final int FIGHTER_OF_THE_SEA = 1;
    public static final int FIGHTER_OF_THE_FOREST = 2;
    public static final int FIGHTER_OF_THE_MOUNTAIN = 3;
    public static final int DESTROYER = 4;
    public static final int AIR_FORCE = 5;
    public static final int NECROMANCER = 6;
    public static final int HEALER = 7;
    public static final int CHARGER = 8;
    public static final int POISONER = 9;
    public static final int REPAIRER = 10;
    public static final int TERROR_GAZE = 11;
    public static final int MARKSMAN = 12;
    public static final int SON_OF_THE_SEA = 13;
    public static final int SON_OF_THE_FOREST = 14;
    public static final int SON_OF_THE_MOUNTAIN = 15;
    public static final int CRAWLER = 16;
    public static final int SLOWING_GAZE = 17;
    public static final int COMMANDER = 18;
    public static final int SIEGE_MACHINE = 19;
    public static final int ATTACK_AURA = 20;
    public static final int DEFENCE_AURA = 21;
    public static final int MOVEMENT_AURA = 22;
    public static final int HEALING_AURA = 23;
    public static final int LORD_OF_TERROR = 24;

    private static ObservableList allAbilityNamesList = FXCollections.observableArrayList();
    private static Map<String, Integer> abilityIndexMap = new HashMap<>();

    public static final ObservableList getAllAbilityNamesList() {
        allAbilityNamesList.addAll("Conqueror", "Fighter of the Sea", "Fighter of the Forest", "Fighter of the Mountain",
                "Destroyer", "Air Force", "Necromancer", "Healer", "Charger", "Poisoner", "Repairer", "Terror Gaze", "Marksman",
                "Son of the Sea", "Son of the Forest", "Son of the Mountain", "Crawler", "Slowing Gaze", "Commander", "Siege Machine",
                "Attack Aura", "Defence Aura", "Movement Aura", "Healing Aura", "Load of Terror");

        return allAbilityNamesList;
    }

    public static Map<String, Integer> getAbilityIndexMap() {
        abilityIndexMap.put("Conqueror", CONQUEROR);
        abilityIndexMap.put("Fighter of the Sea", FIGHTER_OF_THE_SEA);
        abilityIndexMap.put("Fighter of the Forest", FIGHTER_OF_THE_FOREST);
        abilityIndexMap.put("Fighter of the Mountain", FIGHTER_OF_THE_MOUNTAIN);
        abilityIndexMap.put("Destroyer", DESTROYER);
        abilityIndexMap.put("Air Force", AIR_FORCE);
        abilityIndexMap.put("Necromancer", NECROMANCER);
        abilityIndexMap.put("Healer", HEALER);
        abilityIndexMap.put("Charger", CHARGER);
        abilityIndexMap.put("Poisoner", POISONER);
        abilityIndexMap.put("Repairer", REPAIRER);
        abilityIndexMap.put("Terror Gaze", TERROR_GAZE);
        abilityIndexMap.put("Marksman", MARKSMAN);
        abilityIndexMap.put("Son of the Sea", SON_OF_THE_SEA);
        abilityIndexMap.put("Son of the Forest", SON_OF_THE_FOREST);
        abilityIndexMap.put("Son of the Mountain", SON_OF_THE_MOUNTAIN);
        abilityIndexMap.put("Crawler", CRAWLER);
        abilityIndexMap.put("Slowing Gaze", SLOWING_GAZE);
        abilityIndexMap.put("Commander", COMMANDER);
        abilityIndexMap.put("Siege Machine", SIEGE_MACHINE);
        abilityIndexMap.put("Attack Aura", ATTACK_AURA);
        abilityIndexMap.put("Defence Aura", DEFENCE_AURA);
        abilityIndexMap.put("Movement Aura", MOVEMENT_AURA);
        abilityIndexMap.put("Healing Aura", HEALING_AURA);
        abilityIndexMap.put("Load of Terror", LORD_OF_TERROR);
        return abilityIndexMap;
    }
}
