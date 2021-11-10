package smells;

public class Bloaters {

    /**
     * PRIMITIVE OBSESSION      "Everything's a primitive"
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
}

