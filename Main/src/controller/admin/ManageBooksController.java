package controller.admin;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;
import controller.model.Book;
import controller.model.SharedBookData;  // pastikan import utilnya benar

public class ManageBooksController {

    @FXML private TableView<Book> tableView;
    @FXML private TableColumn<Book, Integer> colNo;
    @FXML private TableColumn<Book, String> colTitle;
    @FXML private TableColumn<Book, String> colAuthor;
    @FXML private TableColumn<Book, String> colCategory;
    @FXML private TableColumn<Book, String> colISBN;
    @FXML private TableColumn<Book, String> colStatus;
    @FXML private TableColumn<Book, Void> colActions;

    @FXML private TextField searchField;
    @FXML private Button btnAddBook;

    private ObservableList<Book> books;

    @FXML
    public void initialize() {
        // Ambil data global dari SharedBookData
        books = SharedBookData.getBooks();

        tableView.getColumns().clear();
        tableView.getColumns().addAll(colNo, colTitle, colAuthor, colCategory, colISBN, colStatus, colActions);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        colNo.setMinWidth(40);
        colNo.setMaxWidth(60);
        colNo.setStyle("-fx-alignment: CENTER;");
        colTitle.setStyle("-fx-alignment: CENTER;");
        colAuthor.setStyle("-fx-alignment: CENTER;");
        colCategory.setStyle("-fx-alignment: CENTER;");
        colISBN.setStyle("-fx-alignment: CENTER;");
        colStatus.setStyle("-fx-alignment: CENTER;");

        colNo.setCellValueFactory(new PropertyValueFactory<>("no"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colISBN.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));

        colActions.setCellFactory(param -> new TableCell<>() {
            private final Button editBtn = new Button("✏️ Edit");
            private final Button deleteBtn = new Button("🗑️ Delete");

            {
                editBtn.setStyle("-fx-background-color: #C3F5D5; -fx-text-fill: black; -fx-background-radius: 8;");
                deleteBtn.setStyle("-fx-background-color: #F5C3C3; -fx-text-fill: black; -fx-background-radius: 8;");

                editBtn.setOnAction(event -> {
                    Book book = getTableView().getItems().get(getIndex());
                    showAlert("Edit Book", "Edit book: " + book.getTitle());
                });

                deleteBtn.setOnAction(event -> {
                    Book book = getTableView().getItems().get(getIndex());
                    books.remove(book);  // otomatis update SharedBookData karena ini referensi yang sama
                    showAlert("Delete Book", "Deleted book: " + book.getTitle());
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    HBox box = new HBox(10, editBtn, deleteBtn);
                    box.setAlignment(Pos.CENTER);
                    setGraphic(box);
                }
            }
        });

        tableView.setItems(books);

        searchField.textProperty().addListener((obs, oldVal, newVal) -> {
            String keyword = newVal.toLowerCase();
            ObservableList<Book> filtered = books.filtered(book ->
                    book.getTitle().toLowerCase().contains(keyword) ||
                            book.getAuthor().toLowerCase().contains(keyword) ||
                            book.getIsbn().toLowerCase().contains(keyword)
            );
            tableView.setItems(filtered);
        });

        btnAddBook.setOnAction(e -> showAlert("Add Book", "Form tambah buku belum diimplementasikan."));
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
