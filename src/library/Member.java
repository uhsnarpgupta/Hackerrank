package library;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Member extends Person {

    private LibraryCard libraryCard;

    public Member(String name) {
        super(name);
        this.libraryCard = new LibraryCardImpl();
    }

    public Member borrowBook(String bookName, Library library) {
        Book book = library.searchBook(bookName).orElseGet(null);
        if (searchBook(book.getName(), library))
            libraryCard.issueBook(book, new Date());
        return this;
    }

    public boolean searchBook(String name, Library library) {
        return library.searchBook(name).isPresent();
    }

    public Member returnBook(Book book, Library library) {
        libraryCard.returnBook(book);
        library.bookInventory.putItem(book);
        return this;
    }

    public List<Book> getIssuedBooks() {
        return new ArrayList<>(libraryCard.getIssuedBooks());
    }


    public long dues() {
        return libraryCard.getFine();
    }

}
