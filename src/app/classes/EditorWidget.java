package app.classes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * SmashEditor
 * <p>
 * Created by Ryan on 26/04/2017.
 */
public class EditorWidget {


    // Create Editor TextArea
    static HTMLEditor editorTextArea = new HTMLEditor();


    /**
     * Menu Toolbar
     * The top most toolbar in application
     * @param root is the window root layout
     * @return MenuBar - this will return the created component
     */
    public static MenuBar menuToolBar(BorderPane root, Stage stage) {
        // Created menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.setId("menuBar");

        // ---------- Create menu option elements
        // 'Smash Editor' Menu Option
        final Menu mainMenuOption = new Menu("Smash Editor");
        MenuItem mainContactDevItem = new MenuItem("Contact Developer");
        MenuItem mainFeedbackItem = new MenuItem("Feedback");
        mainMenuOption.getItems().addAll(mainFeedbackItem, mainContactDevItem);

        // 'File' Menu Option
        final Menu fileMenuOption = new Menu("File");
        MenuItem fileNewItem = new MenuItem("New");
        MenuItem fileOpenItem = new MenuItem("Open");
        fileOpenItem.setOnAction(event -> EditorFileHandler.open(stage, editorTextArea));
        MenuItem fileSaveItem = new MenuItem("Save");
        fileSaveItem.setOnAction(event -> EditorFileHandler.save(editorTextArea.getHtmlText()));
        MenuItem fileRenameItem = new MenuItem("Rename");
        fileRenameItem.setOnAction(event -> EditorFileHandler.rename());
        fileMenuOption.getItems().addAll(fileNewItem, fileOpenItem, fileSaveItem, fileRenameItem);

        // 'Edit' Menu Option
        final Menu editMenuOption = new Menu("Edit");
        MenuItem editCopyItem = new MenuItem("Copy");
        MenuItem editCutItem = new MenuItem("Cut");
        MenuItem editPasteItem = new MenuItem("Paste");
        MenuItem editSelectAllItem = new MenuItem("Select All");
        editMenuOption.getItems().addAll(editCopyItem, editCutItem, editPasteItem, editSelectAllItem);

        // 'Tools' Menu Option
        final Menu toolsMenuOption = new Menu("Tools");
        MenuItem toolsWordCountItem = new MenuItem("Word Count");
        MenuItem toolsLineCountItem = new MenuItem("Line Count");
        toolsMenuOption.getItems().addAll(toolsWordCountItem, toolsLineCountItem);

        // 'Help' Menu Option
        final Menu helpMenuOption = new Menu("Help");
        MenuItem helpCreditItem = new MenuItem("Credits");
        MenuItem helpSupportUsItem = new MenuItem("Support Us");
        MenuItem helpGithubItem = new MenuItem("Github Repo");
        helpMenuOption.getItems().addAll(helpCreditItem, helpSupportUsItem, helpGithubItem);

        // Add all menu options to menu bar
        menuBar.getMenus().setAll(mainMenuOption, fileMenuOption, editMenuOption, toolsMenuOption, helpMenuOption);

        // Return the created Menu Bar
        return menuBar;
    }


    /**
     * EditingToolBar
     * This will be the toolbar which handles all the text customisation features like bold,
     * underlining and font size etc
     * @param root is the window root layout
     * @return ToolBar - this will return the created component
     */
    public static ToolBar editingToolBar(BorderPane root) {
        // Create tool bar
        ToolBar editingToolBar = new ToolBar();
        editingToolBar.setId("editingToolbar");

        //
        // ---------- Create Redo and Undo
        //
        Button undoButton = new Button("Undo");
        Button redoButton = new Button("Redo");

        //
        // ---------- Create Bar ToggleElements
        //
        Separator toggleElementsTopSeparator = new Separator(Orientation.VERTICAL);
        ToggleButton boldToggle = new ToggleButton("B");
        ToggleButton italicToggle = new ToggleButton("I");
        ToggleButton underlineToggle = new ToggleButton("U");
        Separator toggleElementsBottomSeparator = new Separator(Orientation.VERTICAL);

        //
        // ---------- Create font size combo box (limit font size 1 - 32)
        //
        ComboBox<String> fontSizeComboBox = new ComboBox<>();
        // Placeholder for combo box
        fontSizeComboBox.setPromptText("Font size");
        // Populate combo box with font size items
        List<String> fontSizeComboBoxItems = new ArrayList<>();
        for (int x = 0; x < 33; x++) { fontSizeComboBoxItems.add(Integer.toString(x)); }
        // Set all font size items to combo box
        fontSizeComboBox.getItems().addAll(fontSizeComboBoxItems);

        //
        // ---------- Create Alignment combo box
        //
        ComboBox<String> alignmentComboBox = new ComboBox<>();
        // Placeholder for combo box
        alignmentComboBox.setPromptText("Alignment");
        // Add all alignments and populate alignmentComboBox
        alignmentComboBox.getItems().addAll("Left", "Center", "Right");

        // Add all created elements to editing tool bar in order
        editingToolBar.getItems().addAll(
                redoButton, undoButton,
                toggleElementsTopSeparator, boldToggle, italicToggle, underlineToggle, toggleElementsBottomSeparator,
                fontSizeComboBox, alignmentComboBox
        );

        // Return editing tool bar
        return editingToolBar;
    }


    /**
     * Editor (Text Area)
     * @param root is the window root layout
     * @return Text Area
     */
    public static HTMLEditor editor(BorderPane root) {
        // Set size of editor text area
        editorTextArea.setPrefSize(Double.MAX_VALUE, 440);
        return editorTextArea;
    }


    /**
     * Stats Footer
     * @param root is the window root layout
     * @return created footer stats toolbar which shows meta data
     */
    public static ToolBar statsFooter(BorderPane root) {
        // Create toolbar
        ToolBar footerBar = new ToolBar();
        footerBar.setId("statsToolbar");

        // Create toolbar label elements
        Label lineNumber = new Label("Line 1,");
        Label columnNumber = new Label("Column 3");

        // Add label elements to toolbar
        footerBar.getItems().addAll(lineNumber, columnNumber);

        // Return created footer toolbar
        return footerBar;
    }

}
