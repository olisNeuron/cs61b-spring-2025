import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapExercises {
    /** Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        // TODO: Fill in this function.
        String alphaBet = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Integer> map = new TreeMap<>();
        for(int i = 0; i <= 25;i++) {
            map.put(alphaBet.charAt(i),i + 1);
        }
        return map;
    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        // TODO: Fill in this function.
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0;i < nums.size();i++) {
            map.put(nums.get(i),(int) Math.pow(nums.get(i),2));
        }
        return map;
    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        // TODO: Fill in this function.
        Map<String,Integer> count = new HashMap<>();
        int countNum = 0;
        for (int i = 0;i < words.size();i++){
            count.put(words.get(i), 0);
            for (int j = 0;j < words.size();j++){
                if(words.get(i) == words.get(j)) {
                    countNum++;
                    count.put(words.get(i), countNum);
                }
            }
            countNum = 0;
        }
        return count;
    }
}
