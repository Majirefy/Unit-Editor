package org.augix.ue.util;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by Majirefy on 4/24/15.
 */
public class ImageOpsTest extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        // Create Image and ImageView objects
        InputStream inputStream = new FileInputStream("/Users/Majirefy/Developer/Ancient Empires II Reload/assets/images/units/unit_sheet_0.png");
        Image image = new Image(inputStream);
        ImageView imageView = new ImageView();
        imageView.setImage(image);

        // Obtain PixelReader
        PixelReader pixelReader = image.getPixelReader();
        System.out.println("Image Width: " + image.getWidth());
        System.out.println("Image Height: " + image.getHeight());
        System.out.println("Pixel Format: " + pixelReader.getPixelFormat());

        // Create WritableImage
        WritableImage wImage = new WritableImage((int) image.getWidth(), (int) image.getHeight());
        PixelWriter pixelWriter = wImage.getPixelWriter();

        for (int readY = 0; readY < image.getHeight(); readY++) {
            for (int readX = 0; readX < image.getWidth(); readX++) {
                Color color = pixelReader.getColor(readX, readY);
//                System.out.println("\nPixel color at coordinates (" +
//                        readX + "," + readY + ") "
//                        + color.toString());
//                System.out.println("R = " + color.getRed());
//                System.out.println("G = " + color.getGreen());
//                System.out.println("B = " + color.getBlue());
//                System.out.println("Opacity = " + color.getOpacity());
//                System.out.println("Saturation = " + color.getSaturation());

                // Now write a brighter color to the PixelWriter.

//                if (readX == 20 && readY == 18) {
//                    System.out.println("R = " + color.getRed());
//                    System.out.println("G = " + color.getGreen());
//                    System.out.println("B = " + color.getBlue());
//                }
//                if (color == Color.rgb(65, 149, 233, 1.0)) {
//                    color = Color.rgb(255, 255, 255, 1.0);
//                }
//                color = Color.color(color.getRed(), color.getGreen(), color.getBlue(), color.getOpacity());
//                if (color.getBlue() >= 0.5 && color.getRed() <= 0.5) {
//                    color = Color.BURLYWOOD;
//                }
                if (color.getGreen() >= 0.2 && color.getBlue() >= 0.4 && color.getRed() <= 0.3) {
                    color = Color.DARKCYAN;
                }
                if (color.getRed() >= 0.5 && color.getGreen() >= 0.8 && color.getBlue() >= 0.9 && color.getRed() <= 0.7 && color.getGreen() <= 0.9 && color.getBlue() < 1.0) {
                    color = Color.DARKGREEN;
                }
                pixelWriter.setColor(readX, readY, color);
            }
        }

        // Display image on screen
        imageView.setImage(wImage);
        StackPane root = new StackPane();
        root.getChildren().add(imageView);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Image Write Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
