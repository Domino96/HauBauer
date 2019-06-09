package de.haubauer.ui.controllers;

import javafx.scene.Parent;
import javafx.scene.Scene;

public class SceneController {
    private Scene main;
    private static SceneController instance;

    public static SceneController getInstance() {
        if (SceneController.instance == null) {
            SceneController.instance = new SceneController();
        }

        return SceneController.instance;
    }

    public void setScene(Scene scene) {
        this.main = scene;
    }

    public void activate(Parent container){
        main.setRoot(container);
    }
}