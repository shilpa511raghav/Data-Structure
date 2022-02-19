import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        /*System.out.println(validBracketsOrder("{}()[]"));
        System.out.println(validBracketsOrder("}{)(]["));
        System.out.println(validBracketsOrder("[{()}]"));
        System.out.println(validBracketsOrder("{(}())"));
        System.out.println(validBracketsOrder("{([])}"));*/



       /* System.out.println(validParanthes("{}()[]"));
        System.out.println(validParanthes("}{)(]["));
        System.out.println(validParanthes("[{()}]"));
        System.out.println(validParanthes("{(}())"));
        System.out.println(validParanthes("{([])}"));*/




        //System.out.println(validBracketsOrder("{}()[]"));
        /*System.out.println(validBracketsOrder("'}','{',')','(',']','['"));
        System.out.println(validBracketsOrder("'[','{','(',')','}',']'"));
        System.out.println(validBracketsOrder("'{','(','}','(',')',')'"));
        System.out.println(validBracketsOrder("'{','(','[',']',')','}'"));*/
    }

    //Actual code

    /*public static boolean validBracketsOrder(String s) {
        Stack<Character> stk = new Stack<>();
            if(s.length() % 2 !=0){
                return false;
            }else{
                for (int i =0;i<s.length();i++){
                    if(s.charAt(i) == '(' || s.charAt(i)== '{' || s.charAt(i)== '['){
                        stk.push(s.charAt(i));
                    }else if(s.charAt(i) == ')'|| s.charAt(i)=='}'||s.charAt(i)==']'){
                        if(stk.empty()){
                            return false;
                        }else{
                            Character ch = stk.pop();
                            if(!(ch== '(' && s.charAt(i) == ')') || !( ch == '{' && s.charAt(i)=='}')||(ch == '[' && s.charAt(i)==']')) {
                               continue;
                            }else{
                               return false;
                            }
                        }


                        }else{
                        return false;
                    }
                    }

            }
            return true;
    }
*/


    public static boolean validBracketsOrder(String s){
        Stack<Character>stk=new Stack<>();
        if(s.length()%2 != 0){
            return false;
        }else {
            for(Character each : s.toCharArray()){
                if(each == '{'|| each == '('|| each == '['){
                   stk.push(each);
                }else if(each == '}'|| each ==')'|| each == ']'){
                    if(stk.empty()){
                        return false;
                    }else{
                        Character ch = stk.pop();
                        if((ch == '{' && each == '}')|| (ch == '(' && each == ')')||(ch == '['&& each ==']' )){
                            continue;
                        }else{
                            return false;
                        }
                    }
                }else{
                    return false;
                }
            }

        }
        return true;
    }

}
