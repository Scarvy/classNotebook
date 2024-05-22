import java.util.ArrayList;
import java.util.Arrays;

// class for showing the basics of Arrays and ArrayLists in Java
// some examples adapted from Cay Horstmann
public class HelloWorld2 {

    public static void main(String[] args) {

        // Arrays

        // declare and initialize an array variable
        // values is initialized with an array of 10 numbers (by default each is 0)
        double[] values = new double[10];

        // check to see the values in the array
        for (int i = 0; i < values.length; i++) {

            System.out.println(values[i]);
        }

        System.out.println("---------------------");

        // to access a value at a particular slot in the array you use the [] operator
        values[4] = 35;

        // print out each of the values in the array
        for (int i = 0; i < values.length; i++) {

            System.out.println(values[i]);
        }

        System.out.println("---------------------");

        // Note that index starts at zero!

        for (int i = 0; i < 10; i++) {
            values[i] = i;
            System.out.println(values[i]);
        }

        System.out.println("---------------------");

        // using an initializer list
        int[] int_array = {1, 2, 3, 4, 5};
        String[] string_array = {"ab", "cd", "ef"};
        boolean[] bool_array = {true, false, true};
        char[] char_array = {'a', 'b', 'c'};

        System.out.println(Arrays.toString(string_array));

        for (int i = 0; i < int_array.length; i++) {

            System.out.println(int_array[i]);
        }

        System.out.println("---------------------");

        // --------------------------------------
        // Enhanced for loop

        // enhanced for loops (for each loop)
        // say that we would like to get the total of all the elements in our int array
        int total = 0;

        for (int element : int_array) {
            total += element;
        }

        System.out.println("The total is:");
        System.out.println(total);

        System.out.println("---------------------");

        // --------------------------------------
        // References

        System.out.println("Copying arrays:");
        System.out.println("---------------------");

        // create a new int array
        int[] original_array = {0, 2, 4, 6, 8, 10};

        // bad copy (just copying the references)
        int[] bad_copy = original_array;

        // let's modify the original array
        original_array[0] = 100;

        // show the original array
        System.out.println("Original array:");
        System.out.println(Arrays.toString(original_array));

        System.out.println("hash: " + original_array);
        System.out.println();

        // show the copy of the array
        System.out.println("Bad copy array:");
        System.out.println(Arrays.toString(original_array));

        System.out.println("hash: " + bad_copy);

        System.out.println();
        System.out.println("---------------------");


        // do the copy correctly

        // create a new int array
        int[] original_array_2 = {0, 2, 4, 6, 8, 10};

        int[] actual_copy = Arrays.copyOf(original_array_2, original_array_2.length);

        original_array_2[0] = 100;

        // show the original array
        System.out.println("Original array:");
        System.out.println(Arrays.toString(original_array_2));

        System.out.println("hash: " + original_array_2);
        System.out.println();

        // show the copy of the array
        System.out.println("Actual copy array:");
        System.out.println(Arrays.toString(actual_copy));

        System.out.println("hash: " + actual_copy);

        System.out.println();
        System.out.println("---------------------");


        // --------------------------------------
        // ArrayLists

        // declare a new array list
        // Note the () after thee ArrayList<> - we are calling a constructor of the arraylist<String> class here
        ArrayList<String> string_list = new ArrayList<>();

        // add some elements to the array list
        string_list.add("Ethan");
        string_list.add("Bob");
        string_list.add("Jack");

        // create a copy of the reference to the array list
        ArrayList<String> bad_copy_list = string_list;

        // remove an element from the array list
        string_list.remove(1);

        // print out both of the array lists
        System.out.println(string_list);
        System.out.println(bad_copy_list);

        System.out.println();
        System.out.println("---------------------");

        // create a new array list
        ArrayList<String> string_list_2 = new ArrayList<String>();

        // add some elements to the array list
        string_list_2.add("Ethan");
        string_list_2.add("Bob");
        string_list_2.add("Jack");

        // the angle brackets <> tell you that the String is a type parameter

        // copying ArrayLists - the variables also hold references just like regular arrays
        // if you want to make a copy of an ArrayList, construct the copy and pass in the original list into
        // the constructor
        ArrayList<String> newCopy = new ArrayList<>(string_list_2);

        // remove an element from the array list
        string_list_2.remove(1);

        // print out both of the array lists
        System.out.println("Original array list: " + string_list_2);
        System.out.println("Copy of the array list: " + newCopy);

        // we can also get values from the array list
        System.out.println();
        String name = newCopy.get(2);
        System.out.println("Getting a single name: " + name);

        // replace an element in the array list
        System.out.println();
        newCopy.set(0, "James");
        System.out.println("Updated array list: " + newCopy);


        // --------------------------------------

        // autoboxing
        Double wrapper = 29.29;
        double x = wrapper;

    }

}
