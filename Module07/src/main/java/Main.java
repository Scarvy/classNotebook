import java.util.List;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Book book = new Book("The Hobbit", "J.R.R. Tolkien", 1937, "978-0618002214", "Fantasy");
        Book book2 = new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 1954,
                "978-0618002214b", "Fantasy");
        List<Book> books = List.of(book, book2);

        Map<String, Book.BookRecord> bookMap =
                books.stream().collect(Collectors.toMap(Book::getBookIdentifier, Book::toRecord));

        System.out.println(bookMap);


        OutputStream os = System.out;

        if (args.length > 0) {
            try {
                os = new FileOutputStream("data/core_written2.xml");
            } catch (Exception e) {
                System.out.println("Error opening file");
            }
        }
        DataFormatter.write(books, Formats.XML, os);

    }
}
