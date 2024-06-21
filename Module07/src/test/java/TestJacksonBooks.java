
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.util.List;

import java.io.File;
import java.util.Set;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestJacksonBooks {


    @Test
    public void testJSONSerialize() {
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", 1937, "978-0618002214", "Fantasy");
        ObjectMapper mapper = new ObjectMapper();
        // mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            String json = mapper.writeValueAsString(book);
            System.out.println(json);
            assertEquals(
                    "{\"title\":\"The Hobbit\",\"author\":\"J.R.R. Tolkien\",\"year\":1937,\"bookIdentifier\":\"978-0618002214\",\"genre\":\"Fantasy\"}",
                    json);
        } catch (Exception e) {
            fail("Exception thrown during serialization");
        }
    }

    @Test
    public void testJSONDeserialize() {
        String json =
                "{\"title\":\"The Hobbit\",\"author\":\"J.R.R. Tolkien\",\"year\":1937,\"bookIdentifier\":\"978-0618002214\",\"genre\":\"Fantasy\"}";
        ObjectMapper mapper = new ObjectMapper();

        try {
            Book book = mapper.readValue(json, Book.class);
            System.out.println(book);

            assertEquals("The Hobbit", book.getTitle());
            assertEquals("J.R.R. Tolkien", book.getAuthor());
            assertEquals(1937, book.getYear());
            assertEquals("978-0618002214", book.getBookIdentifier());
            assertEquals("Fantasy", book.getGenre());
        } catch (Exception e) {
            fail("Exception thrown during deserialization");
        }

    }

    @Test
    public void testXMLSerialize() {
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", 1937, "978-0618002214", "Fantasy");
        ObjectMapper mapper = new XmlMapper();
        // mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            String xml = mapper.writeValueAsString(book);
            System.out.println(xml);
            assertEquals(
                    "<Book><title>The Hobbit</title><author>J.R.R. Tolkien</author><year>1937</year><bookIdentifier>978-0618002214</bookIdentifier><genre>Fantasy</genre></Book>",
                    xml);
        } catch (Exception e) {
            fail("Exception thrown during serialization");
        }
    }


    @Test
    public void testXMLDeserialize() {
        String xml =
                "<Book><title>The Hobbit</title><author>J.R.R. Tolkien</author><year>1937</year><bookIdentifier>978-0618002214</bookIdentifier><genre>Fantasy</genre></Book>";
        ObjectMapper mapper = new XmlMapper();

        try {
            Book book = mapper.readValue(xml, Book.class);
            System.out.println(book);

            assertEquals("The Hobbit", book.getTitle());
            assertEquals("J.R.R. Tolkien", book.getAuthor());
            assertEquals(1937, book.getYear());
            assertEquals("978-0618002214", book.getBookIdentifier());
            assertEquals("Fantasy", book.getGenre());
        } catch (Exception e) {
            fail("Exception thrown during deserialization");
        }
    }

    @Test
    public void testXMLDeserializeTwo() {
        String xml = """
                <book>
                   <author>Corets, Eva</author>
                   <title>Oberon's Legacy</title>
                   <genre>Fantasy</genre>
                   <price>5.95</price>
                   <publish_date>2001-03-10</publish_date>
                   <description>In post-apocalypse England, the mysterious
                   agent known only as Oberon helps to create a new life
                   for the inhabitants of London. Sequel to Maeve
                   Ascendant.</description>
                </book>
                """;
        ObjectMapper mapper = new XmlMapper();

        try {
            Book book = mapper.readValue(xml, Book.class);
            book.setBookIdentifier(
                    String.format("%s_%d", book.getTitle().charAt(0), book.hashCode()));
            System.out.println(book);
            assertEquals("Oberon's Legacy", book.getTitle());
        } catch (Exception e) {
            fail("Exception thrown during deserialization " + e.getMessage());

        }
    }

    @Test
    public void testReadXMLFileDeserialize() {
        File file = new File("data/core.xml");
        ObjectMapper mapper = new XmlMapper();

        try {
            Set<Book> books = mapper.readValue(file, new TypeReference<Set<Book>>() {});
            System.out.println(books);
            assertEquals(12, books.size());
        } catch (Exception e) {
            fail("Exception thrown during deserialization " + e.getMessage());
        }
    }

    @Test
    public void testWriteJSONFileSerialize() {
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", 1937, "978-0618002214", "Fantasy");
        Book book2 = new Book("The Fellowship of the Ring", "J.R.R. Tolkien", 1954,
                "978-0618002214", "Fantasy");
        List<Book> books = List.of(book, book2);


        try {
            // OutputStream os = new FileOutputStream("data/core_written.json");
            PrintStream save = System.out;

            OutputStream outCatch = new ByteArrayOutputStream();

            System.setOut(new PrintStream(outCatch));

            OutputStream os = new ByteArrayOutputStream();
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(os, books);

            String results = os.toString();
            // assertEquals("", results);
            System.out.println(results);

            System.setOut(save);

            System.out.println(outCatch.toString());


        } catch (Exception e) {
            fail("Exception thrown during deserialization " + e.getMessage());
        }
    }

}
