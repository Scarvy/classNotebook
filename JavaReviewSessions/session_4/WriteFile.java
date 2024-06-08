import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// Gettysburg Address source: https://www.loc.gov/resource/rbpe.24404500/?st=text

/**
 * Class for working with file input and output in Java.
 */
public class WriteFile {

    public static void main(String[] args){

        // it is good practice to wrap working with files in a try catch block
        try {

            // create the input file
            File inputFile = new File("input.txt");

            // create a new scanner
            Scanner scanner = new Scanner(inputFile);

            // create an output file
            // to write output to a file, construct a PrintWriter object with the desired output file name
            PrintWriter outputFile = new PrintWriter(new File("output.txt"));

            // read the file
            while (scanner.hasNextLine()) {

                // get a line of the file
                String line = scanner.nextLine();

                line = line.toUpperCase();

                // print each line of the file
                outputFile.println(line);

            }

            // make sure to close a file when you are done processing it
            scanner.close();
            outputFile.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
            //e.printStackTrace();
            //System.err.println("File not found: " + e.getMessage());
        }

    }

}
