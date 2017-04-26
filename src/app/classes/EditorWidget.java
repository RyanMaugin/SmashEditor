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

        // Create menu option elements
        final Menu fileMenuOption = new Menu("File");
        MenuItem fileNewItem = new MenuItem("New");
        MenuItem fileOpenItem = new MenuItem("Open");
        MenuItem fileSaveItem = new MenuItem("Save");
        MenuItem fileRenameItem = new MenuItem("Rename");
        fileMenuOption.getItems().addAll(fileNewItem, fileOpenItem, fileSaveItem, fileRenameItem);

        final Menu editMenuOption = new Menu("Edit");
        final Menu toolsMenuOption = new Menu("Tools");
        final Menu helpMenuOption = new Menu("Help");

        // Add all menu options to menu bar
        menuBar.getMenus().setAll(fileMenuOption, editMenuOption, toolsMenuOption, helpMenuOption);
        // Set the menu bar to the top of the frame border pane
        root.setTop(menuBar);
    }

}
