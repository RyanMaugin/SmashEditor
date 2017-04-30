package app.classes;

import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

/**
 * SmashEditor
 * <p>
 * Created by Ryan on 26/04/2017.
 */
public class EditorFileHandler {


    static String savePath = null;


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
                savePath = file.toString();
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
        // convert file content to byte array
        byte[] encoded = Files.readAllBytes(Paths.get(file.toURI()));
        // return string of data in file
        return new String(encoded, StandardCharsets.UTF_8);
    }


    /**
     * Save Method
     * @param content
     */
    public static void save(String content) {

        // If there is a save path because you are saving a file you opened
        if (savePath != null) {

            try (PrintWriter out = new PrintWriter(savePath)) {
                out.println(content);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        // If there is no open file savePath then create a new file
        } else {
             newFile();
        }
    }


    /**
     * Rename File Method
     * This method will rename a file
     */
    public static void rename() {

        if (savePath != null) {
            // Create new text input dialog to prompt user for new file name
            TextInputDialog renameDialog = promptUser("Rename File", "Enter New Name", "Enter new file name: ");

            // Get new file name response from text input dialog
            Optional<String> result = renameDialog.showAndWait();
            result.ifPresent(name -> {
                // Rename the file with response name
                File oldFile = new File(savePath);
                File newFile = new File(oldFile.getParent() + "/" + name);

                // Rename file and handle any error
                if (oldFile.renameTo(newFile)) System.out.println("File renamed!");
                else alertUser(Alert.AlertType.WARNING, "Warning", "Cannot leave file name empty", "Please enter a name for file!");
            });

        // If there is no open file to rename then show a warning alert telling the user
        } else {
            alertUser(
                    Alert.AlertType.WARNING,
                    "Cannot Rename Non-existent File",
                    "No File Opened",
                    "You need to open a file or create a new file in order to rename!"
            );
        }
    }


    /**
     * Create New File Method
     */
    public static void newFile() {
        // Display prompt dialog window to user
        TextInputDialog newfileDialog = promptUser("New File", "Create New File", "Enter new file name: ");

        // Get result
        Optional<String> result = newfileDialog.showAndWait();
        result.ifPresent(name -> {

            // Create new file and directory
            try {
                File newFile = new File("./archive/files/" + name);

                // Create file directory if it doesn't exist
                newFile.getParentFile().mkdirs();

                // Alert user that file was successfully created
                if (newFile.createNewFile()) {
                    alertUser(Alert.AlertType.INFORMATION, "File Create", "Successfully Created New File", "You can find your successfully created file at path " + newFile.getPath());
                }

            } catch (Exception e) { e.printStackTrace(); }

        });
    }


    /**
     * This is an alert method
     * @param alertType
     * @param title
     * @param headerText
     * @param contentText
     */
    public static void alertUser(Alert.AlertType alertType, String title, String headerText, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    /**
     * Prompt User Method
     * This will display a text input dialog
     * @param title
     * @param header
     * @param context
     */
    public static TextInputDialog promptUser(String title, String header, String context) {
        TextInputDialog promptDialog = new TextInputDialog("newname");
        promptDialog.setTitle(title);
        promptDialog.setHeaderText(header);
        promptDialog.setContentText(context);
        return promptDialog;
    }

}
