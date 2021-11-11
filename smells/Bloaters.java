package smells;

public class Bloaters {
    /**
     * Long Method
     */

    /**
     * Large Class
     */

    /**
     * Long parameter list
     */
    

    /**
     * PRIMITIVE OBSESSION      "Everything's a primitive"
     * Refactor: Introduce objects
     */
    public class Person {
        String name;
        String address;
        String password;
    
        public String getPostCode(){
            String postCode = address.substring(address.length() - 4);
            return postCode;
        }
    
        public String getLastName() {
            String lastName = name.substring(name.lastIndexOf(" ") + 1);
            return lastName;
        }
        
        public boolean checkPasswordLength() {
            return password.length() >= 8;
        }
    }

    /**
     * DATA CLUMPS          "Repeated passing of clumps of data"
     * Refactor: Introduce parameter object OR simplifying method calls
     */
    public abstract class DataClump{
        public abstract void connect(String host, int port, String username);
        public abstract void disconnect(String host, int port, String username);
        public abstract void checkConnectionStatus(String host, int port, String username);
    }
}

