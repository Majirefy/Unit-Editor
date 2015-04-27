package org.augix.ue.model;

/**
 * Created by Majirefy on 4/24/15.
 */
public class Settings {
    private String unitNameLocationString;
    private String unitImageLocationString;
    private String unitDataLocationString;

    public String getUnitDataLocationString() {
        return unitDataLocationString;
    }

    public void setUnitDataLocationString(String unitDataLocationString) {
        this.unitDataLocationString = unitDataLocationString;
    }

    public String getUnitNameLocationString() {
        return unitNameLocationString;
    }

    public void setUnitNameLocationString(String unitNameLocationString) {
        this.unitNameLocationString = unitNameLocationString;
    }

    public String getUnitImageLocationString() {
        return unitImageLocationString;
    }

    public void setUnitImageLocationString(String unitImageLocationString) {
        this.unitImageLocationString = unitImageLocationString;
    }
}
