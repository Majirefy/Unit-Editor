package org.augix.ue.controller;

import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.augix.ue.model.*;
import org.augix.ue.ui.NumericTextField;
import org.augix.ue.util.ImageCropper;
import org.augix.ue.util.Palette;
import org.augix.ue.util.UnitDataFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private final String DEFAULT_UNIT_FILE = "/unit_sheet_0.png";
    private final String RED_UNIT_FILE = "/unit_sheet_1.png";
    private final String GREEN_UNIT_FILE = "/unit_sheet_2.png";
    private final String DARK_UNIT_FILE = "/unit_sheet_3.png";

    @FXML
    private ImageView level0ImageView;
    @FXML
    private ImageView level1ImageView;
    @FXML
    private ImageView level2ImageView;
    @FXML
    private ImageView level3ImageView;

    @FXML
    private TextField unitNameTextField;
    @FXML
    private NumericTextField unitPriceTextField;
    @FXML
    private NumericTextField maxHealthPointsTextField;
    @FXML
    private NumericTextField healthPointGrowthTextField;
    @FXML
    private NumericTextField movementPointsTextField;
    @FXML
    private NumericTextField movementPointsGrowhTextField;
    @FXML
    private NumericTextField attackPowerTextField;
    @FXML
    private NumericTextField attackPowerGrowthTextField;
    @FXML
    private NumericTextField physicalDefenceTextField;
    @FXML
    private NumericTextField physicalDefenceGrowthTextField;
    @FXML
    private NumericTextField magicalDefenceTextField;
    @FXML
    private NumericTextField magicalDefenceGrowthTextField;
    @FXML
    private NumericTextField minimumAttackRangeTextField;
    @FXML
    private NumericTextField maximumAttackRangeTextField;
    @FXML
    private ComboBox<String> attackTypeComboBox;

    @FXML
    private ListView allAbilityListView;
    @FXML
    private ListView currentAbilityListView;

    @FXML
    private ToggleGroup unitGalleryToggleGroup;

    @FXML
    private HBox unitGalleryHBox;

    private ToggleButton[] unitToggleButtons = new ToggleButton[12];
    private int unitIndex;
    private final LevelImageList[] allLevelImagesList = new LevelImageList[12];

    @Override
    public void initialize(URL location, final ResourceBundle resources) {
        final FileChooser fileChooser = new FileChooser();
        configureFileChooser(fileChooser);
        for (int i = 0; i < 12; i++) {
            allLevelImagesList[i] = new LevelImageList();
        }
        PaletteMap.generatePaletteMap();

        attackTypeComboBox.getItems().addAll("Physical", "Magical");

        allAbilityListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        currentAbilityListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // Initialize unit gallery.
        List<Image> images = UnitGalleryFactory.createDefaultUnitGallery(SettingsProvider.getSettings().getUnitImageLocationString()
                + DEFAULT_UNIT_FILE);
        for (int i = 0; i < unitToggleButtons.length; i++) {
            final ImageView toggleImage = new ImageView();
            toggleImage.setPreserveRatio(true);
            toggleImage.setFitWidth(48.0);
            unitToggleButtons[i] = new ToggleButton();
            unitToggleButtons[i].setId(String.valueOf(i));
            unitToggleButtons[i].setGraphic(toggleImage);
            unitToggleButtons[i].setToggleGroup(unitGalleryToggleGroup);
//            unitToggleButtons[i].setOnAction(event -> {
//                int unitIndex = Integer.parseInt(((ToggleButton) event.getSource()).getId());
//                this.unitIndex = unitIndex;
//                reloadData(unitIndex);
//            });
            unitToggleButtons[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    unitIndex = Integer.parseInt(((ToggleButton) event.getSource()).getId());
                    reloadData(unitIndex);
                }
            });
            toggleImage.imageProperty().bind(Bindings.when(unitToggleButtons[i].selectedProperty()).
                    then(images.get(i)).otherwise(images.get(i)));
            unitGalleryHBox.getChildren().add(unitToggleButtons[i]);
        }
        unitToggleButtons[0].setSelected(true);

        final int selectUnitIndex = Integer.parseInt(((ToggleButton) unitGalleryToggleGroup.getSelectedToggle()).getId());

        level0ImageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                File file = fileChooser.showOpenDialog(level0ImageView.getScene().getWindow());
                Image image;
                if (file != null) {
                    image = new Image("file:" + file.getAbsolutePath());
                    int width = (int) image.getWidth();
                    int height = (int) image.getHeight();
                    if (width != 24 || height != 48) {
                        Stage dialog = new Stage();
                        dialog.initStyle(StageStyle.UTILITY);
                        dialog.setResizable(false);
                        dialog.setWidth(300);
                        dialog.setHeight(100);
                        Scene scene = new Scene(new Group(new Text(25, 25, "The size of image must be 24*48.")));
                        dialog.setScene(scene);
                        dialog.show();
                    } else {
                        level0ImageView.setImage(ImageCropper.cropImage(image, 0, 0, 24, 24));
                        LevelImage levelImage = new LevelImage(true, image);
                        allLevelImagesList[unitIndex].getLevelImages()[0] = levelImage;
                    }
                }
                mouseEvent.consume();
            }
        });

        level1ImageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                File file = fileChooser.showOpenDialog(level1ImageView.getScene().getWindow());
                Image image;
                if (file != null) {
                    image = new Image("file:" + file.getAbsolutePath());
                    int width = (int) image.getWidth();
                    int height = (int) image.getHeight();
                    if (width != 24 || height != 48) {
                        Stage dialog = new Stage();
                        dialog.initStyle(StageStyle.UTILITY);
                        dialog.setResizable(false);
                        dialog.setWidth(300);
                        dialog.setHeight(100);
                        Scene scene = new Scene(new Group(new Text(25, 25, "The size of image must be 24*48.")));
                        dialog.setScene(scene);
                        dialog.show();
                    } else {
                        level1ImageView.setImage(ImageCropper.cropImage(image, 0, 0, 24, 24));
                        LevelImage levelImage = new LevelImage(true, image);
                        allLevelImagesList[unitIndex].getLevelImages()[1] = levelImage;
                    }
                }
                mouseEvent.consume();
            }
        });

        level2ImageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                File file = fileChooser.showOpenDialog(level2ImageView.getScene().getWindow());
                Image image;
                if (file != null) {
                    image = new Image("file:" + file.getAbsolutePath());
                    int width = (int) image.getWidth();
                    int height = (int) image.getHeight();
                    if (width != 24 || height != 48) {
                        Stage dialog = new Stage();
                        dialog.initStyle(StageStyle.UTILITY);
                        dialog.setResizable(false);
                        dialog.setWidth(300);
                        dialog.setHeight(100);
                        Scene scene = new Scene(new Group(new Text(25, 25, "The size of image must be 24*48.")));
                        dialog.setScene(scene);
                        dialog.show();
                    } else {
                        level2ImageView.setImage(ImageCropper.cropImage(image, 0, 0, 24, 24));
                        LevelImage levelImage = new LevelImage(true, image);
                        allLevelImagesList[unitIndex].getLevelImages()[2] = levelImage;
                    }
                }
                mouseEvent.consume();
            }
        });

        level3ImageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                File file = fileChooser.showOpenDialog(level3ImageView.getScene().getWindow());
                Image image;
                if (file != null) {
                    image = new Image("file:" + file.getAbsolutePath());
                    int width = (int) image.getWidth();
                    int height = (int) image.getHeight();
                    if (width != 24 || height != 48) {
                        Stage dialog = new Stage();
                        dialog.initStyle(StageStyle.UTILITY);
                        dialog.setResizable(false);
                        dialog.setWidth(300);
                        dialog.setHeight(100);
                        Scene scene = new Scene(new Group(new Text(25, 25, "The size of image must be 24*48.")));
                        dialog.setScene(scene);
                        dialog.show();
                    } else {
                        level3ImageView.setImage(ImageCropper.cropImage(image, 0, 0, 24, 24));
                        LevelImage levelImage = new LevelImage(true, image);
                        allLevelImagesList[unitIndex].getLevelImages()[3] = levelImage;
                    }
                }
                mouseEvent.consume();
            }
        });

        reloadData(selectUnitIndex);
    }

    private void configureFileChooser(FileChooser fileChooser) {
        fileChooser.setTitle("Select Image for Level");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG", "*.png"));
    }

    private void reloadData(int unitIndex) {
        if (unitIndex == 9) {
            level0ImageView.setDisable(true);
            level1ImageView.setDisable(true);
            level2ImageView.setDisable(true);
            level3ImageView.setDisable(true);
        } else {
            level0ImageView.setDisable(false);
            level1ImageView.setDisable(false);
            level2ImageView.setDisable(false);
            level3ImageView.setDisable(false);
        }

//        // Initialize unit level images.
//        Image image = new Image("file:" + SettingsProvider.getSettings().getUnitImageLocationString() + DEFAULT_UNIT_FILE);
//        List<UnitLevelImage> unitLevelImages = UnitLevelImageProvider.getUnitLevelImages(image, unitIndex);
//        level0ImageView.setImage(unitLevelImages.get(0).getImageFrame0());
//        level1ImageView.setImage(unitLevelImages.get(1).getImageFrame0());
//        level2ImageView.setImage(unitLevelImages.get(2).getImageFrame0());
//        level3ImageView.setImage(unitLevelImages.get(3).getImageFrame0());

        Image image = new Image("file:" + SettingsProvider.getSettings().getUnitImageLocationString() + DEFAULT_UNIT_FILE);
        level0ImageView.setImage(ImageCropper.cropImage(image, unitIndex * 24, 0, 24, 24));
        level1ImageView.setImage(ImageCropper.cropImage(image, unitIndex * 24, 48, 24, 24));
        level2ImageView.setImage(ImageCropper.cropImage(image, unitIndex * 24, 96, 24, 24));
        level3ImageView.setImage(ImageCropper.cropImage(image, unitIndex * 24, 144, 24, 24));

        if (allLevelImagesList[unitIndex].getLevelImages()[0].isChanged()) {
            level0ImageView.setImage(ImageCropper.cropImage(allLevelImagesList[unitIndex].getLevelImages()[0].getLevelImage(), 0, 0, 24, 24));
        }
        if (allLevelImagesList[unitIndex].getLevelImages()[1].isChanged()) {
            level1ImageView.setImage(ImageCropper.cropImage(allLevelImagesList[unitIndex].getLevelImages()[1].getLevelImage(), 0, 0, 24, 24));
        }
        if (allLevelImagesList[unitIndex].getLevelImages()[2].isChanged()) {
            level2ImageView.setImage(ImageCropper.cropImage(allLevelImagesList[unitIndex].getLevelImages()[2].getLevelImage(), 0, 0, 24, 24));
        }
        if (allLevelImagesList[unitIndex].getLevelImages()[3].isChanged()) {
            level3ImageView.setImage(ImageCropper.cropImage(allLevelImagesList[unitIndex].getLevelImages()[3].getLevelImage(), 0, 0, 24, 24));
        }

        if (UnitDataFactory.readUnitName(unitIndex) != null) {
            unitNameTextField.setText(UnitDataFactory.readUnitName(unitIndex));
        } else {
            unitNameTextField.setText("");
        }

        if (UnitDataFactory.readUnitData(unitIndex) != null) {
            Unit unit = UnitDataFactory.readUnitData(unitIndex);
            unitPriceTextField.setText(String.valueOf(unit.getUnitPrice()));
            maxHealthPointsTextField.setText(String.valueOf(unit.getMaxHealthPoints()));
            healthPointGrowthTextField.setText(String.valueOf(unit.getHealthPointsGrowth()));
            movementPointsTextField.setText(String.valueOf(unit.getMovementPoints()));
            movementPointsGrowhTextField.setText(String.valueOf(unit.getMovementGrowth()));
            attackPowerTextField.setText(String.valueOf(unit.getAttackPower()));
            attackPowerGrowthTextField.setText(String.valueOf(unit.getAttackPowerGrowth()));
            physicalDefenceTextField.setText(String.valueOf(unit.getPhysicalDefence()));
            physicalDefenceGrowthTextField.setText(String.valueOf(unit.getPhysicalDefenceGrowth()));
            magicalDefenceTextField.setText(String.valueOf(unit.getMagicalDefence()));
            magicalDefenceGrowthTextField.setText(String.valueOf(unit.getMagicalDefenceGrowth()));
            minimumAttackRangeTextField.setText(String.valueOf(unit.getMinimumAttackRange()));
            maximumAttackRangeTextField.setText(String.valueOf(unit.getMaximumAttackRange()));
            attackTypeComboBox.setValue(attackTypeComboBox.getItems().get(unit.getAttackType()));
            ObservableList allAbilityList = Ability.getAllAbilityNamesList();
            ObservableList currentAbilityList = currentAbilityListView.getItems();
            currentAbilityList.clear();
            for (int i = 0; i < unit.getAbilities().size(); i++) {
                currentAbilityList.add(allAbilityList.get(unit.getAbilities().get(i)));
            }
            for (int i = 0; i < unit.getAbilities().size(); i++) {
//                allAbilityList.remove((int) unit.getAbilities().get(i));
                allAbilityList.removeAll(unit.getAbilities());
            }
            allAbilityListView.setItems(allAbilityList);
        } else {
            unitPriceTextField.setText("0");
            maxHealthPointsTextField.setText("0");
            healthPointGrowthTextField.setText("0");
            movementPointsTextField.setText("0");
            movementPointsGrowhTextField.setText("0");
            attackPowerTextField.setText("0");
            attackPowerGrowthTextField.setText("0");
            physicalDefenceTextField.setText("0");
            physicalDefenceGrowthTextField.setText("0");
            magicalDefenceTextField.setText("0");
            magicalDefenceGrowthTextField.setText("0");
            minimumAttackRangeTextField.setText("0");
            maximumAttackRangeTextField.setText("0");
            attackTypeComboBox.setValue(attackTypeComboBox.getItems().get(0));
            allAbilityListView.setItems(Ability.getAllAbilityNamesList());
//            for (int i = 0; i < currentAbilityListView.getItems().size(); i++) {
//                currentAbilityListView.getItems().remove(i);
//            }
            currentAbilityListView.getItems().clear();
        }
    }

    public void addAbility() {
        ObservableList selectedItems = allAbilityListView.getSelectionModel().getSelectedItems();
        currentAbilityListView.getItems().addAll(selectedItems);
        allAbilityListView.getItems().removeAll(selectedItems);
    }

    public void removeAbility() {
        ObservableList selectedItems = currentAbilityListView.getSelectionModel().getSelectedItems();
        allAbilityListView.getItems().addAll(selectedItems);
        currentAbilityListView.getItems().removeAll(selectedItems);
    }

    public void save(ActionEvent actionEvent) {
        Unit unit = new Unit();
        unit.setUnitName(unitNameTextField.getText());
        unit.setUnitPrice(Integer.parseInt(unitPriceTextField.getText()));
        unit.setMaxHealthPoints(Integer.parseInt(maxHealthPointsTextField.getText()));
        unit.setMovementPoints(Integer.parseInt(movementPointsTextField.getText()));
        unit.setAttackPower(Integer.parseInt(attackPowerTextField.getText()));
        unit.setPhysicalDefence(Integer.parseInt(physicalDefenceTextField.getText()));
        unit.setMagicalDefence(Integer.parseInt(magicalDefenceTextField.getText()));
        unit.setAttackType(attackTypeComboBox.getSelectionModel().getSelectedIndex());
        unit.setHealthPointsGrowth(Integer.parseInt(healthPointGrowthTextField.getText()));
        unit.setMovementGrowth(Integer.parseInt(movementPointsGrowhTextField.getText()));
        unit.setAttackPowerGrowth(Integer.parseInt(attackPowerGrowthTextField.getText()));
        unit.setPhysicalDefenceGrowth(Integer.parseInt(physicalDefenceGrowthTextField.getText()));
        unit.setMagicalDefenceGrowth(Integer.parseInt(magicalDefenceGrowthTextField.getText()));
        unit.setMaximumAttackRange(Integer.parseInt(maximumAttackRangeTextField.getText()));
        unit.setMinimumAttackRange(Integer.parseInt(minimumAttackRangeTextField.getText()));
        unit.setAbilityCount(currentAbilityListView.getItems().size());
        List<Integer> abilities = new ArrayList<>();
        for (int i = 0; i < currentAbilityListView.getItems().size(); i++) {
            abilities.add(Ability.getAbilityIndexMap().get(currentAbilityListView.getItems().get(i)));
            unit.setAbilities(abilities);
        }


        UnitDataFactory.saveUnitName(unitIndex, unitNameTextField.getText());
        UnitDataFactory.saveUnitData(unitIndex, unit);

        Image defaultImage = new Image("file:" + SettingsProvider.getSettings().getUnitImageLocationString() + DEFAULT_UNIT_FILE);
        Image newDefaultImage = Palette.drawDefaultImage(defaultImage, allLevelImagesList);
        File file = new File(SettingsProvider.getSettings().getUnitImageLocationString() + DEFAULT_UNIT_FILE);
        if (file.exists()) {
            file.delete();
        }
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(newDefaultImage, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image redImage = new Image("file:" + SettingsProvider.getSettings().getUnitImageLocationString() + RED_UNIT_FILE);
        Image newRedImage = Palette.drawRedImage(redImage, allLevelImagesList);
        file = new File(SettingsProvider.getSettings().getUnitImageLocationString() + RED_UNIT_FILE);
        if (file.exists()) {
            file.delete();
        }
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(newRedImage, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image greenImage = new Image("file:" + SettingsProvider.getSettings().getUnitImageLocationString() + GREEN_UNIT_FILE);
        Image newGreenImage = Palette.drawGreenImage(greenImage, allLevelImagesList);
        file = new File(SettingsProvider.getSettings().getUnitImageLocationString() + GREEN_UNIT_FILE);
        if (file.exists()) {
            file.delete();
        }
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(newGreenImage, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image darkImage = new Image("file:" + SettingsProvider.getSettings().getUnitImageLocationString() + DARK_UNIT_FILE);
        Image newDarkImage = Palette.drawDarkImage(darkImage, allLevelImagesList);
        file = new File(SettingsProvider.getSettings().getUnitImageLocationString() + DARK_UNIT_FILE);
        if (file.exists()) {
            file.delete();
        }
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(newDarkImage, null), "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Image redImage = Palette.drawRedImage(image);
//        Image greenImage = Palette.drawGreenImage(image);
//        Image darkImage = Palette.drawDarkImage(image);
//
//        File file = new File(SettingsProvider.getSettings().getUnitImageLocationString() + RED_UNIT_FILE);
//        if (file.exists()) {
//            file.delete();
//        }
//        try {
//            ImageIO.write(SwingFXUtils.fromFXImage(redImage, null), "png", file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        file = new File(SettingsProvider.getSettings().getUnitImageLocationString() + GREEN_UNIT_FILE);
//        if (file.exists()) {
//            file.delete();
//        }
//        try {
//            ImageIO.write(SwingFXUtils.fromFXImage(greenImage, null), "png", file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        file = new File(SettingsProvider.getSettings().getUnitImageLocationString() + DARK_UNIT_FILE);
//        if (file.exists()) {
//            file.delete();
//        }
//        try {
//            ImageIO.write(SwingFXUtils.fromFXImage(darkImage, null), "png", file);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
