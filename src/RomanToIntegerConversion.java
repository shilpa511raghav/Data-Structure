import java.util.HashMap;

public class RomanToIntegerConversion {
    public static void main(String[] args) {
        System.out.println("integer===  "+romanToIntConversion("MCMXCIV"));  //integer value = 1994
        System.out.println("integer===  "+romanToIntConversion("III"));     // 3
        System.out.println("integer===  "+romanToIntConversion("LVIII"));   //58
        System.out.println("integer===  "+romanToIntConversion("LIX"));     //59
    }

    public static Integer romanToIntConversionActual(String inputString){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);


        // Approach 1 doesnot work for all cases

       /* int number = 0;
        int prev = 0;

        for (int i=inputString.length()-1; i>= 0; i--) {

            int currentValue = map.get(inputString.charAt(i));

            if (prev != 0 && prev > currentValue) {
                number -= map.get(inputString.charAt(i));
            } else {
                number += map.get(inputString.charAt(i));
            }
            prev = currentValue;
        }
        return number;*/


        //approach 2
        int numberConverted = 0;
        for(int i=0; i<inputString.length();i++){
            if(i != inputString.length() -1 && map.get(inputString.charAt(i))<map.get(inputString.charAt(i+1))){
                numberConverted -= map.get(inputString.charAt(i));
            }else{
                numberConverted += map.get(inputString.charAt(i));
            }
        }
        return numberConverted;
    }


    public static String romanToIntConversion(String str){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);


        int convertedNum =0;
        for (int i= 0;i< str.length();i++){
            if(i!= str.length()-1){
                if( (map.get(str.charAt(i)) > map.get(str.charAt(i+1))) || ((map.get(str.charAt(i)) == map.get(str.charAt(i+1))))){
                    convertedNum += map.get(str.charAt(i));
                }else {
                    convertedNum -= map.get(str.charAt(i));
                }

            }else{
                convertedNum += map.get(str.charAt(i));
            }
        }
        return Integer.toString(convertedNum);
    }




}
