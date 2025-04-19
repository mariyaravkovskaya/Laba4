package com.example.laba4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class WordSwitcherController {
    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;

    @FXML
    private Button switchButton;

    private boolean isFirstToSecond = true;

    @FXML
    private void switchWords() {
        if (isFirstToSecond) {
            textField2.setText(textField1.getText());
            textField1.clear();
            switchButton.setText("←");
        } else {
            textField1.setText(textField2.getText());
            textField2.clear();
            switchButton.setText("→");
        }
        isFirstToSecond = !isFirstToSecond; // Меняем направление
    }
}
