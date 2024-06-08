import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Gettysburg Address source: https://www.loc.gov/resource/rbpe.24404500/?st=text

/**
 * Class for working with file input and output in Java.
 */
public class ReadFile {

    public static void main(String[] args){

        // it is good practice to wrap working with files in a try catch block
        try {

            // input file
            File inputFile = new File("input.txt");

            // create a new scanner
            Scanner scanner = new Scanner(inputFile);

            // read the file
            while (scanner.hasNextLine()) {

                // get a line of the file
                String line = scanner.nextLine();

                // print each line of the file
                System.out.println(line);
            }

            // make sure to close a file when you are done processing it
            // why? this ensures that all data written to the file is properly saved (data might temporarily be
            // stored in a buffer and closing the file flushes this buffer), allocate resources to the file and want
            // to free those back up, concurrency releasing locks
            scanner.close();

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
            //e.printStackTrace();
            //System.err.println("File not found: " + e.getMessage());
        }

        //PrintWriter out = new PrintWriter("input.txt");
    }

}
