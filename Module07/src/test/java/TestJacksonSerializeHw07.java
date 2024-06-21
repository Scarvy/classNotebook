import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import java.io.InputStream;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.util.List;


/**
 * This class helped test the various JSON serialization and deserialization for both JSON and XML.
 * 
 * You can use this to help better understand how to use the Jackson library.
 * 
 * References:
 * 
 * https://github.com/FasterXML/jackson-databind
 * 
 * https://github.com/FasterXML/jackson-dataformat-xml
 * 
 * https://github.com/FasterXML/jackson-dataformats-text/tree/master/csv
 * 
 */
public class TestJacksonSerializeHw07 {



    /**
     * Test serializing a record to JSON format. Serializing is the process of converting a record
     * to a set format (like JSON or XML).
     */
    @Test
    public void testSerialize() {
        TestIPBlock block =
                new TestIPBlock("0.0.0.0", "unknown", "madeup", "fantasy", "000000", -100, 25);
        String expected = """
                {"ip":"0.0.0.0",
                "city":"unknown",
                "region":"madeup",
                "country":"fantasy",
                "postal":"000000",
                "latitude":-100.0,
                "longitude":25.0
                }
                """.replace("\n", "");
        ObjectMapper mapper = new ObjectMapper();
        try {
            String actual = mapper.writeValueAsString(block);
            assertEquals(expected, actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test getting the data from the JSON format and converting it to a record.
     */
    @Test
    public void testDeserialize() {
        String json = """
                {"ip":"0.0.0.0",
                "city":"unknown",
                "region":"madeup",
                "country":"fantasy",
                "postal":"000000",
                "latitude":-100.0,
                "longitude":25.0
                }
                """.replace("\n", "");
        ObjectMapper mapper = new ObjectMapper();
        try {
            TestIPBlock expected =
                    new TestIPBlock("0.0.0.0", "unknown", "madeup", "fantasy", "000000", -100, 25);
            TestIPBlock block = mapper.readValue(json, TestIPBlock.class);
            System.out.println(block);// just so you can see that it does indeed add the record,
                                      // view in the debug console
            assertEquals(expected, block);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Failed to deserialize JSON string.");
        }
    }


    /**
     * Test getting the data from the JSON format and converting it to a record.
     */
    @Test
    public void testDeserializeGoogle() {
        String ip = "142.250.72.78";
        InputStream ioStream = NetUtils.getIpDetails(ip, Formats.JSON);
        ObjectMapper mapper = new ObjectMapper();
        try {
            TestIPBlock block = mapper.readValue(ioStream, TestIPBlock.class);
            System.out.println(block);// just so you can see that it does indeed add the record,
                                      // view in the debug console
            TestIPBlock expected = new TestIPBlock("142.250.72.78", "Plainview", "New York", "US",
                    "11803", 40.7746, -73.4761);
            assertEquals(expected, block);

        }

        catch (Exception e) {
            e.printStackTrace();
            fail("Failed to deserialize JSON string.");
        }
    }


    /**
     * Test getting the data from the XML format and converting it to a record.
     */
    @Test
    public void testDeserializeGoogleWithXML() {
        String ip = "142.250.72.78";
        InputStream ioStream = NetUtils.getIpDetails(ip, Formats.XML);
        ObjectMapper mapper = new XmlMapper();
        try {
            TestIPBlock block = mapper.readValue(ioStream, TestIPBlock.class);
            System.out.println(block);// just so you can see that it does indeed add the record,
                                      // view in the debug console
            TestIPBlock expected = new TestIPBlock("142.250.72.78", "Plainview", "New York", "US",
                    "11803", 40.7746, -73.4761);
            assertEquals(expected, block);

        } catch (Exception e) {
            e.printStackTrace();
            fail("Failed to deserialize JSON string.");
        }
    }


    /**
     * Test getting the data from the JSON format and converting it to a mutable class.
     *
     */
    @Test
    public void testDeserializeGithubWithBean() {
        String ip = "140.82.112.3";
        InputStream ioStream = NetUtils.getIpDetails(ip, Formats.JSON);
        ObjectMapper mapper = new ObjectMapper();
        try {
            TestBean block = mapper.readValue(ioStream, TestBean.class);
            block.setHostname("github.com"); // beans are 'mutable', and can have
                                             // extra fields
            System.out.println(block);// just so you can see that it does indeed add the bean,
                                      // view in the debug console
            TestBean expected = new TestBean("github.com", "140.82.112.3", "San Francisco",
                    "California", "US", "94110", 37.7509, -122.4153);
            assertEquals(expected, block);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Failed to deserialize JSON string.");
        }
    }

    /**
     * Test getting data from an xml that contains the option for multiple entries.
     */
    @Test
    public void testDeserializeMultipleEntries() {
        String xml = """
                <?xml version="1.0" encoding="UTF-8"  standalone="no"?>
                <domainList>
                    <domain>
                        <hostname>github.com</hostname>
                        <ip>140.82.112.3</ip>
                        <city>San Francisco</city>
                        <country>US</country>
                        <region>California</region>
                        <postal>94110</postal>
                        <latitude>37.7509</latitude>
                        <longitude>-122.4153</longitude>
                    </domain>
                    <domain>
                        <hostname>githubCOPY.com</hostname>
                        <ip>140.82.112.3</ip>
                        <city>San Francisco</city>
                        <country>US</country>
                        <region>California</region>
                        <postal>94110</postal>
                        <latitude>37.7509</latitude>
                        <longitude>-122.4153</longitude>
                    </domain>
                </domainList>
                """;

        ObjectMapper mapper = new XmlMapper();
        try {
            List<TestBean> beans = mapper.readValue(xml, new TypeReference<List<TestBean>>() {});
            List<TestBean> expected = List.of(
                    new TestBean("github.com", "140.82.112.3", "San Francisco", "California", "US",
                            "94110", 37.7509, -122.4153),
                    new TestBean("githubCOPY.com", "140.82.112.3", "San Francisco", "California",
                            "US", "94110", 37.7509, -122.4153));
            System.out.println(beans);// just so you can see that it does indeed add the bean,
                                      // view in the debug console
            assertEquals(expected, beans);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Failed to deserialize JSON string.");
        }

    }

    // the following are inner classes to help with testing/these examples.
    // you rarely keep records like this, but simple way to keep it with the test
    /**
     * A simple record to test serialization and deserialization. Records are immutable.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record TestIPBlock(String ip, String city, String region, String country, String postal,
            double latitude, double longitude) {
    }

    /**
     * A simple bean to test serialization and deserialization. Beans are mutable, and a fancy name
     * for a class that has getters and setters, and the default constructor.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TestBean {
        /** standard list of values. */
        private String hostname, ip, city, region, country, postal;
        /** double values. */
        private double latitude, longitude;

        /** Default/empty constructor. */
        public TestBean() {}

        /** Constructor that includes all the values. */
        public TestBean(String hostname, String ip, String city, String region, String country,
                String postal, double latitude, double longitude) {
            this.hostname = hostname;
            this.ip = ip;
            this.city = city;
            this.region = region;
            this.country = country;
            this.postal = postal;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        /**
         * get the hostname.
         * 
         * @return the hostname
         */
        public String getHostname() {
            return hostname;
        }

        /**
         * set the hostname.
         * 
         * @param hostname the hostname to set
         */
        public void setHostname(String hostname) {
            this.hostname = hostname;
        }

        /**
         * get the ip.
         * 
         * @return the ip
         */
        public String getIp() {
            return ip;
        }

        /**
         * set the ip.
         * 
         * @param ip the ip to set
         */
        public void setIp(String ip) {
            this.ip = ip;
        }

        /**
         * get the city.
         * 
         * @return the city
         */
        public String getCity() {
            return city;
        }

        /**
         * set the city.
         * 
         * @param city the city to set
         */
        public String setCity(String city) {
            return this.city = city;
        }

        /**
         * get the region.
         * 
         * @return the region
         */
        public String getRegion() {
            return region;
        }

        /**
         * set the region.
         * 
         * @param region the region to set
         */
        public String setRegion(String region) {
            return this.region = region;
        }

        /**
         * get the country.
         * 
         * @return the country
         */
        public String getCountry() {
            return country;
        }

        /**
         * set the country.
         * 
         * @param country the country to set
         */
        public String setCountry(String country) {
            return this.country = country;
        }

        /**
         * get the postal.
         * 
         * @return the postal
         */
        public String getPostal() {
            return postal;
        }

        /**
         * set the postal.
         * 
         * @param postal the postal to set
         */
        public String setPostal(String postal) {
            return this.postal = postal;
        }

        /**
         * get the latitude.
         * 
         * @return the latitude
         */
        public double getLatitude() {
            return latitude;
        }

        /**
         * set the latitude.
         * 
         * @param latitude the latitude to set
         */
        public double setLatitude(double latitude) {
            return this.latitude = latitude;
        }

        /**
         * get the longitude.
         * 
         * @return the longitude
         */
        public double getLongitude() {
            return longitude;
        }

        /**
         * set the longitude.
         * 
         * @param longitude the longitude to set
         */
        public double setLongitude(double longitude) {
            return this.longitude = longitude;
        }

        @Override
        public String toString() {
            return "TestBean [hostname=" + hostname + ", city=" + city + ", country=" + country
                    + ", ip=" + ip + ", latitude=" + latitude + ", longitude=" + longitude
                    + ", postal=" + postal + ", region=" + region + "]";
        }

        @Override
        public boolean equals(Object obj) {
            return EqualsBuilder.reflectionEquals(this, obj);
        }

        @Override
        public int hashCode() {
            return HashCodeBuilder.reflectionHashCode(this);
        }
    }

}
