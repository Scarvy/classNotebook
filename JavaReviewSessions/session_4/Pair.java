public class Pair<K, V> {

    // enclose the types in angle brackets

    // set our instance variables
    private K key;
    private V value;

    /**
     * Constructor for creating a new instance of a Pair.
     * @param key the key in the pair
     * @param value the value in the pair
     */
    public Pair(K key, V value) {

        // set the values for the instance variables
        this.key = key;
        this.value = value;

    }

    /**
     * Getter method for returning the key of a pair.
     * @return the key of a pair
     */
    public K getKey() {

        return this.key;

    }

    /**
     * Method for returning the value of a pair.
     * @return the value of a pair
     */
    public V getValue() {

        return this.value;

    }

    /**
     * Method for setting the key of a pair.
     * @param key the key to set it to
     */
    public void setKey(K key) {

        this.key = key;

    }

    /**
     * Method for setting the value of a pair.
     * @param value the value to set it to
     */
    public void setValue(V value) {

        this.value = value;
    }

    /**
     * Method for getting the string representation of a pair.
     * @return the string representation of a pair
     */
    @Override
    public String toString() {
        return "Pair: {key: " + key + ", value: " + value + "}";
    }

}
