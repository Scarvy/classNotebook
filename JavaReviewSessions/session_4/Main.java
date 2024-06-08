import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        Pair<String, Integer> nameAge = new Pair<>("Alice", 35);

        Pair<Integer, Integer> twoInts = new Pair<>(2, 1);

        System.out.println(nameAge.getKey());

        //System.out.println(nameAge);
        Triple<String, String, Integer> ourTriple= new Triple<>("Hi", "bye", 10);

        //Pair<String, String> firstLastName = new Pair<>("Bob", "Smith");
        //System.out.println(firstLastName);

        //ArrayList<String> stringList = new ArrayList<>();
        //stringList.add("Bob");
        //stringList.add("Smith");



        // raw use of parameterized list (not recommended for type safety)
        //LinkedList linkedList = new LinkedList();

        // example of where type safety is enforced
        //ArrayList<String> stringList1 = new ArrayList<>();
        //stringList1.add("Bob");
        //stringList1.add(123);

        // example where type safety is not enforced
        //ArrayList<Object> notTypeSafe = new ArrayList<>();
        //notTypeSafe.add("HI");
        //notTypeSafe.add(123);

        //notTypeSafe.get(0).length();
        //String s = (String) notTypeSafe.get(0);
        //String s2 = (String) notTypeSafe.get(1);
        //s.length();


    }
}