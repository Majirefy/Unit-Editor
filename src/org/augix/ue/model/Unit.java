package org.augix.ue.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Majirefy on 4/25/15.
 */
public class Unit {
    private String unitName = "";
    private int unitPrice = 0;
    private int maxHealthPoints = 0;
    private int healthPointsGrowth = 0;
    private int movementPoints = 0;
    private int movementGrowth = 0;
    private int attackType = 0;
    private int attackPower = 0;
    private int attackPowerGrowth = 0;
    private int physicalDefence = 0;
    private int physicalDefenceGrowth = 0;
    private int magicalDefence = 0;
    private int magicalDefenceGrowth = 0;
    private int minimumAttackRange = 0;
    private int maximumAttackRange = 0;
    private int abilityCount = 0;
    private List<Integer> abilities = new ArrayList<>(25);

    public Unit() {
        for (int i = 0; i < abilities.size(); i++) {
            abilities.set(i, -1);
        }
    }

    public int getAbilityCount() {
        return abilityCount;
    }

    public void setAbilityCount(int abilityCount) {
        this.abilityCount = abilityCount;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints) {
        this.maxHealthPoints = maxHealthPoints;
    }

    public int getHealthPointsGrowth() {
        return healthPointsGrowth;
    }

    public void setHealthPointsGrowth(int healthPointsGrowth) {
        this.healthPointsGrowth = healthPointsGrowth;
    }

    public int getMovementPoints() {
        return movementPoints;
    }

    public void setMovementPoints(int movementPoints) {
        this.movementPoints = movementPoints;
    }

    public int getMovementGrowth() {
        return movementGrowth;
    }

    public void setMovementGrowth(int movementGrowth) {
        this.movementGrowth = movementGrowth;
    }

    public int getAttackType() {
        return attackType;
    }

    public void setAttackType(int attackType) {
        this.attackType = attackType;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getAttackPowerGrowth() {
        return attackPowerGrowth;
    }

    public void setAttackPowerGrowth(int attackPowerGrowth) {
        this.attackPowerGrowth = attackPowerGrowth;
    }

    public int getPhysicalDefence() {
        return physicalDefence;
    }

    public void setPhysicalDefence(int physicalDefence) {
        this.physicalDefence = physicalDefence;
    }

    public int getPhysicalDefenceGrowth() {
        return physicalDefenceGrowth;
    }

    public void setPhysicalDefenceGrowth(int physicalDefenceGrowth) {
        this.physicalDefenceGrowth = physicalDefenceGrowth;
    }

    public int getMagicalDefence() {
        return magicalDefence;
    }

    public void setMagicalDefence(int magicalDefence) {
        this.magicalDefence = magicalDefence;
    }

    public int getMagicalDefenceGrowth() {
        return magicalDefenceGrowth;
    }

    public void setMagicalDefenceGrowth(int magicalDefenceGrowth) {
        this.magicalDefenceGrowth = magicalDefenceGrowth;
    }

    public int getMinimumAttackRange() {
        return minimumAttackRange;
    }

    public void setMinimumAttackRange(int minimumAttackRange) {
        this.minimumAttackRange = minimumAttackRange;
    }

    public int getMaximumAttackRange() {
        return maximumAttackRange;
    }

    public void setMaximumAttackRange(int maximumAttackRange) {
        this.maximumAttackRange = maximumAttackRange;
    }

    public List<Integer> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Integer> abilities) {
        this.abilities = abilities;
    }
}
