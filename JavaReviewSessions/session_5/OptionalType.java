import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalType {

    public static void main(String[] args) {


        String myString = null;
        //System.out.println(myString.length());


        // create a new arraylist of animals
        List<String> animals = new ArrayList<>();

        animals.add("lion");
        animals.add("lemur");;
        animals.add("elephant");
        animals.add("tiger");
        animals.add("gazelle");
        animals.add("giraffe");
        animals.add("baboon");
        animals.add("monkey");

        System.out.println(animals);

        // the findFirst() method returns an Optional because there may not be a first element to return

        Optional<String> firstAnimal = animals.stream().filter(a -> a.startsWith("z")).findFirst();

        System.out.println(firstAnimal);

        List<String> emptyList = animals.stream()
                .filter(a -> a.startsWith("j"))
                .toList();

        System.out.println(emptyList);


    }
}
