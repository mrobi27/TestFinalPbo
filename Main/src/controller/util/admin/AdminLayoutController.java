package controller.util.admin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class AdminLayoutController {

    @FXML
    private AnchorPane contentPane;

    @FXML
    private Button homeBtn, booksBtn, returnBtn, reportBtn, logoutBtn;

    @FXML
    private void handleNavigation(javafx.event.ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String buttonId = clickedButton.getId();

        NavigationHelperAdmin.navigate(contentPane, buttonId);
    }

    @FXML
    private void initialize() {
        NavigationHelperAdmin.navigate(contentPane, "homeBtn");
    }
}
