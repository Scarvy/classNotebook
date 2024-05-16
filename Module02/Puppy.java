package Module02;

import java.util.ArrayList;
import java.util.List;


public class Puppy {

    public static final String DEFAULT_BREED = "Unknown";

    String breed;
    String name;
    int ageInMonths;

    static int counter = 0;

    public Puppy(String name, int ageInMonths) {
        this(DEFAULT_BREED, name, ageInMonths);
    }

    public Puppy(String breed, String name, int ageInMonths) {
        this.breed = breed;
        this.name = name;
        this.ageInMonths = ageInMonths;
        counter++;
    }

    public static boolean comparePuppies(Puppy pup1, Puppy pup2) {
        return pup1.ageInMonths > pup2.ageInMonths;
    }

    public static void main(String[] args) {
        Puppy puppy1 = new Puppy("Golden Retriever", "Buddy", 3);
        Puppy puppy2 = new Puppy("Poodle", "Max", 2);
        Puppy puppy3 = new Puppy("Labrador", "Daisy", 1);

        System.out.println(Puppy.comparePuppies(puppy1, puppy2));

        System.out.println("Unknown".equals(Puppy.DEFAULT_BREED));

        int x = Integer.parseInt("123");
        System.out.println(x * 10);

        List<Double> numbers = new ArrayList<>();
        numbers.add(1.0);
        numbers.add(2.2);
        numbers.add(3.34);
        for (Double i : numbers) {
            System.out.println(i.intValue());
        }

        System.out.println("Number of puppies: " + Puppy.counter);
        System.out.println("Number of puppies: " + Puppy.counter);

    }

}
