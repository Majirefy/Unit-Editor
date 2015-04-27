package org.augix.ue.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import org.augix.ue.model.Settings;
import org.augix.ue.model.SettingsProvider;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Majirefy on 4/24/15.
 */
public class SettingsController implements Initializable {
    @FXML
    private TextField unitNameLocationTextField;
    @FXML
    private TextField unitImageLocationTextField;
    @FXML
    private TextField unitDataLocationTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Settings settings = SettingsProvider.getSettings();
        unitNameLocationTextField.setText(settings.getUnitNameLocationString());
        unitImageLocationTextField.setText(settings.getUnitImageLocationString());
        unitDataLocationTextField.setText(settings.getUnitDataLocationString());
    }

    public void chooseLocation(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        String id = button.getId();

        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select Location");
        File file = directoryChooser.showDialog(button.getScene().getWindow());

        if (file != null) {
            String path = file.getAbsolutePath();

            switch (id) {
                case "unitNameButton":
                    unitNameLocationTextField.setText(path);
                    break;
                case "unitImageButton":
                    unitImageLocationTextField.setText(path);
                    break;
                case "unitDataButton":
                    unitDataLocationTextField.setText(path);
                    break;
                default:
                    break;
            }
        }
    }

    public void saveSettings(ActionEvent actionEvent) {
        Settings settings = new Settings();
        Button button = (Button) actionEvent.getSource();

        String unitNameLocationString = unitNameLocationTextField.getText();
        String unitImageLocationString = unitImageLocationTextField.getText();
        String unitDataLocationString = unitDataLocationTextField.getText();

        settings.setUnitNameLocationString(unitNameLocationString);
        settings.setUnitImageLocationString(unitImageLocationString);
        settings.setUnitDataLocationString(unitDataLocationString);

        SettingsProvider.setSettings(settings);

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("../view/mainForm.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Unit Editor");
            stage.setResizable(false);
            stage.setScene(new Scene(root, 900, 600));
            stage.show();
            ((Stage) button.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cancel(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }
}
