import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Grouping {

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 30)
        );

        Map<Integer, List<Person>> peopleByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        System.out.println(peopleByAge);


        // -------------------------------------------------------------------------------------


        // an example of a primitive int stream
        IntStream stream = IntStream.of(1, 2, 3, 4, 5);

        int sum = stream.sum();

        System.out.println(sum);


        // create a new stream
        IntStream stream2 = IntStream.of(1, 2, 3, 4, 5);

        OptionalInt max = stream2.max();

        System.out.println(max);


        // create a new random generator
        Random random = new Random();

        // we can use the generate() method to create an infinite stream
        // lambda equivalent () -> random.nextInt() (supplier provides values to generate without needing an input)
        IntStream randomIntStream = IntStream.generate(random::nextInt);

        // limit the stream to the first 10 integers generated
        // lambda equivalent (x) -> System.out.println(x)
        randomIntStream.limit(10).forEach(System.out::println);


    }

}
