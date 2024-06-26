import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<String> fruits = new ArrayList<>();

        fruits.add("ApPlE");
        fruits.add("BaNaNa");
        fruits.add("OrAnGe");
        fruits.add("WaTeRmElOn");
        fruits.add("PeAr");
        fruits.add("GrApE");

        System.out.println("Original list: " + fruits);

        // create a stream
        Stream<String> fruitsStream = fruits.stream();

        List<String> lowercaseFruits = fruitsStream.map(f -> f.toLowerCase())
                .collect(Collectors.toList());

        System.out.println("Transformed fruits: " + lowercaseFruits);

        Stream<String> shortFruits = lowercaseFruits.stream();

        List<String> shortFruitResults = shortFruits
                .filter(f -> f.length() < 6)
                .toList();

        System.out.println("Short fruits: " + shortFruitResults);

        List<String> noVowelFruits = lowercaseFruits.stream()
                .map(f -> f.replaceAll("[aeiou]", ""))
                .toList();

        System.out.println("No vowel fruits: " + noVowelFruits);

        List<Integer> fruitConsonants = noVowelFruits.stream()
                .map(f -> f.length())
                .toList();

        System.out.println("Consonant count: " + fruitConsonants);

        List<String> fruitsWithA = lowercaseFruits.stream()
                .filter(f -> f.startsWith("a"))
                .toList();

        System.out.println("Fruits that start with an a: " + fruitsWithA);

        List<String> firstThree = lowercaseFruits.stream()
                .limit(3)
                .toList();

        System.out.println("First three fruits: " + firstThree);

    }
}