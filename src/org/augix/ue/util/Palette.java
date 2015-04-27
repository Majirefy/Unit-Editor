package org.augix.ue.util;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import org.augix.ue.model.PaletteMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Majirefy on 4/25/15.
 */
public class Palette {
//    private static Map<String, Color> originalColorMap = new HashMap<>();
//    private static Map<String, Color> redColorMap = new HashMap<>();
//    private static Map<String, Color> greenColorMap = new HashMap<>();
//    private static Map<String, Color> darkColorMap = new HashMap<>();

//    public static void generateColorMap(Image originalImage, Image redImage, Image greenImage, Image darkImage) {
//        PixelReader originalPixelReader = originalImage.getPixelReader();
//        PixelReader redPixelReader = redImage.getPixelReader();
//        PixelReader greenPixelReader = greenImage.getPixelReader();
//        PixelReader darkPixelReader = darkImage.getPixelReader();
//
//        for (int x = 0; x < originalImage.getWidth(); x++) {
//            for (int y = 0; y < originalImage.getHeight(); y++) {
//                String coordinate = x + "," + y;
//
//                Color color = originalPixelReader.getColor(x, y);
//                originalColorMap.put(coordinate, color);
//
//                if (!color.equals(redPixelReader.getColor(x, y))) {
//                    redColorMap.put(coordinate, redPixelReader.getColor(x, y));
//                }
//
//                if (!color.equals(greenPixelReader.getColor(x, y))) {
//                    greenColorMap.put(coordinate, greenPixelReader.getColor(x, y));
//                }
//
//                if (!color.equals(darkPixelReader.getColor(x, y))) {
//                    darkColorMap.put(coordinate, darkPixelReader.getColor(x, y));
//                }
//            }
//        }
//    }

//    public static Map<Color, Color> getRedPaletteMap() {
//        Map<Color, Color> redPaletteMap = new HashMap<>();
//
//        Iterator<String> coordinateIterator = redColorMap.keySet().iterator();
//        while (coordinateIterator.hasNext()) {
//            String coordinate = coordinateIterator.next();
//            Color color = redColorMap.get(coordinate);
//            if (redPaletteMap.containsValue(color)) {
//                continue;
//            } else {
//                Color originalColor = originalColorMap.get(coordinate);
//                redPaletteMap.put(originalColor, color);
//            }
//        }
//        return redPaletteMap;
//    }
//
//    public static Map<Color, Color> getGreenPaletteMap() {
//        Map<Color, Color> greenPaletteMap = new HashMap<>();
//
//        Iterator<String> coordinateIterator = greenColorMap.keySet().iterator();
//        while (coordinateIterator.hasNext()) {
//            String coordinate = coordinateIterator.next();
//            Color color = greenColorMap.get(coordinate);
//            if (greenPaletteMap.containsValue(color)) {
//                continue;
//            } else {
//                Color originalColor = originalColorMap.get(coordinate);
//                greenPaletteMap.put(originalColor, color);
//            }
//        }
//        return greenPaletteMap;
//    }
//
//    public static Map<Color, Color> getDarkPaletteMap() {
//        Map<Color, Color> darkPaletteMap = new HashMap<>();
//
//        Iterator<String> coordinateIterator = darkColorMap.keySet().iterator();
//        while (coordinateIterator.hasNext()) {
//            String coordinate = coordinateIterator.next();
//            Color color = darkColorMap.get(coordinate);
//            if (darkPaletteMap.containsValue(color)) {
//                continue;
//            } else {
//                Color originalColor = originalColorMap.get(coordinate);
//                darkPaletteMap.put(originalColor, color);
//            }
//        }
//        return darkPaletteMap;
//    }

    public static Image drawRedImage(Image originalImage) {
        WritableImage redImage = new WritableImage((int) originalImage.getWidth(), (int) originalImage.getHeight());
        PixelWriter pixelWriter = redImage.getPixelWriter();

        PixelReader pixelReader = originalImage.getPixelReader();
        for (int x = 0; x < originalImage.getWidth(); x++) {
            for (int y = 0; y < originalImage.getHeight(); y++) {
                Color color = pixelReader.getColor(x, y);
                if (PaletteMap.redPaletteMap.get(color) == null) {
                    pixelWriter.setColor(x, y, color);
                } else {
                    pixelWriter.setColor(x, y, PaletteMap.redPaletteMap.get(color));
                }
            }
        }
        return redImage;
    }

    public static Image drawGreenImage(Image originalImage) {
        WritableImage greenImage = new WritableImage((int) originalImage.getWidth(), (int) originalImage.getHeight());
        PixelWriter pixelWriter = greenImage.getPixelWriter();

        PixelReader pixelReader = originalImage.getPixelReader();
        for (int x = 0; x < originalImage.getWidth(); x++) {
            for (int y = 0; y < originalImage.getHeight(); y++) {
                Color color = pixelReader.getColor(x, y);
                if (PaletteMap.greenPaletteMap.get(color) == null) {
                    pixelWriter.setColor(x, y, color);
                } else {
                    pixelWriter.setColor(x, y, PaletteMap.greenPaletteMap.get(color));
                }
            }
        }
        return greenImage;
    }

    public static Image drawDarkImage(Image originalImage) {
        WritableImage darkImage = new WritableImage((int) originalImage.getWidth(), (int) originalImage.getHeight());
        PixelWriter pixelWriter = darkImage.getPixelWriter();

        PixelReader pixelReader = originalImage.getPixelReader();
        for (int x = 0; x < originalImage.getWidth(); x++) {
            for (int y = 0; y < originalImage.getHeight(); y++) {
                Color color = pixelReader.getColor(x, y);
                if (PaletteMap.darkPaletteMap.get(color) == null) {
                    pixelWriter.setColor(x, y, color);
                } else {
                    pixelWriter.setColor(x, y, PaletteMap.darkPaletteMap.get(color));
                }
            }
        }
        return darkImage;
    }
}
