package controller.model;

public class Book {
    private final int no;
    private final String title;
    private final String author;
    private final String category;
    private final String isbn;
    private final String status;

    public Book(int no, String title, String author, String category, String isbn, String status) {
        this.no = no;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isbn = isbn;
        this.status = status;
    }

    // Getter
    public int getNo() {
        return no;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getStatus() {
        return status;
    }

    // Kalau mau, bisa tambah setter jika ingin data bisa diubah (tapi kalau cuma baca, ini cukup)
}
