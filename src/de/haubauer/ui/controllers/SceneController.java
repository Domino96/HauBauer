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

    /**
     * Setzt die Hauptszene.
     */
    public void setScene(Scene scene) {
        this.main = scene;
    }

    /**
     * Setzt den übergebenen Container als Root-Element für die Hauptszene.
     */
    public void activate(Parent container){
        main.setRoot(container);
    }
}