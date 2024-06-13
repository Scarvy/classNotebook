package Module06;

import Module06.BookSortStrategy.SortTypes;
import java.util.List;
import java.util.stream.Stream;

public class BookFilter {

    public static Stream<Book> filter(List<Book> books, String filter, SortTypes sortType) {
        // name==x
        // name~=x
        // more than one with commas
        String[] filters = filter.split(",");
        for (String filterStr : filters) {
            books = filterSingle(books, filterStr, sortType).toList();
        }

        return BookSorter.sortBooks(books, sortType.toString(), false).stream();
    }

    public static Stream<Book> filterSingle(List<Book> books, String filter, SortTypes sortType) {
        // column operator value
        Operations op = Operations.getOperatorFromStr(filter);

        String[] parts = filter.split(op.getOperator());

        // to get column in assignment - i already gave that to you. GameData
        SortTypes type = SortTypes.valueOf(parts[0]); // not super safe but works


        Stream<Book> stream = books.stream().filter(/* function that returns boolean */
                book -> {
                    return Filters.getFilter(book, type, op, parts[1]);
                });


        return stream;
    }


    public static void main(String[] args) {
        List<Book> books = List.of(

                new Book("Stranger In a Strangeland", 400), new Book("Mistborn", 350),
                new Book("Head First Java", 400), new Book("The art of java drinking", 100)

        );

        System.out.println(books);

        List<Book> filtered = filter(books, "NAME~=Java", SortTypes.NAME).toList();
        System.out.println(filtered);

    }

}
