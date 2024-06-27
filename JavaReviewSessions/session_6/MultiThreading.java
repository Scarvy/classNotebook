import java.util.stream.IntStream;

/**
 * Class for demonstrating creating a parallel stream.
 */
public class MultiThreading {

    public static void main(String[] args) {

        // when you convert a stream into a parallel stream using .parallel(), the Java runtime attempts to
        // split the work among multiple threads to perform the operations in parallel

        // this can improve performance by utilizing multiple CPU cores

        // see: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ForkJoinPool.html

        // ForkJoinPool manages a pool of worker threads. When a stream is converted to a parallel stream, it is
        // internally split into smaller sub-tasks that can be processed concurrently. ForkJoinPool assigns these
        // sub-tasks to its worker threads

        // ForkJoinPool.commonPool() is a static factory method that creates a pool with a number of threads equal
        // to the number of available processors


        // create an int stream containing integers from 1 to 10
        IntStream.range(1, 20)

                // convert the stream into a parallel stream
                // this allows operations on the stream to be performed in parallel using multiple threads
                .parallel()

                // apply this function to every element in the stream (lambda expression)
                .map(x -> {

                    // print out the thread ID
                    System.out.println("Thread ID: " + Thread.currentThread().getId() + ", processing value: " + x);

                    // square each number
                    return x * x;

                })

                // terminal operation to call the lazily evaluated operations
                .sum();

        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());

    }

}
