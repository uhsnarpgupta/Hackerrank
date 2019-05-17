package library;

import java.util.Objects;

public class Book {
    private String name;
    private String ISBN;
    private int noOfPages;

    public Book(String name, String iSBN, int pages) {
        this.name = name;
        this.ISBN = iSBN;
        this.noOfPages = pages;
    }


    public String getName() {
        return name;
    }

    public String getISBN() {
        return ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(ISBN, book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN);
    }
}
