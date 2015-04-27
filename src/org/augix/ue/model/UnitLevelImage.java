package org.augix.ue.model;

import javafx.scene.image.Image;

/**
 * Created by Majirefy on 4/26/15.
 */
public class UnitLevelImage {
    private Image imageFrame0;
    private Image imageFrame1;

    public UnitLevelImage() {
        super();
    }

    public UnitLevelImage(Image imageFrame0, Image imageFrame1) {
        this.imageFrame0 = imageFrame0;
        this.imageFrame1 = imageFrame1;
    }

    public Image getImageFrame0() {
        return imageFrame0;
    }

    public void setImageFrame0(Image imageFrame0) {
        this.imageFrame0 = imageFrame0;
    }

    public Image getImageFrame1() {
        return imageFrame1;
    }

    public void setImageFrame1(Image imageFrame1) {
        this.imageFrame1 = imageFrame1;
    }
}
