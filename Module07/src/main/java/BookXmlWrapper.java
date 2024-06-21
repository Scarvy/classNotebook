import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.Collection;

@JacksonXmlRootElement(localName = "catalog")
public final class BookXmlWrapper {
    /** List of the records. */
    @JacksonXmlElementWrapper(useWrapping = false)
    private Collection<Book> book;

    /**
     * Constructor.
     * 
     * @param records the records to wrap
     */
    public BookXmlWrapper(Collection<Book> records) {
        this.book = records;
    }


}
