package com.example.laba4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WordSwitcherApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(WordSwitcherApplication.class.getResource("word_switcher.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 200);
        stage.setTitle("Перекидыватель слов");
        stage.setScene(scene);
        stage.setResizable(false); // Запрет изменения размера окна
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
