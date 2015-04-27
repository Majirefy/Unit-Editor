package org.augix.ue.model;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import org.augix.ue.util.Palette;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Majirefy on 4/26/15.
 */
public class UnitLevelImageProvider {
    private static final int UNIT_SHEET_COLUMN = 12;
    private static final int UNIT_SHEET_ROW = 8;

    /**
     * Get unit level images by unit index.
     *
     * @param image     The unit image sheet file.
     * @param unitIndex The unit index on the sheet file starting from 0.
     * @return The unit level frame images.
     */
    public static List<UnitLevelImage> getUnitLevelImages(Image image, int unitIndex) {
        List<UnitLevelImage> unitLevelImages = new ArrayList<>();

        int unitImageWidth = (int) image.getWidth() / UNIT_SHEET_COLUMN;
        int unitImageHeight = (int) image.getHeight() / UNIT_SHEET_ROW;

        PixelReader pixelReader = image.getPixelReader();

        UnitLevelImage unitLevelImage = new UnitLevelImage();
        for (int row = 0; row < 8; row++) {
            WritableImage tempImage = new WritableImage(pixelReader, unitIndex * unitImageWidth, row * unitImageHeight,
                    unitImageWidth, unitImageHeight);
            if (row % 2 == 0) {
                unitLevelImage.setImageFrame0(tempImage);
            } else {
                unitLevelImage.setImageFrame1(tempImage);
                unitLevelImages.add(unitLevelImage);
            }
        }
        return unitLevelImages;
    }
}
