package sample;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class SceneController {
    private HashMap<String, Pane> screenMap = new HashMap<>();
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

    protected void addScreen(String name, Pane pane){
        screenMap.put(name, pane);
    }

    protected void removeScreen(String name){
        screenMap.remove(name);
    }

    protected void activate(String name){
        main.setRoot( screenMap.get(name) );
    }
}