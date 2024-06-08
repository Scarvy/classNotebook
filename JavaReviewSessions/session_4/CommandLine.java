public class CommandLine {

    public static void main(String[] args) {

        //System.out.println("Hi");

        // create an enhanced for loop to iterate through each of the elements that we pass through in our args array
        for (String arg : args) {

            // print out each string we pass in to the args array
            System.out.println(arg);
        }

        System.out.println(args[2]);
    }
}
