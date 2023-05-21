package library;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.Comparable;
public abstract class SortedLibrary {
    public static List<Books> AlphabetSorted(List<Books> books){
        return books.stream().
                sorted(new BooksComparator()).
                collect(Collectors.toList());

    }
}
class BooksComparator implements Comparator<Books>{
    @Override
    public int compare(Books o1, Books o2) {
        return o1.getName().compareTo(o2.getName());
    }
}