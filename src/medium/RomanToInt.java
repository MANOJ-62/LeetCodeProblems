package medium;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {
        String s = "XI";
        System.out.println("Answer : " + romanToInt(s));
    }

    public static  int romanToInt(String s) {
        Map<Character, Integer> romans = new HashMap<>();
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);

        int result = romans.get(s.charAt(s.length()-1));

        for (int i=s.length()-2 ; i>=0; i--){
            if (!romans.containsKey(s.charAt(i))) return -1;
            if (romans.get(s.charAt(i)) >= romans.get(s.charAt(i+1))){
                result += romans.get(s.charAt(i));
            } else {
                result -= romans.get(s.charAt(i));
            }
        }
        return result;
    }
}
