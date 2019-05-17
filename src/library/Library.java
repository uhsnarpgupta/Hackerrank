package library;

import java.util.Optional;

public class Library {

    Inventory<Book> bookInventory;
    Inventory<Member> memberInventory;

    public Library() {
        initialize();
    }

    private void initialize() {
        //initialize machine with 5 coins of each denomination and 5 cans of each Item
        new BookBuilder().setName("").setISBN("").build();
        bookInventory.putItem(new Book("English", "1"));
        bookInventory.putItem(new Book("Hindi", "2"));
        bookInventory.putItem(new Book("Maths", "3"));
        bookInventory.putItem(new Book("Physics", "4"));
        bookInventory.putItem(new Book("Geography", "5"));

        memberInventory.putItem(new Member("Ram"));
        memberInventory.putItem(new Member("Pyaare"));
        memberInventory.putItem(new Member("Shyam"));
        memberInventory.putItem(new Member("Ravi"));
        memberInventory.putItem(new Member("Abott"));
    }

    public Optional<Book> searchBook(String name) {
        return bookInventory.getItems().stream()
                .filter(book -> book.getName().equalsIgnoreCase(name))
                .findFirst();
    }

}
