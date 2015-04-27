package org.augix.ue.model;

import javafx.scene.image.Image;
import org.augix.ue.util.ImageCropper;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Majirefy on 4/25/15.
 */
public class UnitGalleryFactory {
    private static final int UNIT_TILE_SIZE_WIDTH = 24;
    private static final int UNIT_TILE_SIZE_HEIGHT = 24;

    private static final int UNIT_DEFAULT_NUMBER = 12;

    private static List<Image> images = new LinkedList<>();

    public static List<Image> createDefaultUnitGallery(Image image) {
        int startX, startY;
        for (int i = 0; i < UNIT_DEFAULT_NUMBER; i++) {
            startX = i * UNIT_TILE_SIZE_WIDTH;
            startY = 0;
            images.add(ImageCropper.cropImage(image, startX, startY, UNIT_TILE_SIZE_WIDTH, UNIT_TILE_SIZE_HEIGHT));
        }
        return images;
    }

    public static List<Image> createDefaultUnitGallery(String imagePath) {
        int startX, startY;
        for (int i = 0; i < UNIT_DEFAULT_NUMBER; i++) {
            startX = i * UNIT_TILE_SIZE_WIDTH;
            startY = 0;
            images.add(ImageCropper.cropImage(imagePath, startX, startY, UNIT_TILE_SIZE_WIDTH, UNIT_TILE_SIZE_HEIGHT));
        }
        return images;
    }

    public static List<Image> updateUnitGallery(Image image) {
        images.add(0, image);
        return images;
    }
}
