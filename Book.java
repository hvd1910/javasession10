package session09;

public class Book {
    private String name;
    private int BookID;

    public Book(String name, int bookID) {
        this.name = name;
        BookID = bookID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBookID() {
        return BookID;
    }

    public void setBookID(int bookID) {
        BookID = bookID;
    }

    interface BookDao{
        java.util.List<Book> getAllBooks();

        public java.util.List<Book> gerAllBooks();
        public Book getBook(int BookID);
        public void updateBook(Book book);
        public void deleteBook(Book book);
    }

}
