package Module06;

import java.util.List;

public class BookSorter {

    public static List<Book> sortBooks(List<Book> books, String sortType) {
        return sortBooks(books, sortType, true);
    }

    public static List<Book> sortBooks(List<Book> books, String sortType, boolean direction) {
        BookSortStrategy.SortTypes type = BookSortStrategy.SortTypes.valueOf(sortType);

        List<Book> sorted =
                books.stream().sorted(BookSortStrategy.getSort(type, direction)).toList();

        return sorted;
    }


    public static void main(String[] args) {
        List<Book> books = List.of(

                new Book("Stanger In a Strangeland", 400), new Book("Mistborn", 350),
                new Book("Head First Java", 400)

        );

        System.out.println(books);

        List<Book> sorted = sortBooks(books, "NAME");
        System.out.println(sorted);

        sorted = sortBooks(books, "PAGES", false);
        System.out.println(sorted);
    }

}
