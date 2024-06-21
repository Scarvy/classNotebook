import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    String title;
    String author;
    int year;
    String bookIdentifier;
    String genre;

    public Book() {
        // default constructor
    }

    public Book(String title, String author, int year, String identifier, String genre) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.bookIdentifier = identifier;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBookIdentifier() {
        return bookIdentifier;
    }

    public void setBookIdentifier(String isbn) {
        this.bookIdentifier = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book[title=" + title + ", author=" + author + ", year=" + year + ", bookIdentifier="
                + bookIdentifier + ", genre=" + genre + "]";
    }


    public BookRecord toRecord() {
        return new BookRecord(title, author, year, bookIdentifier, genre);
    }

    public static Book fromRecord(Book record) {
        return new Book(record.getTitle(), record.getAuthor(), record.getYear(),
                record.getBookIdentifier(), record.getGenre());
    }

    public static record BookRecord(String title, String author, int year, String bookIdentifier,
            String genre) {
    }


}
