package app.classes;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
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
        verticalBox.getChildren().addAll(
                // Add all components here
                drawToolBar()
        );
        root.setTop(verticalBox);

        // Configure stage
        drawToolStage.setTitle("Smash Editor - Draw Tool");
        drawToolStage.setScene(new Scene(root, 700, 504));
        drawToolStage.show();
    }


    /**
     * Draw Tool Bar
     * @return draw tool bar
     */
    public static ToolBar drawToolBar() {
        ToolBar drawToolBar = new ToolBar();

        // Create elements for tool bar
        Button saveButton = new Button("Save");
        Separator saveSeparator = new Separator(Orientation.VERTICAL);
        Button undoButon = new Button("Undo");
        Button redoButton = new Button("Redo");

        // Add elements to tool bar
        drawToolBar.getItems().addAll(saveButton, saveSeparator, undoButon, redoButton);

        return drawToolBar;
    }

}
