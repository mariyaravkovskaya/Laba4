package com.example.laba4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CalculatorController {
    @FXML
    private Label result;

    private float number1 = 0;
    private float number2 = 0;
    private String operator = "";
    private boolean start = true;

    @FXML
    public void processNumber(ActionEvent event) {
        if (start) {
            result.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();
        result.setText(result.getText() + value);
    }

    @FXML
    public void processBinaryOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!value.equals("=")) {
            if (!operator.isEmpty()) return;

            operator = value;
            number1 = Float.parseFloat(result.getText());
            result.setText("");
        } else {
            if (operator.isEmpty()) return;

            number2 = Float.parseFloat(result.getText());
            float output = calculateBinaryNumber(number1, number2, operator);
            result.setText(String.valueOf(output));
            operator = "";
        }
    }

    public void processUnaryOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!operator.isEmpty()) return;

        operator = value;
        number1 = Float.parseFloat(result.getText());
        float output = calculateUnaryNumber(number1, operator);
        result.setText(String.valueOf(output));
        operator = "";
    }

    @FXML
    public void ClearFunction(ActionEvent event) {
        operator = "";
        start = true;
        result.setText("");
    }

    public float calculateUnaryNumber(float number1, String operator) {
        switch (operator) {
            case "√":
                return (float) Math.sqrt(number1);
            default:
                return 0;
        }
    }

    public float calculateBinaryNumber(float number1, float number2, String operator) {
        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            case "/":
                if (number2 == 0) {
                    showError("Ошибка: Деление на ноль!");
                    return 0; // Или можно выбросить исключение
                }
                return number1 / number2;
            case "Mod":
                return number1 % number2;
            case "x^y":
                return (float) Math.pow(number1, number2);
            default:
                return 0;
        }
    }

    private void showError(String message) {
        // Создаем диалоговое окно для отображения сообщения об ошибке
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait(); // Показываем диалоговое окно и ждем, пока пользователь его закроет
    }

    private int factorial(int number) {
        if (number < 0) {
            showError("Ошибка: Факториал отрицательного числа!");
            return 0;
        }
        int fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }
}