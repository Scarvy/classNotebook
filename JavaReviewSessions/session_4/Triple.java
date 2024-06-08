public class Triple <T, U, V> implements ITriple<T, U, V> {

    // set the instance variables
    private T firstVar;
    private U secondVar;
    private V thirdVar;

    /**
     * Constructor for creating a new instance of a triple object.
     * @param firstVar the first var
     * @param secondVar the second var
     * @param thirdVar the third var
     */
    public Triple(T firstVar, U secondVar, V thirdVar) {

        this.firstVar = firstVar;
        this.secondVar = secondVar;
        this.thirdVar = thirdVar;

    }

    /**
     * Method for getting the first var in the triple
     * @return the first var in the triple
     */
    @Override
    public T getFirstVar() {
        return firstVar;

    }

    /**
     * Method for getting the second variable.
     * @return the second variable
     */
    @Override
    public U getSecondVar() {
        return secondVar;
    }

    /**
     * Method for getting the third variable.
     * @return the third variable
     */
    @Override
    public V getThirdVar() {
        return thirdVar;
    }

    public void setFirstVar(T firstVar) {
        this.firstVar = firstVar;
    }

    @Override
    public void setSecondVar(U second) {
        this.secondVar = second;
    }

    @Override
    public void setThirdVar(V third) {
        this.thirdVar = third;
    }

}
