package easy;

/**
 * Leetcode 14
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println("Longest Common Prefix  : " + longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        // Start with the first string as the initial prefix
        String starting = strs[0];
        // Iterate through the rest of the strings
        for (int i = 1; i < strs.length; i++) {
            // Check if the current string contains the current prefix at the beginning
            while (strs[i].indexOf(starting) != 0) {
                // If the prefix doesn't match, remove the last character from the prefix
                starting = starting.substring(0, starting.length() - 1);
                // If the prefix becomes empty, return an empty string
                if (starting.isEmpty()) {
                    return "";
                }
            }
        }
        return starting;
    }
}
