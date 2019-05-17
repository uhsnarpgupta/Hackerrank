package library;

import java.util.List;
import java.util.Optional;

public class Librarian extends Person {


    public Librarian(String name) {
        super(name);
    }

    public void addMember(String memberName, Library library) {
        Optional<Member> userOptional = getMember(memberName, library);
        if (userOptional.isPresent()) {
            System.out.println(memberName + " is already a member");
        } else {
            library.memberInventory.putItem(new Member(memberName));
        }
    }

    public void removeMember(String memberName, Library library) {
        Optional<Member> userOptional = getMember(memberName, library);
        if (!userOptional.isPresent()) {
            System.out.println(memberName + " is not a member");
        } else {
            library.memberInventory.removeItem(userOptional.get());
        }
    }

    private Optional<Member> getMember(String memberName, Library library) {
        List<Member> memberList = library.memberInventory.getItems();
        return memberList.stream()
                .filter(member -> member.getName().equalsIgnoreCase(memberName))
                .findFirst();
    }

    public void addBook(String bookName, String ISBN, Library library) {
        List<Book> bookList = library.bookInventory.getItems();
        Optional<Book> bookOptional = bookList.stream()
                .filter(member -> member.getName().equalsIgnoreCase(bookName))
                .findFirst();
        if (bookOptional.isPresent()) {
            int instances = library.bookInventory.availableInstances(bookOptional.get());
            if (instances > 7) {
                System.out.println("Book instance total: " + instances + "Cannot accomodate more than 7 instances " +
                        "of book " + bookName);
            } else {
                library.bookInventory.putItem(bookOptional.get());
            }
        } else {
            library.bookInventory.putItem(new Book(bookName, ISBN));
        }
    }

    public void removeBookInstance(String bookName, Library library) {
        List<Book> bookList = library.bookInventory.getItems();
        Optional<Book> bookOptional = bookList.stream()
                .filter(member -> member.getName().equalsIgnoreCase(bookName))
                .findFirst();
        if (bookOptional.isPresent()) {
            int instances = library.bookInventory.availableInstances(bookOptional.get());
            if (instances < 1) {
                System.out.println("Book has " + instances + "instances of book " + bookName);
            } else {
                library.bookInventory.removeItem(bookOptional.get());
            }
        }
    }

}
