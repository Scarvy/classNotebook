package Module06;

import java.util.Comparator;

public class BookSortStrategy {

    public static enum SortTypes {
        NAME, PAGES;
    }

    public static Comparator<Book> getSort(SortTypes sortType) {
        return getSort(sortType, true);
    }

    public static Comparator<Book> getSort(SortTypes sortType, boolean direction) {
        switch (sortType) {
            case NAME:
                return direction ? new NameAscending() : new NameDescending();
            case PAGES:
                return direction ? new PagesAscending() : new PagesDescending();


        }
        return null;
    }

    public static class NameAscending implements Comparator<Book> {

        @Override
        public int compare(Book o1, Book o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
    }

    public static class NameDescending implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            return o2.getName().compareToIgnoreCase(o1.getName());
        }
    }

    public static class PagesAscending implements Comparator<Book> {

        @Override
        public int compare(Book o1, Book o2) {
            return o1.getPages() - o2.getPages();
        }
    }


    public static class PagesDescending implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            return o2.getPages() - o1.getPages();
        }
    }
}
