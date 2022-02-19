public class LastWordLength {
    public static void main(String[] args) {
        int len= lengthOfLastWord(" hello world mm    ");
        System.out.println(len);
    }

    public static int lengthOfLastWord(String s){
        String [] str = s.split("\\s+");

        return str[str.length -1].length();
    }

    public int lengthOfLastWordOptimal(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }
}
