import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        int sum = 0;
        for(int key : L){
            sum += key;
        }
        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> returnList = new ArrayList<>();
        for(int key : L){
            if (key % 2 == 0){
                returnList.add((key));
            }
        }
        return returnList;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> returnList = new ArrayList<>();
        for(int key : L1){
            if(L2.contains(key)) returnList.add(key);
        }
        return returnList;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int cnt = 0;
        for(String word : words){
            for(int i = 0; i < word.length(); i ++){
                char ch = word.charAt(i);
                if(ch == c){
                    cnt ++;
                }
            }
        }
        return cnt;
    }
}
