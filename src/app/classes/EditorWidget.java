package app.classes;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

/**
 * SmashEditor
 * <p>
 * Created by Ryan on 26/04/2017.
 */
public class EditorWidget {

    /**
     * Menu Toolbar
     * The top most toolbar in application
     * @param root
     */
    public static void menuToolBar(BorderPane root) {
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
        // Set the menu bar to the top of the frame border pane
        root.setTop(menuBar);
    }

}
