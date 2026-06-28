import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
    public static int sum(List<Integer> L) {
        // TODO: Fill in this function.
        int total = 0;
        for (int i = 0;i < L.size();i++) {
            total += L.get(i);
        }
        return total;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        // TODO: Fill in this function.
        ArrayList<Integer> evenList = new ArrayList<>();
        for (int i = 0;i < L.size();i++) {
            if (L.get(i) % 2 == 0) {
                evenList.add(L.get(i));
            }
        }
        return evenList;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        // TODO: Fill in this function.
        ArrayList<Integer> commonList = new ArrayList<>();
        for (int i = 0;i < L1.size();i++) {
            for (int j = 0;j < L2.size();j++) {
                if (L1.get(i) == L2.get(j)) {
                    commonList.add(L1.get(i));
                }
            }
        }
        return commonList;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        // TODO: Fill in this function.
        int count = 0;
        for (int i = 0;i < words.size();i++) {
            String currentString = words.get(i);
            for (int j = 0;j < currentString.length();j++) {
                if (currentString.charAt(j) == c) {
                    count++;
                }
            }
        }
        return count;
    }
}
