package smells;

public class Dispensables {
    /**
     * LAZY CLASS "Whole class is lazy. Adds no value. Middle Man can be seen as a
     * subset of Lazy Class"
     * Refactor: remove class
     */

    /**
     * SPECULATIVE GENERALITY "Adding what might be useful in the future and making
     * present job harder"
     * Refactor: remove class/statement/fields
     */

    /**
     * DATA CLASS. "Containers for data only + getters/setters/fields. No real methods"
     * Refactor: Extract?
     */

    /**
     * DUPLICATED CODE. 
     * Refactor: remove method/statement
     */
    public int areaBigSquare(int side){
        return side * side;
    }

    public int areaSmallSquare(int side){
        return side * side;
    }
}
