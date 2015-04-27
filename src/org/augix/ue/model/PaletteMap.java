package org.augix.ue.model;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Majirefy on 4/26/15.
 */
public class PaletteMap {
    private static final String paletteFile = "file:img/palette.png";

    public static Map<Color, Color> redPaletteMap = new HashMap<>();
    public static Map<Color, Color> greenPaletteMap = new HashMap<>();
    public static Map<Color, Color> darkPaletteMap = new HashMap<>();

    public static void generatePaletteMap() {
        Image paletteImage = new Image(paletteFile);
        PixelReader pixelReader = paletteImage.getPixelReader();
        for (int x = 0; x < paletteImage.getWidth(); x++) {
            Color originalColor = pixelReader.getColor(x, 0);
            Color redColor = pixelReader.getColor(x, 1);
            Color greenColor = pixelReader.getColor(x, 2);
            Color darkColor = pixelReader.getColor(x, 3);

            redPaletteMap.put(originalColor, redColor);
            greenPaletteMap.put(originalColor, greenColor);
            darkPaletteMap.put(originalColor, darkColor);
        }
    }
}
