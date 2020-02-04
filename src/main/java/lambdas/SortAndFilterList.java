package lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.reverseOrder;

public class SortAndFilterList {

    public static void main(String[] args) {
        sortAndFilterList();
    }

    private static void sortAndFilterList() {
        List<String> animals = Arrays.asList("lion", "bear", "dear", "Dog", "Cat", "mouse", "cougar", "elephant", "giraffe", "lemur", "Bison", "chimpanzee", "hyena", "cheetah");

        animals.sort(Comparator.comparingInt(String::length));
        System.out.println(animals);
        animals.sort(reverseOrder());
        animals.sort(String::compareToIgnoreCase);
        System.out.println(animals);

        animals.sort(Comparator.comparing(s-> !s.contains("e")));
        System.out.println(animals);

        // TODO use lambda and functional interfaces / method references to sort by
        // 1. length
        // 2. reverse length
        // 3. alphabetically
        // 4. put the strings that contain 'e' first in the list. The other ones last.
        // 5. filter only the strings that have the first letter capitalized
    }
}
