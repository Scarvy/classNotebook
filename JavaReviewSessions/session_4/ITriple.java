public interface ITriple<T, U, V> {


    T getFirstVar();

    U getSecondVar();

    V getThirdVar();

    void setFirstVar(T first);

    void setSecondVar(U second);

    void setThirdVar(V third);

}
