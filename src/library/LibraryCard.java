package library;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.Set;


public abstract class LibraryCard {
    Set<Book> books;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    Map<Book, Date> bookMap;

    public abstract void issueBook(Book book, Date issueDate);

    public abstract Set<Book> getIssuedBooks();

    public abstract boolean returnBook(Book book);

    public abstract long getFine();
}
