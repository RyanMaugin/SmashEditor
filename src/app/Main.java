package app;

import app.classes.EditorWidget;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    /**
     * Start function wil run when application is run/initialised
     * @param primaryStage is the window itself
     * @throws Exception is what this function will throw if there is an error
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Set root window structure as border pane
        BorderPane root = new BorderPane();

        // Add menu bar
        EditorWidget.menuToolBar(root);

        // Configure window
        primaryStage.setTitle("Smash Editor");
        primaryStage.setScene(new Scene(root, 700, 475));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
