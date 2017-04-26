package app.classes;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.List;

/**
 * SmashEditor
 * <p>
 * Created by Ryan on 26/04/2017.
 */
public class EditorWidget {

    /**
     * Menu Toolbar
     * The top most toolbar in application
     * @param root is the window root layout
     * @return MenuBar - this will return the created component
     */
    public static MenuBar menuToolBar(BorderPane root) {
        // Created menu bar
        MenuBar menuBar = new MenuBar();

        // ---------- Create menu option elements
        // 'File' Menu Option
        final Menu fileMenuOption = new Menu("File");
        MenuItem fileNewItem = new MenuItem("New");
        MenuItem fileOpenItem = new MenuItem("Open");
        MenuItem fileSaveItem = new MenuItem("Save");
        MenuItem fileRenameItem = new MenuItem("Rename");
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
        menuBar.getMenus().setAll(fileMenuOption, editMenuOption, toolsMenuOption, helpMenuOption);

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

        //
        // ---------- Create Bar ToggleElements
        //
        ToggleButton boldToggle = new ToggleButton("B");
        ToggleButton italicToggle = new ToggleButton("I");
        ToggleButton underlineToggle = new ToggleButton("U");

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

        // Add Toggles to editing toolbar
        editingToolBar.getItems().addAll(boldToggle, italicToggle, underlineToggle, fontSizeComboBox, alignmentComboBox);

        // Return editing tool bar
        return editingToolBar;
    }

}
