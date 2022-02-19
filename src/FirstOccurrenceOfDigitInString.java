public class FirstOccurrenceOfDigitInString {

    public static void main(String[] args) {
        System.out.println(findFirstOccurrenceOfDigit("Var-----___1_int"));
        System.out.println(findFirstOccurrenceOfDigit("Q2q-q"));
        System.out.println(findFirstOccurrenceOfDigit("eef7243**s"));
    }

    public static String findFirstOccurrenceOfDigit(String inputString) {
        for (int i = 0; i < inputString.length(); i++) {
            if (Character.isDigit(inputString.charAt(i))) {
                return String.valueOf(inputString.charAt(i));
            }
        }
        return null;
    }
}
