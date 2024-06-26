import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LazyEvaluation {

    public static void main(String[] args) {

        // streams in Java are lazily evaluated - which means that the elements of a stream are not computed
        // until they are actually needed (in an eager evaluation paradigm, they would be computed immediately)

        // when you create a stream and apply intermediate operations (filter/map) these don't actually perform
        // any processing on the stream elements - they just set up a pipeline of operations to be applied to
        // the elements once a terminal operation is called (forEach, collect, reduce)


        // -------------------------------------------------------------------------------------


        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        // create a stream
        fruits.stream()
                .filter(f -> {
                    System.out.println("Filtering: " + f);
                    return f.startsWith("a");
                })
                .map(f -> {
                    System.out.println("Mapping: " + f);
                    return f.toUpperCase();
                });

        System.out.println("Stream pipeline was created but not executed yet");


    }

    // we use return statements when we want to explicitly return a value from a lambda expression
    // this allows us to have more complex lambda expression logic with longer bodies

    /*

     some advantages of lazy evaluation are:

     1. Efficiency - operations can be deferred until they are actually needed (maybe only a portion of the stream
                     will be needed)

     2. Short-circuiting - terminal operations like findFirst() mean that once a result is found further processing
                           is stopped (the stream stops processing elements as soon as the conditions are met)

     */


}
