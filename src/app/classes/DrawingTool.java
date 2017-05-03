package app.classes;

import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
                drawToolBar(),
                createCanvas()
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
        TextField widthOfCanvas = new TextField("400");
        TextField heightOfCanvas = new TextField("400");

        // Add elements to tool bar
        drawToolBar.getItems().addAll(saveButton, saveSeparator, widthOfCanvas, heightOfCanvas);

        return drawToolBar;
    }


    /**
     * Create Canvas Method
     */
    public static Canvas createCanvas() {
        // Create canvas and get graphics context
        Canvas canvas = new Canvas(400, 400);
        final GraphicsContext graphicContext = canvas.getGraphicsContext2D();
        initialiseDrawing(graphicContext);

        // Add on click event for canvas drawing
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                graphicContext.beginPath();
                graphicContext.moveTo(event.getX(), event.getY());
                graphicContext.stroke();
            }
        });

        // Add on drag handler for drawing line in canvas
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                graphicContext.lineTo(event.getX(), event.getY());
                graphicContext.stroke();
            }
        });

        // This breaks line on canvas
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Do nothing in order to break line
                graphicContext.closePath();
            }
        });

        return canvas;
    }


    /**
     * Initialise Drawing on Canvas
     * @param gc
     */
    public static void initialiseDrawing(GraphicsContext gc) {
        // Get width and height of canvas
        double canvasHeight = gc.getCanvas().getHeight();
        double canvasWidth = gc.getCanvas().getWidth();

        // Configure Graphic Context
        gc.setFill(Color.LIGHTGREY);
        gc.setFill(Color.BLACK);
        gc.setLineWidth(1);
        gc.fill();
        gc.strokeRect(0, 0, canvasWidth, canvasHeight);
    }

}
