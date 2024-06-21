
import java.io.IOException;
import java.io.PrintStream;
import java.io.OutputStream;
import java.util.Collection;
import javax.annotation.Nonnull;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;


/**
 * A class to format the data in different ways.
 */
public final class DataFormatter {

    /**
     * Private constructor to prevent instantiation.
     */
    private DataFormatter() {
        // empty
    }

    /**
     * Pretty print the data in a human readable format.
     * 
     * @param records the records to print
     * @param out the output stream to write to
     */
    private static void prettyPrint(Collection<Book> records, OutputStream out) {
        PrintStream pout = new PrintStream(out); // so i can use println
    }

    /**
     * Pretty print a single record.
     * 
     * @param record the record to print
     * @param out the output stream to write to
     */
    private static void prettySingle(@Nonnull Book record, @Nonnull PrintStream out) {


    }

    /**
     * Write the data as XML.
     * 
     * @param records the records to write
     * @param out the output stream to write to
     */
    private static void writeXmlData(Collection<Book> records, OutputStream out) {
        ObjectMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        BookXmlWrapper wrapper = new BookXmlWrapper(records);
        try {
            mapper.writeValue(out, wrapper);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Write the data as JSON.
     * 
     * @param records the records to write
     * @param out the output stream to write to
     */
    private static void writeJsonData(Collection<Book> records, OutputStream out) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            mapper.writeValue(out, records);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Write the data as CSV.
     * 
     * @param records the records to write
     * @param out the output stream to write to
     */
    private static void writeCSVData(Collection<Book> records, OutputStream out) {

    }

    /**
     * Write the data in the specified format.
     * 
     * @param records the records to write
     * @param format the format to write the records in
     * @param out the output stream to write to
     */
    public static void write(@Nonnull Collection<Book> records, @Nonnull Formats format,
            @Nonnull OutputStream out) {

        switch (format) {
            case XML:
                writeXmlData(records, out);
                break;
            case JSON:
                writeJsonData(records, out);
                break;
            case CSV:
                writeCSVData(records, out);
                break;
            default:
                prettyPrint(records, out);

        }
    }



}
