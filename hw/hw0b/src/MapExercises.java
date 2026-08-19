import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapExercises {
    /** Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        Map<Character, Integer> returnMap = new TreeMap<>();
        for(int i = 1; i <= 26; i ++) {
            char ch = (char)('a' + i - 1);
            returnMap.put(ch, i);
        }
        return returnMap;
    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        Map<Integer, Integer> returnMap = new TreeMap<>();
        for (int key : nums){
            int mapValue = key * key;
            returnMap.put(key, mapValue);
        }
        return returnMap;
    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> returnMap = new TreeMap<>();
        for(String word : words){
            /* word have not appeared yet.*/
            if(!returnMap.containsKey(word)) {
                returnMap.put(word, 1);
            }
            else { /* word have appeared*/
                int curr = returnMap.get(word);
                returnMap.put(word, curr+1);
            }
        }
        return returnMap;
    }
}
