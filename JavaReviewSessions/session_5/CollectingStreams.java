import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingStreams {

    public static void main(String[] args) {

        // collection -> stream -> collection

        // we can do this by collecting the results
        // Collectors docs: https://docs.oracle.com/javase%2F8%2Fdocs%2Fapi%2F%2F/java/util/stream/Collectors.html

        // create a new arraylist of animals
        List<String> animals = new ArrayList<>();

        animals.add("lion");
        animals.add("elephant");
        animals.add("tiger");
        animals.add("giraffe");
        animals.add("zebra");
        animals.add("monkey");

        System.out.println(animals);


        // -------------------------------------------------------------------------------------


        // change the arraylist into a stream
        Stream<String> animalStream = animals.stream();

        // change the stream back into a collection
        List<String> animalList = animalStream.collect(Collectors.toList());

        // the collect() method is a terminal operation used to transform the elements of a stream into
        // a different form. The collect() method takes in a Collector as a parameter

        // a collector is an object that is responsible for placing stream values into a result object
        // (accumulates from a stream into a result container)

        System.out.println("Collected results: " + animalList);

        // when using a collector, you are basically telling the stream how to accumulate its elements into a result
        // using Collectors.toList() you are telling it to collect them into a List
        // using Collectors.joining() you are telling the stream to concatenate all the elements into a single String


        // -------------------------------------------------------------------------------------


        // Note: don't use a terminated stream!

        // once you obtain a result from a stream (by calling a terminal operation: collect, forEach, or reduce)
        // the stream is "used up" and you can no longer apply operations to it
        // (it has been consumed and cannot be used again)

        // a terminal operation forces the execution of pending lazy operations and yields a value that is not
        // a stream


        // -------------------------------------------------------------------------------------


        //animalStream.collect(Collectors.joining());

        Stream<String> animalStream2 = animals.stream();

        String largeString = animalStream2.collect(Collectors.joining(","));

        System.out.println(largeString);


    }

}
