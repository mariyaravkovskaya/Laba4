package com.example.laba4;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;

public class FlagController {
    @FXML
    private RadioButton red1, green1, blue1, yellow1, black1, white1, orange1; // Для первой полосы
    @FXML
    private RadioButton red2, green2, blue2, yellow2, black2, white2, orange2; // Для второй полосы
    @FXML
    private RadioButton red3, green3, blue3, yellow3, black3, white3, orange3; // Для третьей полосы
    @FXML
    private Button drawButton;

    private ToggleGroup group1;
    private ToggleGroup group2;
    private ToggleGroup group3;

    @FXML
    private void initialize() {
        // Создаем группы для радиокнопок
     /**   ToggleGroup group1 = new ToggleGroup();
        ToggleGroup group2 = new ToggleGroup();
        ToggleGroup group3 = new ToggleGroup();**/
        group1 = new ToggleGroup();
        group2 = new ToggleGroup();
        group3 = new ToggleGroup();

        red1.setToggleGroup(group1);
        green1.setToggleGroup(group1);
        blue1.setToggleGroup(group1);
        yellow1.setToggleGroup(group1);
        black1.setToggleGroup(group1);
        white1.setToggleGroup(group1);
        orange1.setToggleGroup(group1);

        red2.setToggleGroup(group2);
        green2.setToggleGroup(group2);
        blue2.setToggleGroup(group2);
        yellow2.setToggleGroup(group2);
        black2.setToggleGroup(group2);
        white2.setToggleGroup(group2);
        orange2.setToggleGroup(group2);

        red3.setToggleGroup(group3);
        green3.setToggleGroup(group3);
        blue3.setToggleGroup(group3);
        yellow3.setToggleGroup(group3);
        black3.setToggleGroup(group3);
        white3.setToggleGroup(group3);
        orange3.setToggleGroup(group3);
    }
    @FXML
    private void drawFlag() {
        String color1 = getSelectedColor(red1, green1, blue1, yellow1, black1, white1, orange1);
        String color2 = getSelectedColor(red2, green2, blue2, yellow2, black2, white2, orange2);
        String color3 = getSelectedColor(red3, green3, blue3, yellow3, black3, white3, orange3);

        String message = String.format("Выбранные цвета: %s, %s, %s", color1, color2, color3);
        Alert alert = new Alert(AlertType.INFORMATION, message);
        alert.setTitle("Результат");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    @FXML
    private void resetSelection() {
        group1.selectToggle(null);
        group2.selectToggle(null);
        group3.selectToggle(null);

    }

    private String getSelectedColor(RadioButton... buttons) {
        for (RadioButton button : buttons) {
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return "Не выбрано"; // Если ничего не выбрано
    }
}
