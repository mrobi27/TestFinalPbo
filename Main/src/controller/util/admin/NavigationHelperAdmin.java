package controller.util.admin;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class NavigationHelperAdmin {

    public static void navigate(AnchorPane contentPane, String buttonId) {
        String fxmlFile;

        switch (buttonId) {
            case "homeBtn":
                fxmlFile = "/view/admin/Dashboard.fxml";
                break;
            case "booksBtn":
                fxmlFile = "/view/admin/ManageBooks.fxml";
                break;
            case "returnBtn":
                fxmlFile = "/view/admin/ReturnBooks.fxml";
                break;
            case "reportBtn":
                fxmlFile = "/view/admin/Reports.fxml";
                break;
            case "logoutBtn":
                Util.LogoutManager.logout(); // proses logout dan arahkan ke login
                return;
            default:
                System.err.println("Unknown button id: " + buttonId);
                return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(NavigationHelperAdmin.class.getResource(fxmlFile));
            Parent newContent = loader.load();
            contentPane.getChildren().setAll(newContent);

            // Set anchor ke semua sisi supaya isi memenuhi AnchorPane
            AnchorPane.setTopAnchor(newContent, 0.0);
            AnchorPane.setRightAnchor(newContent, 0.0);
            AnchorPane.setBottomAnchor(newContent, 0.0);
            AnchorPane.setLeftAnchor(newContent, 0.0);

        } catch (IOException e) {
            System.err.println("Failed to load FXML file: " + fxmlFile);
            e.printStackTrace();
        }
    }
}
