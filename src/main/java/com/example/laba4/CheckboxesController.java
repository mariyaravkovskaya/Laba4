package com.example.laba4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CheckboxesController {
    @FXML
    private CheckBox checkbox1;
    @FXML
    private CheckBox checkbox2;
    @FXML
    private CheckBox checkbox3;

    @FXML
    private TextField widget1;
    @FXML
    private Label widget2;
    @FXML
    private Button widget3;

    @FXML
    private void initialize() {
        // Устанавливаем начальное состояние виджетов
        widget1.setVisible(false);
        widget2.setVisible(false);
        widget3.setVisible(false);

        // Добавляем слушателей к чекбоксам
        checkbox1.selectedProperty().addListener((observable, oldValue, newValue) -> {
            widget1.setVisible(newValue);
        });

        checkbox2.selectedProperty().addListener((observable, oldValue, newValue) -> {
            widget2.setVisible(newValue);
        });

        checkbox3.selectedProperty().addListener((observable, oldValue, newValue) -> {
            widget3.setVisible(newValue);
        });
    }
}
