package easy;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println("Longest Common Prefix  : " + longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String starting = strs[0];
        for (int i =1 ; i < strs.length; i++){
            while (strs[i].indexOf(starting)!=0){
                starting = starting.substring(0,starting.length()-1);
            }
        }
        return starting;
    }
}
