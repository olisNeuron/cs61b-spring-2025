package lec8;
import lec8.AList;

public class WordUtil {
    public String longest(SLList<String> L) {
        int maxDex = 0;
        for (int i = 0;i < L.size();i+=1) {
            String thisString = L.get(i);
            String longestString = L.get(maxDex);
            if (thisString.length() > longestString.length()) {
                maxDex = i;
            }
        }
        return L.get(maxDex);
    }

    public String longest(AList<String> L) {
        int maxDex = 0;
        for (int i = 0;i < L.size();i+=1) {
            String thisString = L.get(i);
            String longestString = L.get(maxDex);
            if (thisString.length() > longestString.length()) {
                maxDex = i;
            }
        }
        return L.get(maxDex);
    }
}

