package com.example.laba4;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.util.HashMap;
import java.util.Map;

public class RestaurantMenuController {
    @FXML
    private ListView<String> menuListView; // Список блюд
    @FXML
    private TextField quantityField; // Поле для ввода количества
    @FXML
    private TextArea receiptArea; // Поле для отображения чека
    @FXML
    private Button addButton; // Кнопка для добавления блюда в чек
    @FXML
    private Button resetButton; // Кнопка для сброса чека
    @FXML
    private Label totalLabel; // Метка для отображения общей стоимости

    private Map<String, Double> menuItems; // Меню с блюдами и ценами
    private double totalCost; // Общая стоимость заказа

    @FXML
    public void initialize() {
        // Инициализация меню
        menuItems = new HashMap<>();
        menuItems.put("Паста", 199.0);
        menuItems.put("Салат", 152.0);
        menuItems.put("Борщ", 149.0);
        menuItems.put("Плов", 310.0);
        menuItems.put("Куриный суп-пюре ", 175.0);
        menuItems.put("Пицца", 310.0);
        menuItems.put("Пирожок с мясом", 60.0);
        menuItems.put("Пирожок с луком и яйцом", 30.0);

        // Заполнение списка блюд
        menuListView.getItems().addAll(menuItems.keySet());

        // Установка обработчиков событий
        addButton.setOnAction(event -> addToReceipt());
        resetButton.setOnAction(event -> resetReceipt());
    }

    private void addToReceipt() {
        String selectedItem = menuListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            int quantity = Integer.parseInt(quantityField.getText().isEmpty() ? "1" : quantityField.getText());
            double price = menuItems.get(selectedItem);
            double itemCost = price * quantity;
            totalCost += itemCost;

            // Добавление информации в чек
            receiptArea.appendText(selectedItem + " x" + quantity + " = " + itemCost + " руб.\n");

            // Обновление метки с общей стоимостью
            totalLabel.setText("Итого: " + totalCost + " руб.");
        } else {
            showAlert("Ошибка", "Пожалуйста, выберите блюдо из меню.");
        }
    }

    private void resetReceipt() {
        receiptArea.clear();
        totalCost = 0;
        totalLabel.setText("Итого: 0 руб."); // Сброс метки с общей стоимостью
        quantityField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
