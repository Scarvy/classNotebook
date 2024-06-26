import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TransformingStreams {

    public static void main(String[] args) {

        // say we want to actually perform some operations on the elements from a stream


        // create a new arraylist of Strings
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


        // -------------------------------------------------------------------------------------


        // the map() method applies a function to each element of a stream and returns a new stream containing
        // the results of applying the function to each element

        // lambda expressions take in a parameter variable(s) arrow -> and an expression yielding a result

        //fruitsStream.map(f -> f.toUpperCase());

        List<String> lowercaseFruits = fruitsStream.map(f -> f.toLowerCase())
                .collect(Collectors.toList());

        System.out.println("Transformed fruits: " + lowercaseFruits);


        // -------------------------------------------------------------------------------------


        // the filter method yields a stream of all the elements fulfilling a condition
        // it takes in a function with a boolean results (a predicate) and returns the elements where
        // the expression evaluates to true

        // get a list of all the fruits that have less than 6 characters

        Stream<String> shortFruits = lowercaseFruits.stream();

        List<String> shortFruitResults = shortFruits
                .filter(f -> f.length() < 6)
                .toList();

        System.out.println("Short fruits: " + shortFruitResults);

        // map and filter are sometimes called higher-order functions because they are functions that
        // consume other functions


        // -------------------------------------------------------------------------------------


        // remove all the vowels from the lower case fruits

        List<String> noVowelFruits = lowercaseFruits.stream()
                .map(f -> f.replaceAll("[aeiou]", ""))
                .toList();

        System.out.println("No vowel fruits: " + noVowelFruits);


        // -------------------------------------------------------------------------------------


        // count how many consonants are in each lower case fruit
        List<Integer> fruitConsonants = noVowelFruits.stream()
                .map(f -> f.length())
                .toList();

        System.out.println("Consonant count: " + fruitConsonants);


        // -------------------------------------------------------------------------------------


        // just get the fruits that start with the letter a
        List<String> fruitsWithA = lowercaseFruits.stream()
                .filter(f -> f.startsWith("a"))
                .toList();

        System.out.println("Fruits that start with an a: " + fruitsWithA);


        // -------------------------------------------------------------------------------------


        // other helpful stream transformation methods (limit, skip, distinct, sorted)


        // just show the first n elements of the original stream

        List<String> firstThree = lowercaseFruits.stream()
                .limit(3)
                .toList();

        System.out.println("First three fruits: " + firstThree);


        // skip the first two elements in the stream

        List<String> skipFirstTwo = lowercaseFruits.stream()
                .skip(2)
                .toList();

        System.out.println("Skip first two fruits: " + skipFirstTwo);


        // get only the distinct elements from a stream

        List<String> duplicateFruits = new ArrayList<>();
        duplicateFruits.add("apple");
        duplicateFruits.add("orange");
        duplicateFruits.add("apple");
        duplicateFruits.add("apple");
        duplicateFruits.add("orange");
        duplicateFruits.add("pear");

        List<String> noDupesFruits = duplicateFruits.stream()
                .distinct()
                .toList();

        System.out.println("No duplicate fruits: " + noDupesFruits);


        // sort the elements in a stream

        List<String> sortedFruits = lowercaseFruits.stream()
                .sorted()
                .toList();

        System.out.println("Sorted fruits: " + sortedFruits);


    }
}
