public class FormatFlags {

    public static void main(String[] args) {

        // % indicates that a format specifier follows

        // System.out.printf() is a convenient way to format and display text

        // format types
        // ------------
        // d - decimal
        // f - fixed floating point
        // e - exponential floating point
        // g - general floating point (exponential is used for very large or small values)
        // s - string

        // Format flags
        // ------------
        // -  left alignment
        // 0  show leading zeros (followed by amount of decimal places)
        // +  show a plus sign for positive numbers
        // (  enclose negative numbers in parentheses
        // ,  show decimal separators
        // ^  convert letters to uppercase

        // left alignment flag -
        String text = "hello";

        // % (use of a format flag)
        // - (left justify)
        // 10 (minimum width/number of characters to be printed)
        // s (the argument string)
        System.out.printf("%-10s", text);
        System.out.print("next word\n");
        System.out.printf(String.format("%-10s", text));

        // show leading zeros 0
        int number = 123;

        // % (use of a format flag)
        // 0 (pad the output with zeros)
        // 5 (the output should take up this many characters)
        // d (the argument is an integer)
        System.out.printf("%05d\n", number);

        // show a plus sign for positive numbers
        int positiveNumber = 100; // 100.50
        int negativeNumber = -50; // -50.75

        // % (use of a format flag)
        // + (show a plus/negative sign)
        // d (the argument is an integer)
        System.out.printf("%+d\n", positiveNumber); // %+.2f
        System.out.printf("%+d\n", negativeNumber); // %+.2f

        // enclosing a negative number in parentheses
        int loss = -250;
        System.out.printf("%+(d\n", loss);

        // show decimal separators
        int largeNumber = 1234567;
        System.out.printf("%,d\n", largeNumber);

        // representing floating point numbers in scientific notation
        double eTypeNum = 12345.6789;
        System.out.printf("%e\n", eTypeNum);

    }
}
