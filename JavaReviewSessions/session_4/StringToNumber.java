public class StringToNumber {

    public static void main(String[] args) {

        // create a String of a number
        String s = "100";

        // check to see what the type of this object is (verify that it is a String)
        System.out.println(s.getClass());

        // do some arithmetic (we want to add 100 to this number)
        // this does not work! what should we do?
        // s + 100;

        // use the Integer.parseInt() method
        int i = Integer.parseInt(s);

        // complete the arithmetic expression
        int total = i + 100;

        // print out the result to verify that the addition worked
        System.out.println(total);

        // we talked about casting previously - why can we not use that here?
        // these are different types that cannot be directly cast to each other

        // now let's try another example, this time converting from a String to double
        String s2 = "10.25";

        // use the Double.parseDouble() method to convert from a String into a double
        double d = Double.parseDouble(s2);

    }
}
