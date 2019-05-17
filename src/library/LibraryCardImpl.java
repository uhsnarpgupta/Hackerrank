package library;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import static java.time.temporal.ChronoUnit.DAYS;

public class LibraryCardImpl extends LibraryCard {
    public void issueBook(Book book, Date issueDate) {
        bookMap.put(book, issueDate);
        books.add(book);
    }

    public Set<Book> getIssuedBooks() {
        return books;
    }

    public boolean returnBook(Book book) {
        Date issueDate = bookMap.get(book);
        if (bookMap.containsKey(book)) {
            bookMap.remove(book);
            return true;
        }
        return false;
    }

    public long getFine() {
        long fine = 0;

        for (Map.Entry<Book, Date> entry : bookMap.entrySet()) {
            Instant instant = entry.getValue().toInstant();
            ZoneId defaultZoneId = ZoneId.systemDefault();

            LocalDate issueDate = instant.atZone(defaultZoneId).toLocalDate();
            long extraDays = calculateExtraDays(issueDate);
            if (extraDays > 7) {
                fine += (extraDays - 7) * 50;
            }
        }
        return fine;
    }

    private long calculateExtraDays(LocalDate issueDate) {
        LocalDate localDate = LocalDate.now();
        return DAYS.between(issueDate, localDate);
    }
}
