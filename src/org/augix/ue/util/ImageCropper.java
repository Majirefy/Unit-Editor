package org.augix.ue.util;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by Majirefy on 4/24/15.
 */
public class ImageCropper {
    public static Image cropImage(Image fromImage, int startX, int startY, int width, int height) {
        if (fromImage != null) {
            PixelReader pixelReader = fromImage.getPixelReader();
            WritableImage image = new WritableImage(pixelReader, startX, startY, width, height);
            return image;
        } else {
            return null;
        }
    }

    public static Image cropImage(String fromImagePath, int startX, int startY, int width, int height) {
        Image fromImage = null;
        try {
            InputStream inputStream = new FileInputStream(fromImagePath);
            fromImage = new Image(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (fromImage != null) {
            PixelReader pixelReader = fromImage.getPixelReader();
            WritableImage image = new WritableImage(pixelReader, startX, startY, width, height);
            return image;
        } else {
            return null;
        }
    }
}
