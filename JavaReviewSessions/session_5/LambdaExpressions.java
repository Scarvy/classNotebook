import java.util.ArrayList;
import java.util.List;

public class LambdaExpressions {

    public static void main(String[] args) {

        // create a new arraylist of animals
        List<String> animals = new ArrayList<>();

        animals.add("lion");
        animals.add("lemur");
        animals.add("leopard");
        animals.add("elephant");
        animals.add("tiger");
        animals.add("gazelle");
        animals.add("giraffe");
        animals.add("zebra");
        animals.add("monkey");

        System.out.println(animals);


        // -------------------------------------------------------------------------------------


        // get only the animals that have a name starting with the letter L
        List<String> animalStartingWithL = animals.stream()
                .filter(a -> a.startsWith("l"))
                .toList();

        System.out.println(animalStartingWithL);


        // -------------------------------------------------------------------------------------


        // animal names but transformed to be all upper case
        List<String> uppercaseAnimals = animals.stream()
                .map( a -> a.toUpperCase())
                .toList();

        System.out.println(uppercaseAnimals);


        // -------------------------------------------------------------------------------------

        // method references - are shorthand for lambda expressions
        // method references docs: https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html

        // when a lambda expression consists of just one method call, you can use a very concise syntax

        // a class method followed by :: and a method name is equivalent to a lambda expression with
        // parameters located in their correct places

        List<String> smallerAnimals = animals.stream()
                .filter(a -> a.startsWith("g") || a.startsWith("l")).toList();

        System.out.println(smallerAnimals);

        List<String> methodRef = smallerAnimals.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println(methodRef);

        // when you use a method references, the compiler infers the target (the parameters) based on the
        // context in which the method is used


    }
}
