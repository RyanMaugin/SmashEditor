package app;

import app.classes.EditorWidget;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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

        // Vertical Box to hold elements stacked vertically
        VBox verticalBox = new VBox();
        // Set all elements inside vertical box that need to be stacked top down
        verticalBox.getChildren().addAll(
                EditorWidget.menuToolBar(root),
                EditorWidget.editingToolBar(root)
        );
        // Set vertical box to top of border pane
        root.setTop(verticalBox);

        // Add stats footer to bottom of border pane as footer
        root.setBottom(EditorWidget.statsFooter(root));

        // Configure window
        primaryStage.setTitle("Smash Editor");
        primaryStage.setScene(new Scene(root, 700, 475));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
