package org.augix.ue.model;

/**
 * Created by Majirefy on 6/4/15.
 */
public class LevelImageList {
    private LevelImage[] levelImages = new LevelImage[4];


    public LevelImageList() {
        for (int i = 0; i < 4; i++) {
            levelImages[i] = new LevelImage();
        }
    }

    public LevelImage[] getLevelImages() {
        return levelImages;
    }

    public void setLevelImages(LevelImage[] levelImages) {
        this.levelImages = levelImages;
    }
}
