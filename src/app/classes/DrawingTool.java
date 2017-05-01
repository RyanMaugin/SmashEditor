package app.classes;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * SmashEditor
 * <p>
 * Created by Ryan on 01/05/2017.
 */
public class DrawingTool {

    /**
     * Create Draw Tool Stage
     */
    public static void createDrawToolWindow() {
        // Create Stage
        Stage drawToolStage = new Stage();

        // Create draw tool window root pane structure
        BorderPane root = new BorderPane();

        // Create VBox for stacking elements at top of border pane without overlap
        VBox verticalBox = new VBox();
        verticalBox.getChildren().addAll();
        root.setTop(verticalBox);

        // Configure stage
        drawToolStage.setTitle("Smash Editor - Draw Tool");
        drawToolStage.setScene(new Scene(root, 700, 504));
        drawToolStage.show();
    }

}
