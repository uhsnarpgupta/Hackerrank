package java8;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class LambdaCollections {
    public static void main(String[] args) {
        List<String> names = asList("Paul", "Jane", "Michael", "Sam");

        // way to sort prior to java8
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        // first iteration with lambda
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        //now remove the data types and allow the compiler to infer the type
        Collections.sort(names, (a, b) -> b.compareTo(a));

        Book book1 = new Book("Miss Peregrine's home for peculiar children", "Ranson", "Riggs", 382);
        Book book2 = new Book("Harry Potter", "JK", "Rowling", 411);
        Book book3 = new Book("The Cat in the hat", "Dr", "Seuss", 45);

        //use .collect to aggregate values
        List<Book> books = asList(book1, book2, book3);
        int total = books.stream().collect(Collectors.summingInt(Book::getPages));
        System.out.println(total);

        //use .collect to aggregate author's first names into a list
        //and .map to get the last name of the author
        List<String> list = books.stream().map(Book::getAuthorLName).collect(Collectors.toList());
        System.out.println(list);

        //create a list with duplicates
        List<Book> dupBooks = asList(book1, book2, book3, book1, book2);
        System.out.println("Before removing duplicates: ");
        System.out.println(dupBooks.toString());

        //remove duplicates using a set
        Collection<Book> noDups = new HashSet<>(dupBooks);
        System.out.println("After removing duplicates: ");
        System.out.println(noDups.toString());

        //example of using Set to eliminate dups and sort automatically
        Set<Integer> numbers = new HashSet<>(asList(4, 3, 3, 3, 2, 1, 1, 1));
        System.out.println(numbers.toString());
    }
}

class Book {
    private String title;
    private String authorFName;
    private String authorLName;
    private int pages;

    public Book(String title, String authorFName, String authorLName, int pages) {
        this.title = title;
        this.authorFName = authorFName;
        this.authorLName = authorLName;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorFName() {
        return authorFName;
    }

    public void setAuthorFName(String authorFName) {
        this.authorFName = authorFName;
    }

    public String getAuthorLName() {
        return authorLName;
    }

    public void setAuthorLName(String authorLName) {
        this.authorLName = authorLName;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return title + "Written By: " +
                authorFName + " " +
                authorLName;
    }
}
