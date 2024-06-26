import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CreatingStreams {

    public static void main(String[] args) {

        // to create a stream you can use the static Stream.of() method

        // create a stream of Strings
        Stream<String> words = Stream.of("Mary", "had", "a", "little", "lamb");

        // create a stream of Integers
        Stream<Integer> digits = Stream.of(1, 3, 42, 1, 7, 2, 9);

        // Note: stream is a generic type just like the Collections


        // -------------------------------------------------------------------------------------


        // we can also use the .stream() method to get a stream for the elements in a collection
        List<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Watermelon");
        fruits.add("Pear");
        fruits.add("Grape");

        Stream<String> fruitStream = fruits.stream();


        // -------------------------------------------------------------------------------------

        // Note: streams do not actually store the elements themselves. It just operates on a source such
        // as a collection, array, or generator function and then processes the elements from that source
        // on demand

        // you can create a stream from a data source. It defines a pipeline of operations (such as map,
        // filter, or forEach) that will be applied to the elements as they pass through the stream


        // -------------------------------------------------------------------------------------


        // relationship between streams and loops

        // say we wanted to get a list of all the fruits with less than 6 characters

        // using a loop
        long count = 0;

        for (String fruit : fruits) {

            if (fruit.length() < 6) {

                count++;
            }

        }

        System.out.println("There are " + count + " fruits with less than 6 characters");


        // -------------------------------------------------------------------------------------


        // using a stream

        // using a stream you can use the .filter() method to pick out the words that you want
        // and then use the count method to count them

        // use the filter method to selectively include elements based on a condition
        long numFruits = fruitStream.filter(f -> f.length() < 6).count();

        System.out.println("There are " + numFruits + " fruits with less than 6 characters");


    }

}

