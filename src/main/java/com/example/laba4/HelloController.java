package com.example.laba4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Button switchButton; // Кнопка для открытия формы "Перекидыватель слов"
    @FXML
    private Button checkboxesButton; // Кнопка для открытия формы "Чекбоксы"
    @FXML
    private Button flagButton; // Кнопка для открытия формы "Текстовый флаг"
    @FXML
    private Button restaurantMenuButton; // Кнопка для открытия формы "Меню ресторана"
    @FXML
    private Button calculatorButton; // Кнопка для открытия формы "Калькулятор"

    @FXML
    public void initialize() {
        // Устанавливаем обработчики событий для кнопок
        switchButton.setOnAction(event -> openWindow("word_switcher.fxml", "Перекидыватель слов"));
        checkboxesButton.setOnAction(event -> openWindow("checkboxes-view.fxml", "Чекбоксы"));
        flagButton.setOnAction(event -> openWindow("flag-view.fxml", "Текстовый флаг"));
        restaurantMenuButton.setOnAction(event -> openWindow("restaurant_menu.fxml", "Меню ресторана"));
        calculatorButton.setOnAction(event -> openWindow("calculator.fxml", "Калькулятор"));
    }

    private void openWindow(String fxmlFile, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(root, 500, 600));
            stage.setResizable(false); // Запретить изменение размера окна
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR, "Ошибка при открытии формы!");
            alert.showAndWait();
        }
    }
}




/**
public class HelloController implements Initializable {

    @FXML
    private Button switchButton;

    @FXML
    private void openWordSwitcher() throws Exception {
        WordSwitcherApplication wordSwitcher = new WordSwitcherApplication();
        wordSwitcher.start(new Stage());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        switchButton.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("word_switcher.fxml"));
                Scene scene = new Scene(loader.load());
                Stage stage = new Stage();
                stage.setTitle("Перекидыватель слов");
                stage.setScene(scene);
                stage.setResizable(false); // Запретить изменение размера окна
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
**/


