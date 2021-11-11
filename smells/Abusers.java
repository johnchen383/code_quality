package smells;

public class Abusers {
    /**
     * ALTERNATIVE CLASSES WITH DIFFERENT INTERFACES "Different class and names
     * doing the same thing"
     */

    /**
     * TEMPORARY FIELD "Some class fields empty / redundant"
     */

    /**
     * SWITCH STATEMENTS "Or very long if statements cause scattering"
     * Refactor: better OOP, particularly polymorhpism
     */
    public class Person{
        int getCoolness(String name) {
            switch (name) {
            case "John":
                return 10;
            case "Joana":
                return 9;
            case "Jones":
                return 8;
            default:
                return -1;
            }
        }

        int getCoolness() {
            return -1;
        }
    }

    //realise not the best example to use 'John' for OOP but the idea holds
    public class John extends Person {
        int getCoolness() {
            return 10;
        }
    }

    /**
     * REFUSED BEQUEST "Subclass doesn't want or need behaviour from parent"
     * Refactor: Push down method to subclass from parent (or alter heirarchy)
     */
    public class Animal {
        public int getNumberOfLegs() throws Exception {
            return 4;
        }
    }

    public class Goldfish extends Animal {
        public int getNumberOfLegs() throws Exception {
            throw new Exception("Not implemented yet");
        }
    }
}
