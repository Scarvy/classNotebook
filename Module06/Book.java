package Module06;

import java.util.List;
import java.util.ArrayList;

public class Book {
    private String name;
    private int pages;

    public Book(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return String.format("BOOK{name:%s, pages:%d}", getName(), getPages());
    }



    public static void main(String[] args) {
        List<Book> books = List.of(

                new Book("Stanger In a Strangeland", 400), new Book("Mistborn", 350),
                new Book("Head First Java", 400)

        );

        System.out.println(books);
        List<Book> booksMutable = new ArrayList<>(books);
        booksMutable.add(new Book("Dart", 400));
    }

}
