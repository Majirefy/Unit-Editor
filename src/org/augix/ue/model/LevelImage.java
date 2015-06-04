package org.augix.ue.model;

import javafx.scene.image.Image;

/**
 * Created by Majirefy on 6/4/15.
 */
public class LevelImage {
    private boolean isChanged;
    private Image levelImage;

    public LevelImage(boolean isChanged, Image levelImage) {
        this.isChanged = isChanged;
        this.levelImage = levelImage;
    }

    public LevelImage() {
        this.isChanged = false;
        this.levelImage = null;
    }

    public boolean isChanged() {
        return isChanged;
    }

    public void setIsChanged(boolean isChanged) {
        this.isChanged = isChanged;
    }

    public Image getLevelImage() {
        return levelImage;
    }

    public void setLevelImage(Image levelImage) {
        this.levelImage = levelImage;
    }
}
