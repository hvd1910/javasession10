package session09;

import java.util.List;

class BookDaoImpl implements Book.BookDao {
    java.util.List<Book> bookList;
    public BookDaoImpl(){
        bookList = new java.util.ArrayList<Book>();
        Book bookObj1 = new Book("Anna",1);
            Book bookObj2 = new Book("John", 2);
            bookList.add(bookObj2);
            bookList.add(bookObj2);
    }
    @Override
    public void deleteBook(Book book){
        bookList.remove(book.getBookID());
        System.out.println("Book: Book Id " + book.getBookID() + ", deleted from database");
    }

    @Override
    public java.util.List<Book> getAllBooks(){
        return bookList;
    }

    @Override
    public List<Book> gerAllBooks() {
        return null;
    }

    @Override
    public Book getBook(int BookID){
        return bookList.get(BookID);
    }

    @Override
    public void updateBook(Book book){
        bookList.get(book.getBookID()).setName(book.getName());
        System.out.println("Book: Book ID " + book.getBookID() + ", updated in the database");

    }
}
