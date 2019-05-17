package library;

public class BookBuilder implements Builder{
    private String name;
    private String ISBN;
    private int noOfPages;

    public BookBuilder() {
    }

    public Book build() {
        return new Book(name,ISBN,noOfPages);
    }

    @Override
    public BookBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public BookBuilder setISBN(String ISBN) {
        this.ISBN = ISBN;
        return this;
    }

    @Override
    public BookBuilder setNoOfPages(int pages) {
        this.noOfPages = pages;
        return this;
    }
}
