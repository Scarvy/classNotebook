package Module06;

import Module06.BookSortStrategy.SortTypes;

public class Filters {

    public static boolean getFilter(Book book, SortTypes type, Operations op, String val) {
        switch (type) {
            case NAME:
                return filterString(book.getName(), op, val);

            case PAGES:
                return filterNumber(book.getPages(), op, val);

            default:
                break;
        }
        return false;
    }


    private static boolean filterString(String name, Operations op, String value) {
        switch (op) {
            case EQUALS:
                return name.equalsIgnoreCase(value);
            case CONTAINS:
                name = name.toLowerCase();
                value = value.toLowerCase();
                return name.contains(value);
            default:
                return false;
        }

    }

    private static boolean filterNumber(int number, Operations op, String value) {
        return false;
    }

}
