package app.classes;

import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * SmashEditor
 * <p>
 * Created by Ryan on 26/04/2017.
 */
public class EditorFileHandler {

    /**
     * Open File
     * Makes use of file chooser to open file
     * @param stage the window
     */
    public static void open(Stage stage, HTMLEditor editor) {
        // Create FileChooser
        FileChooser fileChooser = new FileChooser();

        // Configure file chooser
        fileChooser.setTitle("Open File");

        // Handle file selection
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            try {
                editor.setHtmlText(getOpenedFileContent(file));
            } catch (Exception exception) {
                System.out.println(exception);
            }
        }
    }


    /**
     * Get's content of opened file
     * @param file
     * @return content of opened file
     */
    public static String getOpenedFileContent(File file) throws Exception {
        byte[] encoded = Files.readAllBytes(Paths.get(file.toURI()));
        return new String(encoded, StandardCharsets.UTF_8);
    }

}
