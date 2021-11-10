/**
 * Refactoring exercise from midterm test
 */
public class Midterm {
    /**
     * Original
     * 
     * @param phoneNumber
     * @return
     */
    public static boolean checkPhoneNumberValidityPoor(String phoneNumber) {

        // phone number must have 11 to 13 characters
        int n = phoneNumber.length();
        if (n < 11 || n > 13)
            return false;

        // email must have only numbers and -
        for (int i = 0; i < phoneNumber.length(); i++) {
            char ch = phoneNumber.charAt(i);
            if (!(Character.isDigit(ch) || ch == '-'))
                return false;
        }

        // email must have two -
        if (phoneNumber.split("-").length - 1 != 2)
            return false;

        return true;
    }

    //IMPROVED VERSION

    /**
     * Checks the validity of a given phone number
     * @param phoneNumber
     * @return
     */
    public static boolean checkPhoneNumberValidity(String phoneNumber) {
        return checkPhoneNumberLength(phoneNumber) && checkPhoneNumberValidCharacters(phoneNumber)
                && checkPhoneNumberHyphenCount(phoneNumber);
    }

    /**
     * Checks whether a phone number is the right length
     * @param phoneNumber
     * @return
     */
    private static boolean checkPhoneNumberLength(String phoneNumber) {
        final int MAX_NUMBER_LENGTH = 13;
        final int MIN_NUMBER_LENGTH = 11;

        int phoneNumberLength = phoneNumber.length();

        if (phoneNumberLength < MIN_NUMBER_LENGTH || phoneNumberLength > MAX_NUMBER_LENGTH) {
            return false;
        }

        return true;
    }

    /**
     * Checks whether the characters which comprise the phone number have valid characters
     * @param phoneNumber
     * @return
     */
    private static boolean checkPhoneNumberValidCharacters(String phoneNumber) {
        for (int i = 0; i < phoneNumber.length(); i++) {
            char character = phoneNumber.charAt(i);

            // if not a digit and not a hyphen
            if (!(Character.isDigit(character) || character == '-')) {
                return false;
            }
        }

        return true;
    }

    /**
     * Check the phone number has 2 hyphens in it
     * @param phoneNumber
     * @return
     */
    private static boolean checkPhoneNumberHyphenCount(String phoneNumber) {
        if (phoneNumber.split("-").length - 1 != 2) {
            return false;
        }

        return true;
    }

}
